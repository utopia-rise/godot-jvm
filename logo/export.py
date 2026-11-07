"""Regenerate every logo asset. Usage: python export.py

1. From logo-reference.svg into highres/: SVG copies with a fixed declared size, the PNG
   sizes, and the outlined 1024px logo. From language/*.svg (CC0 simple-icons marks): 512px
   PNGs. pixel/ holds the hand-drawn 32 and 64px pixel-art logos and is not generated.
   This step needs Inkscape. Without it the committed PNGs are kept and only step 2 runs.
2. The Godot Asset Store images in store/ (1920x1080, 16:9) from highres/logo-1024-outline.png and
   the language PNGs. Needs the Rubik Bold and Source Sans Pro Semibold fonts (both OFL, on
   Google Fonts), either installed or in the directory named by GODOT_JVM_FONT_DIR.

Requires Python 3.9+ and Pillow (python -m pip install Pillow) on Windows, Linux and macOS.
"""
import os
import platform
import shutil
import subprocess
import sys
import xml.etree.ElementTree as ElementTree
from pathlib import Path

try:
    from PIL import Image, ImageDraw, ImageFont, ImageFilter
except ImportError:
    sys.exit('Pillow is required: python -m pip install Pillow')

DIRECTORY = Path(__file__).resolve().parent
REFERENCE_SVG = DIRECTORY / 'logo-reference.svg'
HIGHRES = DIRECTORY / 'highres'
LANGUAGE = DIRECTORY / 'language'
STORE = DIRECTORY / 'store'

SVG_SIZES = (16, 40)
PNG_SIZES = (128, 256, 512, 1024)
MASTER_SIZE = 2048
LANGUAGE_PNG_SIZE = 512
LANGUAGES = (('kotlin', 'Kotlin'), ('java', 'Java'), ('scala', 'Scala'))

# Store image layout. Both images share it so the mascot lands at the same spot in each.
# Leave room around the complete mascot and the text on both store surfaces.
CANVAS_W, CANVAS_H = 1920, 1080
LOGO_HEIGHT = 710
LOGO_TEXT_GAP = 105
HEAD_Y = 540
TEXT_Y = 0
WEBP_MAX_BYTES = 600 * 1024
TITLE_COLOR = (252, 249, 249, 255)
SUBTITLE_COLOR = (231, 222, 226, 255)
TITLE_FONT = 'Rubik-Bold.ttf'
TEXT_FONT = 'SourceSansPro-Semibold.ttf'

SYSTEM = platform.system()  # 'Windows', 'Linux' or 'Darwin'


# ------------------------------------------------------------------ dependencies

def find_inkscape():
    """Path to the Inkscape executable, or None. Real install locations come first because
    package-manager shims on PATH (Chocolatey's, for one) return before the export is written."""
    candidates = []
    if SYSTEM == 'Windows':
        for program_files in (os.environ.get('ProgramFiles'), os.environ.get('ProgramFiles(x86)')):
            if program_files:
                candidates.append(Path(program_files) / 'Inkscape' / 'bin' / 'inkscape.com')
    elif SYSTEM == 'Darwin':
        candidates.append(Path('/Applications/Inkscape.app/Contents/MacOS/inkscape'))
    for name in ('inkscape.com', 'inkscape'):
        found = shutil.which(name)
        if found:
            candidates.append(Path(found))
    for candidate in candidates:
        if candidate.is_file():
            return candidate
    return None

def inkscape_install_hint():
    if SYSTEM == 'Windows':
        return 'install it from https://inkscape.org/release/ or with "winget install Inkscape.Inkscape"'
    if SYSTEM == 'Darwin':
        return 'install it from https://inkscape.org/release/ or with "brew install --cask inkscape"'
    return 'install it with your package manager (for example "sudo apt install inkscape") or from https://inkscape.org/release/'

def font_directories():
    home = Path.home()
    directories = []
    custom = os.environ.get('GODOT_JVM_FONT_DIR')
    if custom:
        directories.append(Path(custom))
    if SYSTEM == 'Windows':
        directories.append(Path(os.environ.get('WINDIR', 'C:/Windows')) / 'Fonts')
        directories.append(home / 'AppData' / 'Local' / 'Microsoft' / 'Windows' / 'Fonts')
    elif SYSTEM == 'Darwin':
        directories.append(Path('/Library/Fonts'))
        directories.append(Path('/System/Library/Fonts'))
        directories.append(home / 'Library' / 'Fonts')
    else:
        directories.append(Path('/usr/share/fonts'))
        directories.append(Path('/usr/local/share/fonts'))
        directories.append(home / '.fonts')
        directories.append(Path(os.environ.get('XDG_DATA_HOME', home / '.local' / 'share')) / 'fonts')
    return directories

def font(name, size):
    """Load a font by file name from the platform font directories, searched recursively."""
    for directory in font_directories():
        if not directory.is_dir():
            continue
        for path in directory.rglob(name):
            return ImageFont.truetype(str(path), size)
    sys.exit(f'Font {name} not found in {", ".join(str(d) for d in font_directories())}.\n'
             'Download Rubik and Source Sans Pro from https://fonts.google.com/ and install them, '
             'or set GODOT_JVM_FONT_DIR to a directory that contains the .ttf files.')

def inkscape_export(inkscape, svg, png, width):
    try:
        subprocess.run([str(inkscape), str(svg), f'--export-filename={png}', f'--export-width={width}'], check=True)
    except subprocess.CalledProcessError as error:
        sys.exit(f'Inkscape failed with exit code {error.returncode} while rendering {svg.name}')
    if not png.is_file():
        sys.exit(f'{inkscape} returned without writing {png}. Point PATH at the real Inkscape executable, '
                 'not a package-manager shim.')


# ------------------------------------------------------------------ 1. render the SVGs

def render_svgs(inkscape):
    # SVG renderers such as IntelliJ's icon loader draw an SVG at its declared width/height,
    # so consumers that need an exact size get their own copy with that size declared.
    ElementTree.register_namespace('', 'http://www.w3.org/2000/svg')
    svg = ElementTree.parse(REFERENCE_SVG)
    for size in SVG_SIZES:
        svg.getroot().set('width', str(size))
        svg.getroot().set('height', str(size))
        svg.write(HIGHRES / f'logo-{size}.svg', encoding='utf-8', xml_declaration=True)

    rendered = DIRECTORY / 'logo-render.png'
    try:
        inkscape_export(inkscape, REFERENCE_SVG, rendered, MASTER_SIZE)
        with Image.open(rendered) as image:
            master = image.convert('RGBA')
    finally:
        rendered.unlink(missing_ok=True)
    for size in PNG_SIZES:
        master.resize((size, size), Image.Resampling.LANCZOS).save(HIGHRES / f'logo-{size}.png')

    # The neutral outline keeps the dark silhouette readable on dark surfaces.
    # Inset the logo so the outline fits the canvas.
    inset_size = MASTER_SIZE - 64
    inset = master.resize((inset_size, inset_size), Image.Resampling.LANCZOS)
    padded = Image.new('RGBA', master.size)
    padded.alpha_composite(inset, (32, 32))
    outline = Image.new('RGBA', padded.size, '#bdb9ba')
    outline.putalpha(padded.getchannel('A').filter(ImageFilter.MaxFilter(25)))
    outline.alpha_composite(padded)
    outline.resize((1024, 1024), Image.Resampling.LANCZOS).save(HIGHRES / 'logo-1024-outline.png')

    for name, _ in LANGUAGES:
        inkscape_export(inkscape, LANGUAGE / f'{name}.svg', LANGUAGE / f'{name}.png', LANGUAGE_PNG_SIZE)
    print(f'Rendered highres/ logo SVGs {SVG_SIZES}, PNGs {PNG_SIZES} and the outlined 1024, and language/ PNGs')


# ------------------------------------------------------------------ 2. store images

def text_layer(text, fnt, fill, tracking=0.0):
    """Render text with letter tracking (fraction of font size) into a tightly cropped layer."""
    layer = Image.new('RGBA', (CANVAS_W, fnt.size * 2), (0, 0, 0, 0))
    draw = ImageDraw.Draw(layer)
    x = 0
    for character in text:
        draw.text((x, fnt.size * 1.2), character, font=fnt, fill=fill, anchor='ls')
        x += fnt.getlength(character) + tracking * fnt.size
    return layer.crop(layer.getbbox())

def badge_row(fnt, height=100, icon_box=50, gap=20, pad_x=36, icon_gap=20):
    """Render the language badges into a tightly cropped layer."""
    row = Image.new('RGBA', (CANVAS_W, height), (0, 0, 0, 0))
    x = 0
    for name, label in LANGUAGES:
        with Image.open(LANGUAGE / f'{name}.png') as image:
            icon = image.convert('RGBA')
        icon = icon.crop(icon.getbbox())
        icon.thumbnail((icon_box, icon_box), Image.Resampling.LANCZOS)
        white = Image.new('RGBA', icon.size, (255, 255, 255, 255))
        white.putalpha(icon.getchannel('A'))
        width = int(pad_x * 2 + icon_box + icon_gap + fnt.getlength(label))
        badge = Image.new('RGBA', (width, height), (0, 0, 0, 0))
        draw = ImageDraw.Draw(badge)
        draw.rounded_rectangle((0, 0, width - 1, height - 1), radius=height // 2,
                               fill=(231, 130, 139, 24), outline=(221, 167, 175, 140), width=3)
        badge.alpha_composite(white, (pad_x + (icon_box - white.width) // 2, (height - white.height) // 2))
        draw.text((pad_x + icon_box + icon_gap, height / 2 + 2), label, font=fnt, fill=(250, 245, 246, 255), anchor='lm')
        row.alpha_composite(badge, (x, 0))
        x += width + gap
    return row.crop((0, 0, x - gap, height))

def background(accent_x, accent_y, accent_radius=640):
    top, bottom = (48, 39, 50), (23, 20, 29)
    bg = Image.new('RGB', (CANVAS_W, CANVAS_H))
    draw = ImageDraw.Draw(bg)
    for y in range(CANVAS_H):
        t = y / CANVAS_H
        draw.line((0, y, CANVAS_W, y), fill=tuple(int(top[i] * (1 - t) + bottom[i] * t) for i in range(3)))
    bg = bg.convert('RGBA')

    # A soft silver halo lifts the dark mascot from the background; red echoes Duke.
    glow = Image.new('RGBA', (CANVAS_W, CANVAS_H), (0, 0, 0, 0))
    draw = ImageDraw.Draw(glow)
    r = accent_radius
    draw.ellipse((accent_x - r, accent_y - r, accent_x + r, accent_y + r), fill=(165, 152, 155, 180))
    draw.ellipse((accent_x - r * 0.5, accent_y - r * 0.1, accent_x + r * 0.8, accent_y + r), fill=(220, 28, 64, 220))
    glow = glow.filter(ImageFilter.GaussianBlur(240))
    glow.putalpha(glow.getchannel('A').point([a // 2 for a in range(256)]))
    bg.alpha_composite(glow)

    # A restrained violet accent nods to Kotlin without overpowering Duke's red.
    violet = Image.new('RGBA', (CANVAS_W, CANVAS_H), (0, 0, 0, 0))
    ImageDraw.Draw(violet).ellipse((CANVAS_W - 700, -550, CANVAS_W + 500, 650),
                                    fill=(107, 67, 174, 120))
    violet = violet.filter(ImageFilter.GaussianBlur(260))
    bg.alpha_composite(violet)

    # vignette
    vignette = Image.new('L', (CANVAS_W, CANVAS_H), 0)
    ImageDraw.Draw(vignette).ellipse((-CANVAS_W * 0.5, -CANVAS_H * 0.9, CANVAS_W * 1.5, CANVAS_H * 1.9), fill=255)
    vignette = vignette.filter(ImageFilter.GaussianBlur(320))
    dark = Image.new('RGBA', (CANVAS_W, CANVAS_H), (16, 12, 17, 255))
    dark.putalpha(vignette.point([(255 - v) // 2 for v in range(256)]))
    bg.alpha_composite(dark)

    # fine noise to break gradient banding
    noise = Image.effect_noise((CANVAS_W, CANVAS_H), 18).convert('L')
    grain = Image.new('RGBA', (CANVAS_W, CANVAS_H), (255, 255, 255, 255))
    grain.putalpha(noise.point([int(abs(v - 128) * 0.14) for v in range(256)]))
    bg.alpha_composite(grain)
    return bg

def paste_logo(bg, logo, x, y):
    """Center the cropped mascot on (x, y)."""
    logo = logo.resize((int(logo.width * LOGO_HEIGHT / logo.height), LOGO_HEIGHT), Image.Resampling.LANCZOS)
    bg.alpha_composite(logo, (x - logo.width // 2, y - logo.height // 2))

def compose(logo, rows, text_width, name):
    """Mascot on the left, a column of centered rows on the right, the pair centered on the canvas.
    `rows` holds (gap above, layer) pairs; `text_width` is the column width, shared between images
    so the mascot lands at the same spot in each."""
    text_height = sum(gap + layer.height for gap, layer in rows)
    logo_width = int(logo.width * LOGO_HEIGHT / logo.height)
    start = (CANVAS_W - (logo_width + LOGO_TEXT_GAP + text_width)) // 2
    logo_x = start + logo_width // 2
    bg = background(logo_x, HEAD_Y)
    paste_logo(bg, logo, logo_x, HEAD_Y)
    text_x = start + logo_width + LOGO_TEXT_GAP + text_width // 2
    y = CANVAS_H // 2 - text_height // 2 + TEXT_Y
    for gap, layer in rows:
        y += gap
        bg.alpha_composite(layer, (text_x - layer.width // 2, y))
        y += layer.height

    rgb = bg.convert('RGB')
    rgb.save(STORE / f'{name}.png')
    webp = STORE / f'{name}.webp'
    for quality in (92, 88, 84, 80, 75, 70):
        rgb.save(webp, quality=quality, method=6)
        if webp.stat().st_size <= WEBP_MAX_BYTES:
            break
    print(f'Rendered store/{webp.name} ({webp.stat().st_size // 1024} KB at quality {quality})')

def render_store_images():
    logo_path = HIGHRES / 'logo-1024-outline.png'
    missing = [p for p in [logo_path] + [LANGUAGE / f'{name}.png' for name, _ in LANGUAGES] if not p.is_file()]
    if missing:
        sys.exit('Missing rendered PNGs: ' + ', '.join(str(p) for p in missing)
                 + '. Install Inkscape so this script can render them, or restore them from git.')
    with Image.open(logo_path) as image:
        logo = image.convert('RGBA')
    logo = logo.crop(logo.getbbox())

    # The store thumbnail is shown small, so its language line is larger than the featured tagline.
    thumbnail = [(0, text_layer('Godot-JVM', font(TITLE_FONT, 140), TITLE_COLOR, tracking=-0.04)),
                 (60, text_layer('Kotlin · Java · Scala', font(TEXT_FONT, 88), SUBTITLE_COLOR, tracking=0.02))]
    featured = [(0, text_layer('Godot-JVM', font(TITLE_FONT, 140), TITLE_COLOR, tracking=-0.04)),
                (70, text_layer('Write your Godot game logic on the JVM', font(TEXT_FONT, 42), SUBTITLE_COLOR, tracking=0.01)),
                (60, badge_row(font(TEXT_FONT, 48), height=100, icon_box=50, pad_x=36))]
    text_width = max(layer.width for _, layer in thumbnail + featured)
    compose(logo, thumbnail, text_width, 'store-thumbnail')
    compose(logo, featured, text_width, 'featured-image')


if __name__ == '__main__':
    if not REFERENCE_SVG.is_file():
        sys.exit(f'{REFERENCE_SVG} is missing')
    for path in (HIGHRES, LANGUAGE, STORE):
        path.mkdir(exist_ok=True)
    inkscape = find_inkscape()
    if inkscape:
        render_svgs(inkscape)
    else:
        print(f'Inkscape not found, keeping the committed PNGs. To regenerate them, {inkscape_install_hint()}.')
    render_store_images()
