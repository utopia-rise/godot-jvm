import base64
import os

# Define maximum length for each chunk
MAX_CHUNK_SIZE = 8 * 1024  # 8KB

def encode_file_to_base64(file_path, is_binary):
    """Encode the content of a file to a Base64 string."""
    with open(file_path, 'rb') as file:
        file_content = file.read()
        if not is_binary:
            file_content = file_content.replace(b'\r\n', b'\n').replace(b'\r', b'\n')
        encoded_content = base64.b64encode(file_content).decode('utf-8')
    return encoded_content

def split_string_into_chunks(string, chunk_size):
    """Split a string into chunks of a specified size."""
    return [string[i:i + chunk_size] for i in range(0, len(string), chunk_size)]

def generate_header_from_files(directory, header_file):
    """Generate a C++ header file with Base64 encoded file contents from a directory and subdirectories."""
    file_names = []
    file_contents = []
    file_is_binary = []

    with open(header_file, 'w') as header:
        header.write(f'// Auto-generated templates from {directory} directory \n\n')
        header.write("#ifndef FILE_CONTENTS_H\n")
        header.write("#define FILE_CONTENTS_H\n\n")

        for root, dirs, files in os.walk(directory):
            dirs.sort()
            for file_name in sorted(files):
                # Only process files with .template or .godot_template extensions
                if not(file_name.endswith('.template')) and not(file_name.endswith('.godot_template')):
                    continue

                # Compute relative path
                relative_path = os.path.relpath(os.path.join(root, file_name), directory)
                is_binary = file_name.endswith('.jar.template')
                encoded_content = encode_file_to_base64(os.path.join(root, file_name), is_binary)

                # Split the encoded content into chunks
                chunks = split_string_into_chunks(encoded_content, MAX_CHUNK_SIZE)

                # Create the variable names
                final_file_name = relative_path.replace('.template', '').replace('.godot_template', '').replace('\\', '/')
                var_name = final_file_name.replace('.', '_').replace('-', '_').replace('/', '_').replace('__', '_')
                name_var_name = f"{var_name}_file_name"
                file_var_name = f"{var_name}_file_content"

                file_names.append(name_var_name)
                file_contents.append(file_var_name)
                file_is_binary.append('true' if is_binary else 'false')

                # Write the file name constant
                header.write(f'constexpr const char* {name_var_name} = R"({final_file_name})";\n')
                # Write the chunks with automatic concatenation
                header.write(f'constexpr const char* {file_var_name} = ')
                if chunks:
                    chunk_lines = [f'"{chunk}"' for chunk in chunks]
                else:
                    chunk_lines = ['""']
                header.write(' '.join(chunk_lines) + ';\n\n')

        # Generate arrays for file names and contents
        header.write(f'constexpr const int number_of_files = {len(file_names)};\n')

        header.write('constexpr const bool file_is_binary[] = {')
        header.write(', '.join(file_is_binary))
        header.write('};\n')

        header.write('constexpr const char* file_names[] = {')
        header.write(', '.join(file_names))
        header.write('};\n')

        header.write('constexpr const char* file_contents[] = {')
        header.write(', '.join(file_contents))
        header.write('};\n\n')

        header.write("#endif // FILE_CONTENTS_H\n\n")

    print(f"{header_file} generated successfully.")

if __name__ == "__main__":
    directory = "kt/plugins/godot-intellij-plugin/src/main/resources/template"  # Change this to your relative directory
    header_file = "cpp/editor/project/templates.h"  # Output header file name
    generate_header_from_files(directory, header_file)
