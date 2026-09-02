#ifndef GODOT_JVM_USTRING_H
#define GODOT_JVM_USTRING_H

#include <variant/string.hpp>

namespace godot {
    // https://github.com/godotengine/godot/blob/841596cae4ddf97d67dc253021347bc01863f00f/core/string/ustring.cpp#L2960
    uint64_t hash64(const String& str);

#ifdef TOOLS_ENABLED
    // https://github.com/godotengine/godot/blob/841596cae4ddf97d67dc253021347bc01863f00f/core/string/ustring.cpp#L5844
    String TTR(const String& p_text, const String& p_context = "");
#endif

    // https://github.com/godotengine/godot/blob/841596cae4ddf97d67dc253021347bc01863f00f/core/string/ustring.cpp#L5926
    String RTR(const String& p_text, const String& p_context = "");
}

#endif // GODOT_JVM_USTRING_H
