## Godot-JVM documentation

The documentation uses Markdown and [Material for MkDocs](https://squidfunk.github.io/mkdocs-material/). Pages live in `src/doc`, and `mkdocs.yml` defines their navigation order.

### Run locally

To preview the site locally:

1. Open a terminal.
2. Navigate to the `docs` directory from the project's root.
3. Execute these commands:

```shell
chmod +x run.sh
./run.sh
```
The script installs the Python dependencies in a virtual environment and starts the preview server. Run `mkdocs build --strict` in that environment to check the site before submitting changes.
