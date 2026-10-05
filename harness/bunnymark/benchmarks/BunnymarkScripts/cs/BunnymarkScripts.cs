using Godot;

public partial class BunnymarkScripts : Node2D
{
    private readonly RandomNumberGenerator _randomNumberGenerator = new();
    private readonly Texture2D _bunnyTexture = ResourceLoader.Load<Texture2D>("res://images/godot_bunny.png");
    private readonly Label _label = new();
    private readonly Node2D _bunnies = new();

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
        _screenSize = GetViewportRect().Size;
        _label.Text = "Bunnies " + _bunnies.GetChildCount();
    }

    public void add_bunny()
    {
        var bunny = new Bunny();
        bunny.Texture = _bunnyTexture;
        _bunnies.AddChild(bunny);
        bunny.Position = new Vector2(_screenSize.X / 2, _screenSize.Y / 2);
        bunny.Speed = new Vector2(_randomNumberGenerator.Randi() % 200 + 50, _randomNumberGenerator.Randi() % 200 + 50);
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
