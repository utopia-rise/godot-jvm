using Godot;

public partial class Bunny : Sprite2D
{
    public Vector2 Speed = new();

    private const float Gravity = 500f;
    private Vector2 _screenSize;
    // One generator per bunny, which is deliberate: this benchmark exists to measure what many small scripts cost,
    // and an object of its own per bunny is part of that. Seeded by the spawner rather than here, with a seed of its
    // own per bunny, because a shared seed would have every bunny bounce in exactly the same way.
    private readonly RandomNumberGenerator _bounceRandom = new();

    public void SeedBounce(ulong seed)
    {
        _bounceRandom.Seed = seed;
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
            if (_bounceRandom.Randf() > 0.5f)
            {
                sp.Y = -(_bounceRandom.Randi() % 1100 + 50);
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
