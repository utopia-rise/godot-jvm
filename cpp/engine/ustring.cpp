#include "ustring.h"

#include <classes/translation_server.hpp>
#include <classes/translation_domain.hpp>

namespace godot {

static constexpr const char* GODOT_EDITOR_DOMAIN = "godot.editor";

uint64_t hash64(const String& str) {
    /* simple djb2 hashing */

    const char32_t *chr = str.ptr();
    uint64_t hashv = 5381;
    uint64_t c = *chr++;

    while (c) {
        hashv = ((hashv << 5) + hashv) + c; /* hash * 33 + c */
        c = *chr++;
    }

    return hashv;
}

#ifdef TOOLS_ENABLED
String TTR(const String &p_text, const String& p_context) {
    if (TranslationServer::get_singleton()) {
        return TranslationServer::get_singleton()->get_or_add_domain(GODOT_EDITOR_DOMAIN)->translate(p_text, p_context);
    }

    return p_text;
}
#endif

String RTR(const String& p_text, const String& p_context) {
    if (TranslationServer::get_singleton()) {
        String rtr = TranslationServer::get_singleton()->get_or_add_domain(GODOT_EDITOR_DOMAIN)->translate(p_text, p_context);
        if (rtr.is_empty() || rtr == p_text) {
            return TranslationServer::get_singleton()->translate(p_text, p_context);
        }
        return rtr;
    }

    return p_text;
}

} // namespace godot