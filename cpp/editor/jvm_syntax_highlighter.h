#pragma once

#ifdef TOOLS_ENABLED

#include <classes/editor_syntax_highlighter.hpp>
#include <templates/hash_set.hpp>
#include <templates/vector.hpp>
#include <variant/color.hpp>
#include <variant/dictionary.hpp>
#include <variant/packed_string_array.hpp>
#include <variant/string.hpp>

namespace godot {
    // NOTE: master's version subclassed the engine-internal `EditorStandardSyntaxHighlighter`, which has no GDExtension equivalent and internally wraps a `CodeHighlighter`. A standalone `CodeHighlighter` can't substitute for it here: `set_text...
    struct SyntaxRegion {
        String begin;
        String end;
        bool line_only;
        Color color;
    };

    class JvmStandardSyntaxHighlighter : public EditorSyntaxHighlighter {
        GDCLASS(JvmStandardSyntaxHighlighter, EditorSyntaxHighlighter)

        HashSet<String> keywords;
        Vector<SyntaxRegion> regions; // comment and string regions, in match-priority order.

        Color keyword_color;
        Color default_color;

    public:
        String _get_name() const override;
        PackedStringArray _get_supported_languages() const override;
        Ref<EditorSyntaxHighlighter> _create() const override;
        void _update_cache() override;
        Dictionary _get_line_syntax_highlighting(int32_t p_line) const override;

    protected:
        static void _bind_methods();
    };
} // namespace godot

#endif
