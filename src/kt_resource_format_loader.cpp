#include <core/os/file_access.h>
#include "kt_resource_format_loader.h"
#include "kotlin_language.h"
#include "kotlin_script.h"
#include "logging.h"

Error kt_read_all_file_utf8(const String &p_path, String &r_content) {
    PoolVector<uint8_t> sourcef;
    Error err;
    FileAccess *f = FileAccess::open(p_path, FileAccess::READ, &err);
    logging::error(err != OK, &err, "Cannot open file '" + p_path + "'.");

    int len = f->get_len();
    sourcef.resize(len + 1);
    PoolVector<uint8_t>::Write w = sourcef.write();
    int r = f->get_buffer(w.ptr(), len);
    f->close();
    memdelete(f);
    ERR_FAIL_COND_V(r != len, ERR_CANT_OPEN);
    w[len] = 0;

    String source;
    if (source.parse_utf8((const char *)w.ptr())) {
        ERR_FAIL_V(ERR_INVALID_DATA);
    }

    r_content = source;
    return OK;
}

RES KtResourceFormatLoader::load(const String& p_path, const String& p_original_path, Error* r_error) {
    Ref<KotlinScript> ref {memnew(KotlinScript)};
    ref->set_path(p_original_path);
    ref->reload(false);

    String source_code;
    Error load_err = kt_read_all_file_utf8(p_original_path, source_code);
#if defined(DEBUG_ENABLED) || defined(TOOLS_ENABLED)
    ref->set_source_code(source_code);
#endif

    if (r_error) {
        *r_error = load_err;
    }
    return ref;
}

void KtResourceFormatLoader::get_recognized_extensions(List<String>* p_extensions) const {
    KotlinLanguage::get_instance().get_recognized_extensions(p_extensions);
}

bool KtResourceFormatLoader::handles_type(const String& p_type) const {
    return p_type == "Script" || p_type == KotlinLanguage::get_instance().get_type();
}

String KtResourceFormatLoader::get_resource_type(const String& p_path) const {
    return p_path.get_extension().to_lower() == "kt" ? KotlinLanguage::get_instance().get_type() : "";
}
