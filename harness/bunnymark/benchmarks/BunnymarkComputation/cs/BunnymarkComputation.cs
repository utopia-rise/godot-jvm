using System;
using System.Collections.Generic;
using Godot;

public partial class BunnymarkComputation : Node2D
{
    private sealed class BunnyData
    {
        public Vector2 Position;
        public Vector2 Center;
        public double Phase;
        public double Frequency;
        public Vector2 Radius;

        public BunnyData(Vector2 position, Vector2 center, double phase, double frequency, Vector2 radius)
        {
            Position = position;
            Center = center;
            Phase = phase;
            Frequency = frequency;
            Radius = radius;
        }
    }

    private readonly List<BunnyData> _bunnies = new();
    private readonly Texture2D _bunnyTexture = ResourceLoader.Load<Texture2D>("res://images/godot_bunny.png");
    private readonly RandomNumberGenerator _spawnRandom = new();

    private Vector2 _screenSize;

    public override void _Ready()
    {
        // Fixed seed rather than Randomize(): every run then lays out the same orbits, so a difference in the
        // score is a difference in the code. This benchmark never bounces, so it needs no second generator.
        _spawnRandom.Seed = 20260921;
    }

    public override void _Draw()
    {
        foreach (BunnyData bunny in _bunnies)
        {
            DrawTexture(_bunnyTexture, bunny.Position);
        }
    }

    public override void _Process(double delta)
    {
        _screenSize = GetViewportRect().Size;

        foreach (BunnyData bunny in _bunnies)
        {
            bunny.Phase += bunny.Frequency * delta;
            double phase = bunny.Phase;

            double offsetX = Math.Sin(phase) * bunny.Radius.X;
            double offsetY = Math.Cos(phase * 1.7) * bunny.Radius.Y;
            double distance = Math.Sqrt(offsetX * offsetX + offsetY * offsetY);
            double angle = FastAtan2(offsetY, offsetX) + Math.Sin(phase * 0.5) * 0.75;

            Vector2 pos = bunny.Position;
            pos.X = (float)(bunny.Center.X + Math.Cos(angle) * distance);
            pos.Y = (float)(bunny.Center.Y + Math.Sin(angle) * distance);
            bunny.Position = pos;
        }
        QueueRedraw();
    }

    // atan2 is the one function here that HotSpot does not intrinsify on the JVM, so the Kotlin benchmark would
    // otherwise run a software implementation while this one reaches native libm. The same polynomial runs in all
    // three languages so every runtime does the same arithmetic. Max error 1.1e-5 rad, about a hundredth of a pixel
    // at a 1000 px radius.
    private static double AtanUnit(double z)
    {
        double z2 = z * z;
        return z * (0.9998660 + z2 * (-0.3302995 + z2 * (0.1801410 + z2 * (-0.0851330 + z2 * 0.0208351))));
    }

    private static double FastAtan2(double y, double x)
    {
        double ax = Math.Abs(x);
        double ay = Math.Abs(y);
        double a = ax >= ay ? AtanUnit(ax == 0.0 ? 0.0 : ay / ax) : Math.PI * 0.5 - AtanUnit(ax / ay);
        if (x < 0.0) a = Math.PI - a;
        return y < 0.0 ? -a : a;
    }

    public void add_bunny()
    {
        _bunnies.Add(new BunnyData(
            new Vector2(0, 0),
            new Vector2(
                _spawnRandom.Randf() * _screenSize.X,
                _spawnRandom.Randf() * _screenSize.Y
            ),
            _spawnRandom.Randf() * 6.283185307179586,
            _spawnRandom.Randf() * 2.0 + 0.5,
            new Vector2(
                _spawnRandom.Randf() * _screenSize.X / 8,
                _spawnRandom.Randf() * _screenSize.Y / 8
            )
        ));
    }

    public void remove_bunny()
    {
        if (_bunnies.Count == 0) return;
        _bunnies.RemoveAt(_bunnies.Count - 1);
    }

    public void finish()
    {
        EmitSignal("benchmark_finished", _bunnies.Count);
    }
}
