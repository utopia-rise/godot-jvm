#include "source_script_parser.h"

#include "api/language/names.h"
#include "logging.h"

#include <classes/file_access.hpp>

namespace godot {
Error read_source_script_file(const String& p_path, String& r_content) {
    const Ref<FileAccess> file_access {FileAccess::open(p_path, FileAccess::READ)};
    const Error err = FileAccess::get_open_error();
    JVM_ERR_FAIL_COND_V_MSG(err != OK, err, "Cannot open file '" + p_path + "'.");
    const String source = file_access->get_as_text();

    r_content = source;
    return OK;
}

namespace {
constexpr const char* PACKAGE_KEYWORD = "package";
constexpr const char* CLASS_KEYWORD = "class";
constexpr const char* SCRIPT_ANNOTATION = "@Script";

StringName get_gdj_fq_name(const String& source) {
    for (const String& line : source.split("\n")) {
        const int separator = line.find("=");
        if (separator < 0 || line.left(separator).strip_edges() != "fqName") { continue; }

        const String fq_name = line.substr(separator + 1).strip_edges();
        return fq_name.is_empty() ? StringName() : StringName(fq_name);
    }
    return {};
}

_FORCE_INLINE_ bool is_end_of_source(const String& source, int index) {
    return index >= source.length();
}

bool is_identifier_character(char32_t character) {
    return (character >= U'0' && character <= U'9')
        || (character >= U'A' && character <= U'Z')
        || (character >= U'a' && character <= U'z')
        || character == U'_';
}

bool is_whitespace_or_linebreak(char32_t character) {
    return is_whitespace(character) || is_linebreak(character);
}

bool is_package_end(char32_t character) {
    return is_whitespace_or_linebreak(character) || character == U';' || character == U'/';
}

// Whitespace not always follows class names in valid Kotlin/Java/Scala declarations.
// Keep these delimiters so compact forms such as:
// - class Foo: Node()
// - class Foo<T>
// - class Foo()
// - class Foo{
// - class Foo /* ... */
// still stop exactly after "Foo".
bool is_class_name_end(char32_t character) {
    return is_whitespace_or_linebreak(character)
        || character == U':'
        || character == U'{'
        || character == U'<'
        || character == U'['
        || character == U'('
        || character == U'/';
}

bool skip_non_code_once(const String& source, int& index) {
    char32_t next_character = source[index];
    // Collapse any contiguous whitespace/newline run into one skip step.
    if (is_whitespace_or_linebreak(next_character)) {
        do {
            next_character = source[++index];
        } while (!is_end_of_source(source, index) && is_whitespace_or_linebreak(next_character));
        return true;
    }

    // At this point we already know the current character is not whitespace or new line.
    // comments must start with '/', so anything else is regular source code.
    if (next_character != U'/' || index >= source.length() - 1) {
        return false;
    }

    next_character = source[++index];
    // We already identified a leading '/', so a second '/' means we are inside a
    // single-line comment and can skip until the next line break.
    if (next_character == U'/') {
        while (!is_end_of_source(source, index) && !is_linebreak(next_character)) {
            next_character = source[++index];
        }
        return true;
    }

    // We already identified a leading '/' and previously tested for the '//' case; if the next character is not '*',
    // then this '/' does not start any supported comment form.
    if (next_character != U'*') {
        return false;
    }

    // We already identified the opening '/*', so skip until the matching closing '*/'.
    while (!is_end_of_source(source, index)) {
        bool is_comment_end = next_character == U'*';
        next_character = source[++index];

        if (is_end_of_source(source, index)) {
            JVM_LOG_WARNING("Cannot parse source, found unclosed multiline comment");
        }

        if (is_comment_end && next_character == U'/') {
            ++index;
            break;
        }
    }
    return true;
}

void skip_non_code(const String& source, int& index) {
    while (!is_end_of_source(source, index) && skip_non_code_once(source, index)) {}
}

bool matches_keyword_at(const String& source, int index, const String& keyword) {
    const int keyword_size = keyword.length();
    if (index < 0 || index + keyword_size > source.length()) {
        return false;
    }

    for (int i = 0; i < keyword_size; ++i) {
        if (source[index + i] != keyword[i]) {
            return false;
        }
    }

    const bool has_previous_character = index > 0;
    if (has_previous_character && is_identifier_character(source[index - 1])) {
        return false;
    }

    const int next_index = index + keyword_size;
    const bool has_next_character = next_index < source.length();
    if (has_next_character && is_identifier_character(source[next_index])) {
        return false;
    }

    return true;
}

int find_token(const String& source, int start_index, const String& token, bool exact_word) {
    while (!is_end_of_source(source, start_index)) {
        skip_non_code(source, start_index);
        if (is_end_of_source(source, start_index)) {
            return -1;
        }

        if (exact_word) {
            if (matches_keyword_at(source, start_index, token)) {
                return start_index;
            }
        } else if (source.find(token, start_index) == start_index) {
            return start_index;
        }

        ++start_index;
    }

    return -1;
}

String get_package_name(const String& source, int& r_register_class_search_start) {
    static String package_keyword {PACKAGE_KEYWORD};
    int package_keyword_index = find_token(source, 0, package_keyword, true);
    if (package_keyword_index == -1) {
        r_register_class_search_start = 0;
        return "";
    }

    int package_index = package_keyword_index + package_keyword.length();
    skip_non_code(source, package_index);

    char32_t next_character = source[package_index];
    int package_end_index = package_index;
    while (!is_end_of_source(source, package_end_index) && !is_package_end(next_character)) {
        next_character = source[++package_end_index];
    }

    r_register_class_search_start = package_end_index;
    return source.substr(package_index, package_end_index - package_index);
}

void skip_annotation_arguments(const String& source, int annotation_index, const String& annotation, int& r_class_search_index) {
    int current_index = annotation_index + annotation.length();
    skip_non_code(source, current_index);

    if (is_end_of_source(source, current_index) || source[current_index] != U'(') {
        r_class_search_index = current_index;
        return;
    }

    int depth = 0;
    while (!is_end_of_source(source, current_index)) {
        const char32_t current_character = source[current_index];
        if (current_character == U'(') {
            ++depth;
        } else if (current_character == U'"') {
            ++current_index;
            while (!is_end_of_source(source, current_index)) {
                if (source[current_index] == U'"' && source[current_index - 1] != U'\\') { break; }
                ++current_index;
            }

            if (is_end_of_source(source, current_index)) {
                JVM_LOG_WARNING("Cannot parse @Script argument, found unclosed string literal");
                r_class_search_index = source.length();
                return;
            }
        } else if (current_character == U')') {
            --depth;
            if (depth == 0) {
                ++current_index;
                break;
            }
        }
        ++current_index;
    }

    skip_non_code(source, current_index);
    r_class_search_index = current_index;
}

String find_class_name(const String& source, int search_start, const String& expected_name = {}) {
    static String class_keyword {CLASS_KEYWORD};
    int class_keyword_index = find_token(source, search_start, class_keyword, true);
    while (class_keyword_index != -1) {
        int class_index = class_keyword_index + class_keyword.length();
        skip_non_code(source, class_index);
        if (is_end_of_source(source, class_index)) { return {}; }

        int class_end_index = class_index;
        while (!is_end_of_source(source, class_end_index) && !is_class_name_end(source[class_end_index])) {
            ++class_end_index;
        }

        String class_name = source.substr(class_index, class_end_index - class_index);
        if (expected_name.is_empty() || class_name == expected_name) { return class_name; }
        class_keyword_index = find_token(source, class_keyword_index + class_keyword.length(), class_keyword, true);
    }
    return {};
}
} // namespace

#ifdef TOOLS_ENABLED
StringName parse_source_script_fqname(const String& p_source_code, const String& p_source_path) {
    if (p_source_code.is_empty()) { return {}; }
    if (p_source_path.get_extension().to_lower() == GODOT_JVM_REGISTRATION_FILE_EXTENSION) {
        return get_gdj_fq_name(p_source_code);
    }

    int class_search_start = 0;
    String package_name = get_package_name(p_source_code, class_search_start);
    static String script_annotation {SCRIPT_ANNOTATION};

    String class_name;
    const int annotation_index = find_token(p_source_code, class_search_start, script_annotation, true);
    if (annotation_index != -1) {
        int annotated_class_search_start = 0;
        skip_annotation_arguments(p_source_code, annotation_index, script_annotation, annotated_class_search_start);
        class_name = find_class_name(p_source_code, annotated_class_search_start);
    }

    if (class_name.is_empty()) {
        const String file_class_name = p_source_path.get_file().get_basename();
        if (!file_class_name.is_empty()) {
            class_name = find_class_name(p_source_code, class_search_start, file_class_name);
        }
    }

    if (class_name.is_empty()) { return {}; }

    const String fq_name = package_name.is_empty()
                             ? class_name
                             : vformat("%s.%s", package_name, class_name);
    return StringName(fq_name);
}
#else
StringName parse_source_script_fqname(const String& p_source_code, const String& p_source_path) {
    if (p_source_code.is_empty()) { return {}; }

    (void)p_source_path;
    const String fq_name = p_source_code.strip_edges();
    return fq_name.is_empty() ? StringName() : StringName(fq_name);
}
#endif

} // namespace godot

