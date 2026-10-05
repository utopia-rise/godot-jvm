using Godot;

public partial class Bunny : Sprite2D
{
    public Vector2 Speed = new();

    private const float Gravity = 500f;
    private Vector2 _screenSize;
    private readonly RandomNumberGenerator _randomNumberGenerator = new();

    public override void _Ready()
    {
        _randomNumberGenerator.Randomize();
    }

    public override void _Process(double delta)
    {
        float dt = (float)delta;
        _screenSize = GetViewportRect().Size;
        Vector2 pos = Position;
        Vector2 sp = Speed;

        pos.X += sp.X * dt;
        pos.Y += sp.Y * dt;

        sp.Y += Gravity * dt;

        if (pos.X > _screenSize.X)
        {
            sp.X *= -1f;
            pos.X = _screenSize.X;
        }

        if (pos.X < 0f)
        {
            sp.X *= -1f;
            pos.X = 0f;
        }

        if (pos.Y > _screenSize.Y)
        {
            pos.Y = _screenSize.Y;
            if (_randomNumberGenerator.Randf() > 0.5f)
            {
                sp.Y = -(_randomNumberGenerator.Randi() % 1100 + 50);
            }
            else
            {
                sp.Y *= -0.85f;
            }
        }

        if (pos.Y < 0f)
        {
            sp.Y = 0f;
            pos.Y = 0f;
        }

        Position = pos;
        Speed = sp;
    }
}
