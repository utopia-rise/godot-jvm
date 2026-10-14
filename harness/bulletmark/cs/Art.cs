using System;
using Godot;

/// <summary>
/// The scene's look, generated once at startup so the project ships no image files. Every texture here is built once
/// and shared by every body that shows it, so only the startup pays for it.
/// </summary>
public static class Art
{
    public static readonly Color TeamA = new(0.35f, 0.8f, 1.0f);
    public static readonly Color TeamB = new(1.0f, 0.6f, 0.25f);
    public static readonly Color TeamABase = new(0.35f, 0.8f, 1.0f, 0.14f);
    public static readonly Color TeamBBase = new(1.0f, 0.6f, 0.25f, 0.14f);
    public static readonly Color Drone = new(0.95f, 0.3f, 0.35f);
    public static readonly Color Sensor = new(0.95f, 0.3f, 0.35f, 0.3f);
    public static readonly Color Lane = new(1.0f, 1.0f, 1.0f, 0.07f);
    public static readonly Color Text = new(0.9f, 0.9f, 0.9f);

    /// <summary>The dark inside of a drone, which shows where its body has drained.</summary>
    public static readonly Color Hollow = new(0.08f, 0.08f, 0.1f, 0.92f);

    private static readonly Color Feature = new(1.0f, 0.97f, 0.9f);
    private const int Teeth = 6;

    public static Texture2D Disc(int radius, Color color)
    {
        Image image = Blank(radius);
        FillDisc(image, Centre(radius), Centre(radius), radius, color);
        return ImageTexture.CreateFromImage(image);
    }

    /// <summary>A circle outline <paramref name="thickness"/> pixels wide.</summary>
    public static Texture2D Ring(int radius, int thickness, Color color)
    {
        Image image = Blank(radius);
        StrokeRing(image, Centre(radius), Centre(radius), radius, thickness, color);
        return ImageTexture.CreateFromImage(image);
    }

    /// <summary>
    /// A drone's outline and evil face, drawn over its fill: transparent inside, so the fill below shows how much of the
    /// drone is left.
    /// </summary>
    public static Texture2D DroneFace(int radius, Color color)
    {
        Image image = Blank(radius);
        double r = radius;
        double c = Centre(radius);
        StrokeRing(image, c, c, r, 3.0, color);
        // Brows slanting down towards the nose read as anger at any size.
        Line(image, c - 0.62 * r, c - 0.5 * r, c - 0.12 * r, c - 0.22 * r, 2.4, Feature);
        Line(image, c + 0.62 * r, c - 0.5 * r, c + 0.12 * r, c - 0.22 * r, 2.4, Feature);
        FillDisc(image, c - 0.34 * r, c - 0.05 * r, 0.13 * r, Feature);
        FillDisc(image, c + 0.34 * r, c - 0.05 * r, 0.13 * r, Feature);
        // A jagged grin: a zigzag of teeth across the lower face.
        for (int tooth = 0; tooth < Teeth; tooth++)
        {
            double x0 = c - 0.5 * r + tooth * r / Teeth;
            bool upFirst = tooth % 2 == 0;
            Line(image, x0, c + (upFirst ? 0.32 : 0.5) * r, x0 + r / Teeth, c + (upFirst ? 0.5 : 0.32) * r, 1.8, Feature);
        }
        return ImageTexture.CreateFromImage(image);
    }

    private static double Centre(int radius) => radius - 0.5;

    private static Image Blank(int radius) => Image.CreateEmpty(radius * 2, radius * 2, false, Image.Format.Rgba8);

    private static void FillDisc(Image image, double cx, double cy, double discRadius, Color color)
    {
        int size = image.GetWidth();
        for (int y = 0; y < size; y++)
        {
            for (int x = 0; x < size; x++)
            {
                if (Distance(x - cx, y - cy) <= discRadius) image.SetPixel(x, y, color);
            }
        }
    }

    private static void StrokeRing(Image image, double cx, double cy, double ringRadius, double thickness, Color color)
    {
        int size = image.GetWidth();
        for (int y = 0; y < size; y++)
        {
            for (int x = 0; x < size; x++)
            {
                double d = Distance(x - cx, y - cy);
                if (d <= ringRadius && d > ringRadius - thickness) image.SetPixel(x, y, color);
            }
        }
    }

    /// <summary>A line of <paramref name="thickness"/> pixels from (x0, y0) to (x1, y1).</summary>
    private static void Line(Image image, double x0, double y0, double x1, double y1, double thickness, Color color)
    {
        double dx = x1 - x0;
        double dy = y1 - y0;
        double lengthSquared = dx * dx + dy * dy;
        int size = image.GetWidth();
        for (int y = 0; y < size; y++)
        {
            for (int x = 0; x < size; x++)
            {
                double t = lengthSquared == 0.0 ? 0.0 : Math.Clamp(((x - x0) * dx + (y - y0) * dy) / lengthSquared, 0.0, 1.0);
                if (Distance(x - (x0 + t * dx), y - (y0 + t * dy)) <= thickness / 2) image.SetPixel(x, y, color);
            }
        }
    }

    private static double Distance(double dx, double dy) => Math.Sqrt(dx * dx + dy * dy);
}
