#include <core/os/file_access.h>
#include "kt_resource_format_saver.h"
#include "kotlin_language.h"
#include "kotlin_script.h"
#include "logging.h"

void KtResourceFormatSaver::get_recognized_extensions(const RES& p_resource, List<String>* p_extensions) const {
    if (Object::cast_to<KotlinScript>(p_resource.ptr())) {
        KotlinLanguage::get_instance().get_recognized_extensions(p_extensions);
    }
}

bool KtResourceFormatSaver::recognize(const RES& p_resource) const {
    return Object::cast_to<KotlinScript>(p_resource.ptr()) != nullptr;
}

Error KtResourceFormatSaver::save(const String& p_path, const RES& p_resource, uint32_t p_flags) {
    Ref<KotlinScript> script = p_resource;
    ERR_FAIL_COND_V(script.is_null(), ERR_INVALID_PARAMETER);
    String source = script->get_source_code();
    Error err;
    FileAccess *file = FileAccess::open(p_path, FileAccess::WRITE, &err);
    JVM_ERR_FAIL_COND_V_MSG(err != OK, err, "Cannot save Kotlin script file '" + p_path + "'.")
    file->store_string(source);

    if (file->get_error() != OK && file->get_error() != ERR_FILE_EOF) {
        memdelete(file);
        return ERR_CANT_CREATE;
    }

    file->close();
    memdelete(file);
    return OK;
}
