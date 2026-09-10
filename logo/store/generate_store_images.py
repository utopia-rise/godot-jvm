"""Render the Godot Asset Store images (1920x1080 webp, 16:9) from logo2048.png and the
CC0 simple-icons language marks in icons/. Usage: python generate_store_images.py"""
import os
from PIL import Image, ImageDraw, ImageFont, ImageFilter

W, H = 1920, 1080
FONTS = 'C:/Windows/Fonts/'
LOGO = Image.open('logo2048.png').convert('RGBA')
LOGO = LOGO.crop(LOGO.getbbox())

def font(name, size): return ImageFont.truetype(FONTS + name, size)

def background(accent_xy, accent_radius, base=(15, 12, 40), deep=(8, 6, 22)):
    # vertical gradient base
    bg = Image.new('RGB', (W, H))
    px = bg.load()
    for y in range(H):
        t = y / H
        c = tuple(int(base[i] * (1 - t) + deep[i] * t) for i in range(3))
        for x in range(W): px[x, y] = c
    # soft accent glow (purple/blue) behind the logo
    glow = Image.new('RGBA', (W, H), (0, 0, 0, 0))
    g = ImageDraw.Draw(glow)
    ax, ay = accent_xy
    r = accent_radius
    g.ellipse((ax - r, ay - r, ax + r, ay + r), fill=(88, 48, 200, 255))
    g.ellipse((ax - r * 0.55, ay - r * 0.2, ax + r * 0.75, ay + r * 0.9), fill=(0, 120, 190, 210))
    glow = glow.filter(ImageFilter.GaussianBlur(220))
    glow.putalpha(glow.getchannel('A').point(lambda a: int(a * 0.55)))
    bg = bg.convert('RGBA'); bg.alpha_composite(glow)
    # subtle dot grid texture
    grid = Image.new('RGBA', (W, H), (0, 0, 0, 0)); gd = ImageDraw.Draw(grid)
    for x in range(0, W, 48):
        for y in range(0, H, 48):
            gd.ellipse((x, y, x + 2, y + 2), fill=(200, 210, 255, 22))
    bg.alpha_composite(grid)
    # vignette
    vig = Image.new('L', (W, H), 0); vd = ImageDraw.Draw(vig)
    vd.ellipse((-W * 0.15, -H * 0.4, W * 1.15, H * 1.4), fill=255)
    vig = vig.filter(ImageFilter.GaussianBlur(260))
    dark = Image.new('RGBA', (W, H), (4, 3, 14, 255)); dark.putalpha(vig.point(lambda v: 255 - v))
    bg.alpha_composite(dark)
    return bg

def paste_logo(bg, height, center):
    ratio = height / LOGO.height
    logo = LOGO.resize((int(LOGO.width * ratio), height), Image.Resampling.LANCZOS)
    # drop shadow
    sh = Image.new('RGBA', (logo.width + 200, logo.height + 200), (0, 0, 0, 0))
    a = logo.getchannel('A')
    shadow = Image.new('RGBA', logo.size, (5, 3, 20, 190)); shadow.putalpha(a)
    sh.alpha_composite(shadow, (100, 130)); sh = sh.filter(ImageFilter.GaussianBlur(40))
    cx, cy = center
    bg.alpha_composite(sh, (cx - sh.width // 2, cy - sh.height // 2))
    bg.alpha_composite(logo, (cx - logo.width // 2, cy - logo.height // 2))

def icon(name, size, color=(255, 255, 255, 255)):
    im = Image.open(f'icons/{name}.png').convert('RGBA')
    im = im.crop(im.getbbox()); im.thumbnail((size, size), Image.Resampling.LANCZOS)
    out = Image.new('RGBA', im.size, color); out.putalpha(im.getchannel('A'))
    return out

def save(bg, path):
    rgb = bg.convert('RGB')
    rgb.save(path + '.png')
    for q in (92, 88, 84, 80, 75, 70):
        rgb.save(path + '.webp', quality=q, method=6)
        if os.path.getsize(path + '.webp') <= 600 * 1024: break
    print(path, os.path.getsize(path + '.webp') // 1024, 'KB at q', q)

def tracked_text(bg, xy, text, fnt, fill, tracking=0.0, anchor_right=False):
    """Draw text with letter tracking (fraction of font size, negative tightens)."""
    d = ImageDraw.Draw(bg)
    x, y = xy
    step = tracking * fnt.size
    widths = [fnt.getlength(ch) for ch in text]
    total = sum(widths) + step * (len(text) - 1)
    if anchor_right: x -= total
    for ch, w in zip(text, widths):
        d.text((x, y), ch, font=fnt, fill=fill, anchor='ls')
        x += w + step
    return total


TITLE = (246, 247, 255, 255)

# ---------------- v3 ----------------
def background(accent_xy, accent_radius):
    base, deep = (18, 14, 48), (8, 6, 24)
    bg = Image.new('RGB', (W, H)); px = bg.load()
    for y in range(H):
        t = y / H
        c = tuple(int(base[i] * (1 - t) + deep[i] * t) for i in range(3))
        for x in range(W): px[x, y] = c
    glow = Image.new('RGBA', (W, H), (0, 0, 0, 0)); g = ImageDraw.Draw(glow)
    ax, ay = accent_xy; r = accent_radius
    g.ellipse((ax - r, ay - r, ax + r, ay + r), fill=(70, 55, 210, 255))      # unified indigo-blue hue
    g.ellipse((ax - r * 0.5, ay - r * 0.1, ax + r * 0.8, ay + r), fill=(0, 110, 200, 190))
    glow = glow.filter(ImageFilter.GaussianBlur(240))
    glow.putalpha(glow.getchannel('A').point(lambda a: int(a * 0.5)))
    bg = bg.convert('RGBA'); bg.alpha_composite(glow)
    vig = Image.new('L', (W, H), 0); ImageDraw.Draw(vig).ellipse((-W * 0.5, -H * 0.9, W * 1.5, H * 1.9), fill=255)
    vig = vig.filter(ImageFilter.GaussianBlur(320))
    dark = Image.new('RGBA', (W, H), (4, 3, 14, 255)); dark.putalpha(vig.point(lambda v: int((255 - v) * 0.5)))
    bg.alpha_composite(dark)
    # fine noise to break gradient banding
    noise = Image.effect_noise((W, H), 18).convert('L')
    nl = Image.new('RGBA', (W, H), (255, 255, 255, 255)); nl.putalpha(noise.point(lambda v: int(abs(v - 128) * 0.14)))
    bg.alpha_composite(nl)
    return bg

def badge_row(bg, x, y, fnt, height=100, icon_box=50, gap=20, pad_x=36, igap=20):
    for name, label in (('kotlin', 'Kotlin'), ('java', 'Java'), ('scala', 'Scala')):
        ic = icon(name, int(icon_box * (1.3 if name == 'java' else 1.0))); ic.thumbnail((icon_box, icon_box))
        box = Image.new('RGBA', (icon_box, icon_box), (0, 0, 0, 0))
        box.alpha_composite(ic, ((icon_box - ic.width) // 2, (icon_box - ic.height) // 2))
        tw = fnt.getlength(label)
        w = int(pad_x * 2 + icon_box + igap + tw)
        layer = Image.new('RGBA', (w, height), (0, 0, 0, 0)); d = ImageDraw.Draw(layer)
        d.rounded_rectangle((0, 0, w - 1, height - 1), radius=height // 2, fill=(130, 100, 240, 42), outline=(165, 140, 255, 170), width=3)
        layer.alpha_composite(box, (pad_x, (height - icon_box) // 2))
        d.text((pad_x + icon_box + igap, height / 2 + 2), label, font=fnt, fill=(244, 245, 255, 255), anchor='lm')
        bg.alpha_composite(layer, (x, y)); x += w + gap
    return x - gap

def text_width(text, fnt, tracking=0.0):
    return sum(fnt.getlength(c) for c in text) + tracking * fnt.size * (len(text) - 1)

SUB = (222, 226, 248, 255)

def thumbnail(out):
    logo_h = 840; gap = 150
    sub = 'Kotlin · Java · Scala'
    tf = font('Rubik-Bold.ttf', 176); sf = font('SourceSansPro-Semibold.ttf', 84)
    text_w = max(text_width('Godot-JVM', tf, -0.04), text_width(sub, sf, 0.02))
    logo_w = int(LOGO.width * logo_h / LOGO.height)
    start = int((W - (logo_w + gap + text_w)) // 2)
    cx = start + logo_w // 2
    bg = background((cx, 540), 640)
    paste_logo(bg, logo_h, (cx, 560))
    x = start + logo_w + gap
    # eye line of the mascot sits at about 57% of the logo height from its top
    eye = 560 - logo_h // 2 + int(logo_h * 0.57)
    tracked_text(bg, (x, eye - 10), 'Godot-JVM', tf, TITLE, tracking=-0.04)
    tracked_text(bg, (x, eye + 105), sub, sf, SUB, tracking=0.02)
    save(bg, out + '/store-thumbnail')

def featured(out):
    logo_h = 780; gap = 120
    tag = 'Write your Godot game logic on the JVM'
    tf = font('Rubik-Bold.ttf', 176); sf = font('SourceSansPro-Semibold.ttf', 54); bf = font('SourceSansPro-Semibold.ttf', 48)
    text_w = max(text_width('Godot-JVM', tf, -0.04), text_width(tag, sf, 0.01))
    logo_w = int(LOGO.width * logo_h / LOGO.height)
    start = int((W - (logo_w + gap + text_w)) // 2)
    cx = start + logo_w // 2
    bg = background((cx, 540), 640)
    paste_logo(bg, logo_h, (cx, 560))
    x = start + logo_w + gap
    eye = 560 - logo_h // 2 + int(logo_h * 0.57)
    tracked_text(bg, (x, eye - 80), 'Godot-JVM', tf, TITLE, tracking=-0.04)
    tracked_text(bg, (x, eye + 12), tag, sf, SUB, tracking=0.01)
    badge_row(bg, x, eye + 70, bf)
    save(bg, out + '/featured-image')

if __name__ == '__main__':
    os.chdir(os.path.dirname(os.path.abspath(__file__)))
    thumbnail('.'); featured('.')
