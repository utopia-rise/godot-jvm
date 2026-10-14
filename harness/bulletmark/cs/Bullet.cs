using Godot;

/// <summary>
/// One bullet: an Area2D with its own script, moved in its own <c>_PhysicsProcess</c> and told about hits through the
/// engine's <c>area_entered</c> signal, the way a game written one script per entity does it. It frees itself on its
/// first hit, on another bullet or a drone, or when its lifetime runs out, whichever comes first.
///
/// With a texture it carries its own Sprite2D, as a bullet scene would; without one the arena draws it.
/// </summary>
public partial class Bullet : Area2D
{
    private Arena _arena = null!;
    private double _velocityX;
    private int _framesLeft;
    private bool _finished;

    public int Team { get; private set; }

    public void Launch(Arena arena, int team, double x, double y, double velocityX, int lifetimeFrames, Shape2D shape, Texture2D? texture)
    {
        _arena = arena;
        Team = team;
        _velocityX = velocityX;
        _framesLeft = lifetimeFrames;
        Position = new Vector2((float)x, (float)y);
        // Each team sits on its own layer and scans the other team and the drones, never its own bullets.
        CollisionLayer = team == 0 ? Layers.TeamA : Layers.TeamB;
        CollisionMask = (team == 0 ? Layers.TeamB : Layers.TeamA) | Layers.Drone;
        AddChild(new CollisionShape2D { Shape = shape });
        if (texture != null) AddChild(new Sprite2D { Texture = texture });
        // Without hits the bullet neither detects nor is detected, so the engine tracks no overlaps for it either.
        if (arena.Hits) AreaEntered += OnAreaEntered;
        else Monitoring = false;
        Monitorable = arena.Hits;
    }

    public override void _PhysicsProcess(double delta)
    {
        ScriptCalls.Count++;
        if (_finished) return;
        if (--_framesLeft <= 0)
        {
            Finish();
            _arena.RecordExpired(this);
            return;
        }
        // In double, rounded once when stored, as the Kotlin version does: the same rounding keeps the two games equal.
        Vector2 moved = Position;
        moved.X = (float)(moved.X + _velocityX * delta);
        Position = moved;
    }

    private void OnAreaEntered(Area2D other)
    {
        ScriptCalls.Count++;
        if (_finished) return;
        Finish();
        _arena.RecordBulletHit(this, hitDrone: other is Drone);
    }

    private void Finish()
    {
        _finished = true;
        QueueFree();
    }
}
