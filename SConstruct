import os
import generate_templates

# godot-cpp/SConstruct reads its "build_profile" option from the global ARGUMENTS dict (via
# Variables(customs, ARGUMENTS)). A customs file like "custom.py" won't work here since its path
# is resolved relative to godot-cpp/SConstruct's own directory, not ours — so the default is
# injected directly into ARGUMENTS instead. setdefault() means an explicit
# `scons build_profile=...` on the command line still overrides this.
ARGUMENTS.setdefault("build_profile", "build_profile.json")
target_path = ARGUMENTS.pop("target_path", None)
target_name = ARGUMENTS.pop("target_name", "godot.jvm")

env = SConscript("godot-cpp/SConstruct")
java_home = os.environ["JAVA_HOME"]

# Generate templates when building the engine.
generate_templates.generate_header_from_files("kt/plugins/godot-intellij-plugin/src/main/resources/template", "cpp/editor/project/templates.h")

# Add those directory manually, so we can skip the godot_cpp directory when including headers in C++ files
source_path = [
    os.path.join("godot-cpp", "include", "godot_cpp"),
    os.path.join("godot-cpp", "gen", "include", "godot_cpp")
]
env.Append(CPPPATH=[env.Dir(d) for d in source_path])

# The GDExtensionScriptInstanceInfo3 setup (jvm_instance.h / jvm_placeholder_instance.h)
# is built with C++20 designated initializers.
if env.get("is_msvc", False):
    env.Append(CXXFLAGS=["/std:c++20"])
else:
    env.Append(CXXFLAGS=["-std=c++20"])


# For the reference:
# - CCFLAGS are compilation flags shared between C and C++
# - CFLAGS are for C-specific compilation flags
# - CXXFLAGS are for C++-specific compilation flags
# - CPPFLAGS are for pre-processor flags
# - CPPDEFINES are for pre-processor defines
# - LINKFLAGS are for linking flags

# tweak this if you want to use different folders, or more folders, to store your source code in.
env.Append(CPPPATH=["cpp/"])
sources = [
    Glob("cpp/*.cpp"),
    Glob("cpp/api/language/*.cpp"),
    Glob("cpp/api/resource_format/*.cpp"),
    Glob("cpp/api/script/*.cpp"),
    Glob("cpp/api/script/language/*.cpp"),
    Glob("cpp/core/*.cpp"),
    Glob("cpp/engine/*.cpp"),
    Glob("cpp/jvm/*.cpp"),
    Glob("cpp/jvm/jni/*.cpp"),
    Glob("cpp/jvm/lifecycle/*.cpp"),
    Glob("cpp/jvm/wrapper/*.cpp"),
    Glob("cpp/jvm/wrapper/bridge/*.cpp"),
    Glob("cpp/jvm/wrapper/memory/*.cpp"),
    Glob("cpp/jvm/wrapper/registration/*.cpp"),
    ]

if env["target"] == "editor":
    sources.append(Glob("cpp/editor/*.cpp"))
    sources.append(Glob("cpp/editor/project/*.cpp"))
    sources.append(Glob("cpp/editor/build/*.cpp"))
    sources.append(Glob("cpp/editor/ui/*.cpp"))
    sources.append(Glob("cpp/editor/export/*.cpp"))

# Android
if env["platform"] != "android":
    java_include_dirs = [
        java_home + "/include",
        java_home + "/include/linux",
        java_home + "/include/win32",
        java_home + "/include/darwin"
    ]
    env.Append(CPPPATH=[java_include_dirs])


# Mirrors utopia-rise/fmod-gdextension's demo/addons layout: the harness/tests Godot project
# (harness/tests/addons/jvm/) picks the library straight up via its .gdextension manifest, so a
# plain rebuild keeps that test project's extension up to date without a manual copy step.
default_target_path = "build/android/" if env["platform"] == "android" else "harness/tests/addons/jvm/libs/"
target_path = target_path or default_target_path
env["SHLIBPREFIX"] = ""

if env["platform"] == "android":
    android_abi = {
        "arm64": "arm64-v8a",
        "x86_64": "x86_64",
    }[env["arch"]]
    android_variant = "debug" if env["target"] == "template_debug" else "release"
    env["SHLIBPREFIX"] = "lib"
    library = env.SharedLibrary(
        "{}{}/{}/godot_jvm".format(target_path, android_variant, android_abi),
        source=sources,
    )
elif env["platform"] == "macos":
    library = env.SharedLibrary(
        "{}{}/{}.{}.{}.framework/{}.{}.{}".format(
            target_path, env["platform"], target_name, env["platform"], env["target"],
            target_name, env["platform"], env["target"]
        ),
        source=sources,
    )
elif env["platform"] == "ios":
    if env["ios_simulator"]:
        extension_library = env.StaticLibrary(
            "{}{}/{}.{}.{}.simulator.objects.a".format(target_path, env["platform"], target_name, env["platform"], env["target"]),
            source=sources,
        )
        output = "{}{}/{}.{}.{}.simulator.a".format(target_path, env["platform"], target_name, env["platform"], env["target"])
    else:
        extension_library = env.StaticLibrary(
            "{}{}/{}.{}.{}.objects.a".format(target_path, env["platform"], target_name, env["platform"], env["target"]),
            source=sources,
        )
        output = "{}{}/{}.{}.{}.a".format(target_path, env["platform"], target_name, env["platform"], env["target"])
    godot_cpp_library = env.File("godot-cpp/bin/libgodot-cpp{}{}".format(env["suffix"], env["LIBSUFFIX"]))
    library = env.Command(output, [extension_library, godot_cpp_library], "libtool -static -o $TARGET $SOURCES")
else:
    library = env.SharedLibrary(
        "{}{}/{}{}{}".format(target_path, env["platform"], target_name, env["suffix"], env["SHLIBSUFFIX"]),
        source=sources,
    )

# godot-cpp's own GodotCPP() tool already calls Default() for libgodot-cpp,
# which replaces SCons' default-target list. Re-add our own library so a
# bare `scons` invocation actually builds this module, not just godot-cpp.
Default(library)
