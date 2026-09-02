#include "dynamic_library.h"

#ifdef _WIN32
#include <windows.h>
#else
#include <dlfcn.h>
#endif

using namespace godot;

namespace godot_jvm_native {

Error open_dynamic_library(const String& p_path, void*& r_library_handle) {
#ifdef _WIN32
    r_library_handle = static_cast<void*>(LoadLibraryW(reinterpret_cast<LPCWSTR>(p_path.utf16().get_data())));
#else
    r_library_handle = dlopen(p_path.utf8().get_data(), RTLD_NOW);
#endif
    return r_library_handle != nullptr ? OK : FAILED;
}

Error close_dynamic_library(void* p_library_handle) {
    if (p_library_handle == nullptr) { return OK; }
#ifdef _WIN32
    return FreeLibrary(static_cast<HMODULE>(p_library_handle)) != 0 ? OK : FAILED;
#else
    return dlclose(p_library_handle) == 0 ? OK : FAILED;
#endif
}

Error get_dynamic_library_symbol_handle(void* p_library_handle, const char* p_symbol_name, void*& r_symbol_handle) {
#ifdef _WIN32
    r_symbol_handle = reinterpret_cast<void*>(GetProcAddress(static_cast<HMODULE>(p_library_handle), p_symbol_name));
#else
    r_symbol_handle = dlsym(p_library_handle, p_symbol_name);
#endif
    return r_symbol_handle != nullptr ? OK : FAILED;
}

} // namespace godot_jvm_native
