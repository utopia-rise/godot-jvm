"""Render the PNG logo sizes from logo-reference.svg (requires Inkscape and Pillow)."""
from pathlib import Path
import shutil
import subprocess
import tempfile

from PIL import Image, ImageFilter


directory = Path(__file__).resolve().parent
inkscape = shutil.which('inkscape.com') or shutil.which('inkscape')
if Path(r'C:\Program Files\Inkscape\bin\inkscape.com').exists():
    inkscape = r'C:\Program Files\Inkscape\bin\inkscape.com'
if not inkscape:
    raise SystemExit('Inkscape is required to render the SVG.')

with tempfile.TemporaryDirectory(prefix='godot-jvm-logo-') as temporary:
    rendered = Path(temporary) / 'render.png'
    subprocess.run([inkscape, str(directory / 'logo-reference.svg'),
                    f'--export-filename={rendered}', '--export-width=2048'], check=True)
    master = Image.open(rendered).convert('RGBA')
    sizes = (128, 256, 512, 1024)
    for size in sizes:
        master.resize((size, size), Image.Resampling.LANCZOS).save(directory / f'logo-{size}.png')

    # The outlined version is reserved for surfaces where the indigo silhouette
    # needs extra contrast, such as the documentation header.
    inset = master.resize((1984, 1984), Image.Resampling.LANCZOS)
    padded = Image.new('RGBA', (2048, 2048))
    padded.alpha_composite(inset, (32, 32))
    outline = Image.new('RGBA', padded.size, '#EAF6FF')
    outline.putalpha(padded.getchannel('A').filter(ImageFilter.MaxFilter(25)))
    outline.alpha_composite(padded)
    outline.resize((1024, 1024), Image.Resampling.LANCZOS).save(directory / 'logo-1024-outline.png')

print('Exported PNG logo sizes:', ', '.join(map(str, sizes)), 'and outlined 1024px logo')
