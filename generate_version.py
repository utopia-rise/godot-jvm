import re


def read_catalog_version(version_catalog, key):
    with open(version_catalog) as catalog:
        return re.search(rf'^{key}\s*=\s*"([^"]+)"', catalog.read(), re.MULTILINE).group(1)


def godot_api_version(version_catalog):
    return ".".join(read_catalog_version(version_catalog, "godot").split(".")[:2])


def generate_version_header(version_catalog, header_file):
    """Generate a C++ header holding the Godot-JVM version declared as godotJvm in the version catalog."""
    version = read_catalog_version(version_catalog, "godotJvm")

    with open(header_file, 'w') as header:
        header.write(f'// Auto-generated from godotJvm in {version_catalog}. Do not edit by hand.\n\n')
        header.write("#ifndef GODOT_JVM_VERSION_H\n")
        header.write("#define GODOT_JVM_VERSION_H\n\n")
        header.write(f'constexpr const char* GODOT_JVM_VERSION = "{version}";\n\n')
        header.write("#endif // GODOT_JVM_VERSION_H\n")


if __name__ == "__main__":
    generate_version_header("kt/gradle/libs.versions.toml", "cpp/version.h")
