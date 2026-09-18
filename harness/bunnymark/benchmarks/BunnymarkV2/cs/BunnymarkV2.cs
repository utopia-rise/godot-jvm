using System.Collections.Generic;
using Godot;

public partial class BunnymarkV2 : Node2D
{
    private const float Gravity = 500f;
    private readonly List<Vector2> _bunnySpeeds = new();
    private readonly Label _label = new();
    private readonly Node2D _bunnies = new();
    private readonly Texture2D _bunnyTexture = ResourceLoader.Load<Texture2D>("res://images/godot_bunny.png");
    private readonly RandomNumberGenerator _randomNumberGenerator = new();

    private Vector2 _screenSize;

    public override void _Ready()
    {
        _randomNumberGenerator.Randomize();
        AddChild(_bunnies);
        _label.SetPosition(new Vector2(0, 20));
        AddChild(_label);
    }

    public override void _Process(double delta)
    {
        float dt = (float)delta;
        _screenSize = GetViewportRect().Size;
        _label.Text = "Bunnies: " + _bunnies.GetChildCount();

        Godot.Collections.Array<Node> bunnyChildren = _bunnies.GetChildren();
        for (int i = 0; i < bunnyChildren.Count; i++)
        {
            var bunny = (Sprite2D)bunnyChildren[i];
            Vector2 pos = bunny.Position;
            Vector2 speed = _bunnySpeeds[i];

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
            _bunnySpeeds[i] = speed;
        }
    }

    public void add_bunny()
    {
        var bunny = new Sprite2D();
        bunny.Texture = _bunnyTexture;
        _bunnies.AddChild(bunny);
        bunny.Position = new Vector2(_screenSize.X / 2, _screenSize.Y / 2);
        _bunnySpeeds.Add(
            new Vector2(_randomNumberGenerator.Randi() % 200 + 50, _randomNumberGenerator.Randi() % 200 + 50)
        );
    }

    public void remove_bunny()
    {
        int childCount = _bunnies.GetChildCount();
        if (childCount == 0) return;
        Node bunny = _bunnies.GetChild(childCount - 1);
        _bunnies.RemoveChild(bunny);
        bunny.QueueFree();
        _bunnySpeeds.RemoveAt(childCount - 1);
    }

    public void finish()
    {
        EmitSignal("benchmark_finished", _bunnySpeeds.Count);
    }
}
