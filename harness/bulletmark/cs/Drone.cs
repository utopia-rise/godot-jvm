using System;
using Godot;

/// <summary>
/// The arena's only enemy. It patrols the middle of the arena across the lanes, scans its surroundings, reacts to every
/// hit and, when it dies, splits in two and respawns. Each of those reaches the engine through a different path:
/// <list type="bullet">
/// <item>patrolling is a per-entity <c>_PhysicsProcess</c>, like the bullets';</item>
/// <item>scanning walks the bullets inside its sensor (<c>GetOverlappingAreas</c>) and the drones in its group
/// (<c>GetNodesInGroup</c>), then reads the nearby drones' positions: the drone steers away from them, so the drones
/// spread out, and moves faster the more bullets its sensor holds;</item>
/// <item>a hit arrives through <c>area_entered</c>, as it does for the bullet, and starts a two-step <c>Tween</c>
/// flash;</item>
/// <item>a death splits through <c>CallDeferred</c>, since the engine refuses new areas while it dispatches a collision
/// signal, and respawns through a <c>SceneTreeTimer</c> whose timeout runs a lambda.</item>
/// </list>
/// The two drones a split leaves behind have fewer hit points and neither split nor respawn, so the population is
/// bounded.
/// </summary>
public partial class Drone : Area2D
{
    public const string Group = "drones";
    public const float SensorRadius = 64f;
    private const int OriginalHitPoints = 30;
    private const int ChildHitPoints = 10;
    private const int ScanIntervalFrames = 15;
    private const double SeparationRadius = 90.0;
    // How hard a neighbour pushes, in pixels per second of velocity at zero distance.
    private const double SeparationSteer = 600.0;
    private const double CalmSpeed = 130.0;
    private const int PanicBullets = 80;
    private const double FlashSeconds = 0.05;
    private const double RespawnSeconds = 0.5;
    private static readonly Color HitColor = new(1.3f, 1.3f, 1.3f);
    private static readonly Color RestColor = new(1.0f, 1.0f, 1.0f);

    private Arena _arena = null!;
    private Sprite2D _fill = null!;
    private Area2D _sensor = null!;
    private bool _original = true;
    private int _maxHitPoints;
    private int _hitPoints;
    private double _velocityX;
    private double _velocityY;
    private int _framesUntilScan = ScanIntervalFrames;
    private bool _dead;

    public void Place(Arena arena, double x, double y, double velocityX, double velocityY, bool original)
    {
        _arena = arena;
        _original = original;
        _velocityX = velocityX;
        _velocityY = velocityY;
        _maxHitPoints = original ? OriginalHitPoints : ChildHitPoints;
        _hitPoints = _maxHitPoints;
        Position = new Vector2((float)x, (float)y);
        CollisionLayer = Layers.Drone;
        CollisionMask = Layers.TeamA | Layers.TeamB;
        AddChild(new CollisionShape2D { Shape = arena.DroneShape });

        // Three layers: the dark inside, the body's colour filling it as high as the hit points left, the face on top.
        DroneLook look = arena.DroneLook;
        AddChild(new Sprite2D { Texture = look.Hollow });
        _fill = new Sprite2D { Texture = look.Fill, Centered = false, RegionEnabled = true };
        AddChild(_fill);
        ShowHitPoints();
        AddChild(new Sprite2D { Texture = look.Face });

        // The sensor is a wider area that only watches bullets: nothing scans its layer, so bullets fly through it and
        // live long enough to be listed, unlike the ones that touch the drone's body.
        _sensor = new Area2D { CollisionLayer = 0, CollisionMask = Layers.TeamA | Layers.TeamB, Monitorable = false };
        _sensor.AddChild(new CollisionShape2D { Shape = arena.SensorShape });
        AddChild(_sensor);
        AddChild(new Sprite2D { Texture = look.Sensor });

        if (arena.Bookkeeping) AddToGroup(Group);
        if (arena.Hits) AreaEntered += OnAreaEntered;
        else Monitoring = false;
    }

    public override void _PhysicsProcess(double delta)
    {
        ScriptCalls.Count++;
        if (_dead) return;
        Patrol(delta);
        if (_arena.Bookkeeping && --_framesUntilScan <= 0)
        {
            _framesUntilScan = ScanIntervalFrames;
            Scan();
        }
    }

    /// <summary>Moves diagonally, bouncing off the edges of the middle of the arena.</summary>
    private void Patrol(double delta)
    {
        // In double, bounded before the single rounding when stored, as the Kotlin version does.
        Vector2 position = Position;
        double x = position.X + _velocityX * delta;
        double y = position.Y + _velocityY * delta;
        if (x < Arena.MiddleLeft || x > Arena.MiddleRight)
        {
            _velocityX = -_velocityX;
            x = Math.Clamp(x, Arena.MiddleLeft, Arena.MiddleRight);
        }
        if (y < Arena.Top || y > Arena.Bottom)
        {
            _velocityY = -_velocityY;
            y = Math.Clamp(y, Arena.Top, Arena.Bottom);
        }
        Position = new Vector2((float)x, (float)y);
    }

    // Each element read is delivered to the managed side as an object, as it is when game code walks a query result.
    // What the scan finds steers the drone until the next one.
    private void Scan()
    {
        int bulletsNearby = 0;
        foreach (Area2D area in _sensor.GetOverlappingAreas())
        {
            if (area is Bullet) bulletsNearby++;
        }

        // Flocking: a push away from every drone closer than SeparationRadius, stronger the closer it is.
        Vector2 here = Position;
        double pushX = 0.0;
        double pushY = 0.0;
        int drones = 0;
        foreach (Node node in GetTree().GetNodesInGroup(Group))
        {
            if (node is not Drone drone) continue;
            drones++;
            if (ReferenceEquals(drone, this)) continue;
            Vector2 there = drone.Position;
            double dx = (double)here.X - there.X;
            double dy = (double)here.Y - there.Y;
            double distance = Math.Sqrt(dx * dx + dy * dy);
            if (distance > 0.0 && distance < SeparationRadius)
            {
                double weight = (1.0 - distance / SeparationRadius) / distance;
                pushX += dx * weight;
                pushY += dy * weight;
            }
        }
        _velocityX += pushX * SeparationSteer;
        _velocityY += pushY * SeparationSteer;

        // Panic: the more bullets in the sensor, the faster the drone moves, up to twice its calm speed.
        double panic = (double)Math.Min(bulletsNearby, PanicBullets) / PanicBullets;
        double speed = CalmSpeed * (1.0 + panic);
        double length = Math.Sqrt(_velocityX * _velocityX + _velocityY * _velocityY);
        if (length > 0.0)
        {
            _velocityX *= speed / length;
            _velocityY *= speed / length;
        }
        _arena.RecordScan(bulletsNearby, drones);
    }

    private void OnAreaEntered(Area2D other)
    {
        ScriptCalls.Count++;
        if (_dead) return;
        _arena.RecordDroneHit();
        if (_arena.Reactions)
        {
            Tween flash = CreateTween();
            flash.TweenProperty(this, "modulate", HitColor, FlashSeconds);
            flash.TweenProperty(this, "modulate", RestColor, FlashSeconds);
        }
        _hitPoints--;
        // Only a run with a window shows the drain: a headless run skips the extra engine call per hit.
        if (_arena.Effects) ShowHitPoints();
        if (_hitPoints > 0) return;

        _dead = true;
        _arena.RecordKill(_original);
        if (_original)
        {
            Vector2 at = Position;
            _arena.CallDeferred(Arena.MethodName.Split, (double)at.X, (double)at.Y);
            // Copied out so the lambda holds the arena, not this drone, which is freed before the timer fires.
            Arena arena = _arena;
            if (arena.Reactions)
            {
                GetTree().CreateTimer(RespawnSeconds).Timeout += () =>
                {
                    ScriptCalls.Count++;
                    arena.Respawn();
                };
            }
            else
            {
                arena.ScheduleRespawn();
            }
        }
        QueueFree();
    }

    /// <summary>Crops the fill from the top, so the body empties as the hit points drop.</summary>
    private void ShowHitPoints()
    {
        float size = 2 * Arena.DroneDrawnRadius;
        float top = size * (1.0f - (float)Math.Max(_hitPoints, 0) / _maxHitPoints);
        _fill.RegionRect = new Rect2(0, top, size, size - top);
        _fill.Offset = new Vector2(-Arena.DroneDrawnRadius, top - Arena.DroneDrawnRadius);
    }
}

/// <summary>How a drone looks: its dark inside, the fill that drains with its hit points, its face and its sensor ring.</summary>
public record DroneLook(Texture2D Hollow, Texture2D Fill, Texture2D Face, Texture2D Sensor);
