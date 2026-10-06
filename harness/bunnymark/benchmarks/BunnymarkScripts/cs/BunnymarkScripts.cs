using Godot;

public partial class BunnymarkScripts : Node2D
{
    private readonly RandomNumberGenerator _spawnRandom = new();
    private ulong _spawned;
    private readonly Texture2D _bunnyTexture = ResourceLoader.Load<Texture2D>("res://images/godot_bunny.png");
    private readonly Label _label = new();
    private readonly Node2D _bunnies = new();

    private Vector2 _screenSize;

    public override void _Ready()
    {
        // Fixed seed rather than Randomize(): every run then spawns the same population, so a difference in the
        // score is a difference in the code. Each bunny bounces from a generator of its own, seeded below.
        _spawnRandom.Seed = 20260921;
        AddChild(_bunnies);

        _label.SetPosition(new Vector2(0, 20));
        AddChild(_label);
    }

    public override void _Process(double delta)
    {
        _screenSize = GetViewportRect().Size;
        _label.Text = "Bunnies " + _bunnies.GetChildCount();
    }

    public void add_bunny()
    {
        var bunny = new Bunny();
        bunny.Texture = _bunnyTexture;
        _bunnies.AddChild(bunny);
        bunny.Position = new Vector2(_screenSize.X / 2, _screenSize.Y / 2);
        // A ninety degree arc centred straight down -- +Y is down in 2D, so Pi / 2 points at the floor.
        // Angle and speed are drawn separately, so every direction gets the same range of speeds.
        float angle = _spawnRandom.RandfRange(Mathf.Pi * 0.25f, Mathf.Pi * 0.75f);
        float speed = _spawnRandom.RandfRange(50f, 250f);
        bunny.Speed = new Vector2(Mathf.Cos(angle) * speed, Mathf.Sin(angle) * speed);
        bunny.SeedBounce(20260922 + _spawned);
        _spawned++;
    }

    public void remove_bunny()
    {
        int childCount = _bunnies.GetChildCount();
        if (childCount != 0)
        {
            Node bunny = _bunnies.GetChild(childCount - 1);
            _bunnies.RemoveChild(bunny);
            bunny.QueueFree();
        }
    }

    public void finish()
    {
        EmitSignal("benchmark_finished", _bunnies.GetChildCount());
    }
}
