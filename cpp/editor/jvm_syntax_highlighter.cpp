#include "jvm_syntax_highlighter.h"

#ifdef TOOLS_ENABLED

#include "api/language/names.h"

#include <classes/editor_interface.hpp>
#include <classes/editor_settings.hpp>
#include <classes/script.hpp>
#include <classes/script_editor.hpp>
#include <classes/script_extension.hpp>
#include <classes/script_language_extension.hpp>
#include <classes/text_edit.hpp>
#include <core/object.hpp>

using namespace godot;

namespace {
    inline bool is_identifier_start(char32_t c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '_';
    }

    inline bool is_identifier_char(char32_t c) {
        return is_identifier_start(c) || (c >= '0' && c <= '9');
    }

    // Matches master's own delimiter format: "begin end" (space-separated), or just "begin" for a to-end-of-line region — same parsing EditorStandardSyntaxHighlighter::_update_cache() does.
    void parse_delimiters(const PackedStringArray& delimiters, const Color& color, Vector<SyntaxRegion>& out) {
        for (const String& delimiter : delimiters) {
            String begin = delimiter.get_slicec(' ', 0);
            String end = delimiter.get_slice_count(" ") > 1 ? delimiter.get_slicec(' ', 1) : String();
            out.push_back({begin, end, end.is_empty(), color});
        }
    }

    // Returns the first region (in priority order) whose begin marker matches the line at p_index.
    const SyntaxRegion* match_region(const Vector<SyntaxRegion>& regions, const String& line, int64_t p_index) {
        for (const SyntaxRegion& region : regions) {
            if (line.substr(p_index, region.begin.length()) == region.begin) { return &region; }
        }
        return nullptr;
    }
}

String JvmStandardSyntaxHighlighter::_get_name() const {
    return "Godot-JVM";
}

PackedStringArray JvmStandardSyntaxHighlighter::_get_supported_languages() const {
    return {GODOT_JVM_LANGUAGE_NAME, GODOT_KOTLIN_LANGUAGE_NAME, GODOT_JAVA_LANGUAGE_NAME, GODOT_SCALA_LANGUAGE_NAME};
}

Ref<EditorSyntaxHighlighter> JvmStandardSyntaxHighlighter::_create() const {
    Ref<JvmStandardSyntaxHighlighter> result;
    result.instantiate();
    return result;
}

void JvmStandardSyntaxHighlighter::_update_cache() {
    keywords.clear();
    regions.clear();

    // Fallback palette in case EditorSettings is ever unavailable; overwritten below otherwise.
    keyword_color = Color(0.45f, 0.62f, 0.91f);
    Color comment_color(0.5f, 0.5f, 0.5f);
    Color string_color(0.92f, 0.72f, 0.42f);
    default_color = Color(0.85f, 0.85f, 0.85f);

    if (Ref<EditorSettings> settings = EditorInterface::get_singleton()->get_editor_settings(); settings.is_valid()) {
        keyword_color = settings->get_setting("text_editor/theme/highlighting/keyword_color");
        comment_color = settings->get_setting("text_editor/theme/highlighting/comment_color");
        string_color = settings->get_setting("text_editor/theme/highlighting/string_color");
    }

    // No `_get_edited_resource()`/`_set_script_language()` in godot-cpp (unlike master's base class), so the currently-focused script tab is the closest available signal for "which language is this highlighter instance highlighting."
    Ref<Script> script = EditorInterface::get_singleton()->get_script_editor()->get_current_script();
    auto* script_ext = script.is_valid() ? Object::cast_to<ScriptExtension>(script.ptr()) : nullptr;
    auto* lang = script_ext ? Object::cast_to<ScriptLanguageExtension>(script_ext->_get_language()) : nullptr;
    if (lang == nullptr) { return; }

    for (const String& keyword : lang->_get_reserved_words()) {
        keywords.insert(keyword);
    }
    parse_delimiters(lang->_get_comment_delimiters(), comment_color, regions);
    parse_delimiters(lang->_get_string_delimiters(), string_color, regions);
}

Dictionary JvmStandardSyntaxHighlighter::_get_line_syntax_highlighting(int32_t p_line) const {
    Dictionary color_map;

    TextEdit* text_edit = get_text_edit();
    if (text_edit == nullptr) { return color_map; }

    String line = text_edit->get_line(p_line);
    int64_t length = line.length();

    auto set_color_at = [&](int64_t column, const Color& color) {
        Dictionary entry;
        entry["color"] = color;
        color_map[column] = entry;
    };

    int64_t i = 0;
    while (i < length) {
        if (const SyntaxRegion* region = match_region(regions, line, i)) {
            set_color_at(i, region->color);
            if (region->line_only) { break; }
            int64_t end = line.find(region->end, i + region->begin.length());
            i = end == -1 ? length : end + region->end.length();
            if (i < length) { set_color_at(i, default_color); }
            continue;
        }

        char32_t c = line[i];
        if (is_identifier_start(c)) {
            int64_t start = i;
            int64_t j = i + 1;
            while (j < length && is_identifier_char(line[j])) {
                j++;
            }
            if (keywords.has(line.substr(start, j - start))) {
                set_color_at(start, keyword_color);
                if (j < length) { set_color_at(j, default_color); }
            }
            i = j;
            continue;
        }

        i++;
    }

    return color_map;
}

void JvmStandardSyntaxHighlighter::_bind_methods() {}

#endif
