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
    private readonly RandomNumberGenerator _randomNumberGenerator = new();

    private Vector2 _screenSize;

    public override void _Ready()
    {
        _randomNumberGenerator.Randomize();
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
            double angle = Math.Atan2(offsetY, offsetX) + Math.Sin(phase * 0.5) * 0.75;

            Vector2 pos = bunny.Position;
            pos.X = (float)(bunny.Center.X + Math.Cos(angle) * distance);
            pos.Y = (float)(bunny.Center.Y + Math.Sin(angle) * distance);
            bunny.Position = pos;
        }
        QueueRedraw();
    }

    public void add_bunny()
    {
        _bunnies.Add(new BunnyData(
            new Vector2(0, 0),
            new Vector2(
                _randomNumberGenerator.Randf() * _screenSize.X,
                _randomNumberGenerator.Randf() * _screenSize.Y
            ),
            _randomNumberGenerator.Randf() * 6.283185307179586,
            _randomNumberGenerator.Randf() * 2.0 + 0.5,
            new Vector2(
                _randomNumberGenerator.Randf() * _screenSize.X / 8,
                _randomNumberGenerator.Randf() * _screenSize.Y / 8
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
