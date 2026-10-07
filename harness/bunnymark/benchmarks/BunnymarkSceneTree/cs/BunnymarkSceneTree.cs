using System.Collections.Generic;
using Godot;

public partial class BunnymarkSceneTree : Node2D
{
    private const float Gravity = 500f;
    private readonly List<Vector2> _bunnySpeeds = new();
    private readonly Label _label = new();
    private readonly Node2D _bunnies = new();
    private readonly Texture2D _bunnyTexture = ResourceLoader.Load<Texture2D>("res://images/godot_bunny.png");
    private readonly RandomNumberGenerator _spawnRandom = new();

    // One generator for every bounce in the run, kept apart from the spawn generator so that the bounce sequence
    // does not shift when the ramp happens to spawn a different number of bunnies.
    private static readonly RandomNumberGenerator BounceRandom = new();

    private Vector2 _screenSize;

    public override void _Ready()
    {
        // Fixed seeds rather than Randomize(): every run then spawns the same population and bounces it the same
        // way, so a difference in the score is a difference in the code.
        _spawnRandom.Seed = 20260921;
        BounceRandom.Seed = 20260922;
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
                if (BounceRandom.Randf() > 0.5f)
                {
                    speed.Y = -(BounceRandom.Randi() % 1100 + 50);
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
        // A ninety degree arc centred straight down -- +Y is down in 2D, so Pi / 2 points at the floor.
        // Angle and speed are drawn separately, so every direction gets the same range of speeds.
        float angle = _spawnRandom.RandfRange(Mathf.Pi * 0.25f, Mathf.Pi * 0.75f);
        float speed = _spawnRandom.RandfRange(50f, 250f);
        var bunny = new Sprite2D();
        bunny.Texture = _bunnyTexture;
        _bunnies.AddChild(bunny);
        bunny.Position = new Vector2(_screenSize.X / 2, _screenSize.Y / 2);
        _bunnySpeeds.Add(
            new Vector2(Mathf.Cos(angle) * speed, Mathf.Sin(angle) * speed)
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
