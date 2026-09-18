using System.Collections.Generic;
using Godot;

public partial class BunnymarkV1DrawTexture : Node2D
{
    private sealed class BunnyData
    {
        public Vector2 Position;
        public Vector2 Speed;

        public BunnyData(Vector2 position, Vector2 speed)
        {
            Position = position;
            Speed = speed;
        }
    }

    private readonly List<BunnyData> _bunnies = new();
    private const float Gravity = 500f;
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
        float dt = (float)delta;
        _screenSize = GetViewportRect().Size;

        foreach (BunnyData bunny in _bunnies)
        {
            Vector2 pos = bunny.Position;
            Vector2 speed = bunny.Speed;

            pos.X += speed.X * dt;
            pos.Y += speed.Y * dt;

            speed.Y += Gravity * dt;

            if (pos.X > _screenSize.X)
            {
                speed.X *= -1f;
                pos.X = _screenSize.X;
            }

            if (pos.X < 0f)
            {
                speed.X *= -1f;
                pos.X = 0f;
            }

            if (pos.Y > _screenSize.Y)
            {
                pos.Y = _screenSize.Y;
                if (_randomNumberGenerator.Randf() > 0.5f)
                {
                    speed.Y = -(_randomNumberGenerator.Randi() % 1100 + 50);
                }
                else
                {
                    speed.Y *= -0.85f;
                }
            }

            if (pos.Y < 0f)
            {
                speed.Y = 0f;
                pos.Y = 0f;
            }

            bunny.Position = pos;
            bunny.Speed = speed;
        }
        QueueRedraw();
    }

    public void add_bunny()
    {
        _bunnies.Add(new BunnyData(
            new Vector2(_screenSize.X / 2, _screenSize.Y / 2),
            new Vector2(_randomNumberGenerator.Randi() % 200 + 50, _randomNumberGenerator.Randi() % 200 + 50)
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
