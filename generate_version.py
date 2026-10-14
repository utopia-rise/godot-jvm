import re


def generate_version_header(version_catalog, header_file):
    """Generate a C++ header holding the Godot-JVM version declared as godotJvm in the version catalog."""
    with open(version_catalog) as catalog:
        version = re.search(r'^godotJvm\s*=\s*"([^"]+)"', catalog.read(), re.MULTILINE).group(1)

    with open(header_file, 'w') as header:
        header.write(f'// Auto-generated from godotJvm in {version_catalog}. Do not edit by hand.\n\n')
        header.write("#ifndef GODOT_JVM_VERSION_H\n")
        header.write("#define GODOT_JVM_VERSION_H\n\n")
        header.write(f'constexpr const char* GODOT_JVM_VERSION = "{version}";\n\n')
        header.write("#endif // GODOT_JVM_VERSION_H\n")


if __name__ == "__main__":
    generate_version_header("kt/gradle/libs.versions.toml", "cpp/version.h")
