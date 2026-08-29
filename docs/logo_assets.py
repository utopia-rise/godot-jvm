from pathlib import Path

from mkdocs.structure.files import File


def on_files(files, config):
    repository_root = Path(config.config_file_path).parent.parent
    for name in ("logo.png", "logo-outline.png", "favicon.ico"):
        files.append(
            File(
                f"logo/{name}",
                str(repository_root),
                config.site_dir,
                config.use_directory_urls,
            )
        )
    return files
