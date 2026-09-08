#ifndef GODOT_JVM_SOURCE_SCRIPT_PARSER_H
#define GODOT_JVM_SOURCE_SCRIPT_PARSER_H

#include <classes/global_constants.hpp>
#include <variant/string.hpp>
#include <variant/string_name.hpp>

namespace godot {
    Error read_source_script_file(const String& p_path, String& r_content);
    StringName parse_source_script_fqname(const String& p_source_code, const String& p_source_path);
} // namespace godot

#endif // GODOT_JVM_SOURCE_SCRIPT_PARSER_H
