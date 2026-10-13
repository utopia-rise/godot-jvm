using System;
using Godot;
using Godot.Collections;

/// <summary>
/// Two turret lines face each other across the arena and fire into partly shared lanes: in a shared lane a bullet meets
/// an oncoming one and both die on the hit, in a lane only one side fires into it crosses the arena and expires.
/// Drones patrol the middle of the arena, soak up bullets, react to every hit, split and respawn after dying. Spawning,
/// moving, hitting, reacting and freeing therefore all happen every frame at a steady rate once the arena fills, which
/// is the workload the runner measures.
///
/// This is a line-for-line port of the Kotlin Arena: the same random draws in the same order and the same arithmetic,
/// so both play exactly the same game. The methods the runner calls keep the runner's snake_case names.
/// </summary>
public partial class Arena : Node2D
{
    public const double Width = 960.0;
    public const int Lanes = 24;
    // Each team fires into 18 of the 24 lanes, offset from the other's: the middle 12 are shared and their bullets meet
    // head-on, the outer 6 on each side carry one team only and their bullets cross the arena and expire.
    public const int LanesPerTeam = 18;
    public const double Top = 20.0;
    public const double LaneSpacing = 24.0;
    public const double Bottom = Top + (Lanes - 1) * LaneSpacing;
    public const double MiddleLeft = 300.0;
    public const double MiddleRight = 660.0;
    // Drawn larger than it collides, so the faces read; the game only sees the collision radius.
    public const float DroneDrawnRadius = 18f;
    // Width of each turret column outside the play field, and the turrets drawn in it.
    public const float TurretMargin = 40f;

    private const string BulletsName = "Bullets";
    private const string DronesName = "Drones";
    private const double BulletSpeed = 400.0;
    // Two bullets close in at 2 x 400 px/s, about 13 px per frame at 60 fps; radii summing past that keep a head-on
    // pair from passing through each other between two physics steps.
    private const float BulletRadius = 8f;
    // Drawn smaller than it collides, so the lanes read as streams of separate shots rather than solid bands.
    private const float BulletDrawnRadius = 4f;
    private const float DroneRadius = 14f;
    private const float TurretInset = 6f;
    private const float TurretBody = 18f;
    private const float TurretHalfHeight = 7f;
    private const float BarrelGap = 2f;
    private const float TurretBarrel = 4f;
    private const float HudTop = 588f;
    private const float HudLineHeight = 19f;
    private const float FpsLabelWidth = 120f;
    private const int StatusIntervalFrames = 15;
    private const int DroneCount = 12;
    // Drones only split while the arena holds fewer than this, so children cannot pile up.
    private const int MaxDrones = 24;
    private const double SplitOffset = 30.0;
    private const double DroneSpeedX = 60.0;
    private const double DroneSpeedY = 120.0;
    private const string Originals = "originals";
    private const string Children = "children";
    // Half a second at 60 physics frames per second, the same delay as the timer a reaction would start.
    private const long RespawnFrames = 30;

    private readonly RandomNumberGenerator _random = new();
    // One shape per kind of body, shared as a scene would share its sub-resource.
    private readonly CircleShape2D _bulletShape = new();
    // Filled only when bullets are nodes, one texture per team; otherwise the arena draws them.
    private readonly Texture2D?[] _bulletTextures = new Texture2D?[2];
    private Node _bulletContainer = null!;
    private Node _droneContainer = null!;
    private Label _status = null!;
    private Label _framesPerSecond = null!;
    private int _framesUntilStatus;
    private bool _drawBullets;
    // Only filled when the arena draws the bullets itself.
    private readonly System.Collections.Generic.HashSet<Bullet> _drawnBullets = new();
    // Kills recorded through the engine, by originals and by the children of splits; only kept with bookkeeping on.
    private readonly Dictionary<string, long> _score = new();
    // The physics frames at which respawns fall due when reactions are off, in order.
    private readonly System.Collections.Generic.Queue<long> _pendingRespawns = new();

    private int _bulletsPerFrame;
    private int _lifetimeFrames;
    private int _maxLive;
    private long _physicsFrame;

    private int _live;
    private int _liveDrones;
    private long _spawned;
    private long _bulletHits;
    private long _droneStrikes;
    private long _expired;
    private long _skipped;
    private long _droneHits;
    private long _kills;
    private long _childKills;
    private long _splits;
    private long _respawns;
    private long _scans;
    private long _scannedBullets;
    private long _scannedDrones;

    /// <summary>Whether bullets and drones connect <c>area_entered</c>. Off, nothing ever hits: bullets only expire.</summary>
    public bool Hits { get; private set; } = true;

    /// <summary>Whether a hit starts a <c>Tween</c> and a death a <c>SceneTreeTimer</c>. Off, respawns are counted down here instead.</summary>
    public bool Reactions { get; private set; } = true;

    /// <summary>Whether the scene is queried and recorded through the engine: groups, <c>GetNode</c>, scans and the score.</summary>
    public bool Bookkeeping { get; private set; } = true;

    /// <summary>Whether the run has a window to show effects in. Headless, measured runs leave them out of the workload.</summary>
    public bool Effects { get; private set; }

    public CircleShape2D DroneShape { get; } = new();
    public CircleShape2D SensorShape { get; } = new();
    public DroneLook DroneLook { get; private set; } = null!;

    public void configure(long seed, int bulletsPerFrame, int lifetimeFrames, int maxLive, string render, bool hits, bool reactions, bool bookkeeping)
    {
        _random.Seed = unchecked((ulong)seed);
        _bulletShape.Radius = BulletRadius;
        DroneShape.Radius = DroneRadius;
        SensorShape.Radius = Drone.SensorRadius;
        _bulletsPerFrame = bulletsPerFrame;
        _lifetimeFrames = lifetimeFrames;
        _maxLive = maxLive;
        Hits = hits;
        Reactions = reactions;
        Bookkeeping = bookkeeping;
        Effects = DisplayServer.GetName() != "headless";
        // Shifted right to leave room for the turrets outside the play field. Every body moves by the same amount, so
        // the physics, and so the game, are unchanged.
        Position = new Vector2(TurretMargin, 0);
        _drawBullets = render == "draw";
        if (!_drawBullets)
        {
            _bulletTextures[0] = Art.Disc((int)BulletDrawnRadius, Art.TeamA);
            _bulletTextures[1] = Art.Disc((int)BulletDrawnRadius, Art.TeamB);
        }
        int droneRadius = (int)DroneDrawnRadius;
        DroneLook = new DroneLook(
            Hollow: Art.Disc(droneRadius, Art.Hollow),
            Fill: Art.Disc(droneRadius, Art.Drone),
            Face: Art.DroneFace(droneRadius, Art.Drone),
            Sensor: Art.Ring((int)Drone.SensorRadius, 2, Art.Sensor));
        if (bookkeeping)
        {
            _score[Originals] = 0;
            _score[Children] = 0;
        }

        _bulletContainer = new Node2D { Name = BulletsName };
        _droneContainer = new Node2D { Name = DronesName };
        AddChild(_bulletContainer);
        AddChild(_droneContainer);
        var teams = new Label
        {
            Text = "Blue turrets fire right, orange turrets fire left. Bullets that meet destroy each other; " +
                "the rest fly off the far edge.",
        };
        var drones = new Label
        {
            Text = "Drones patrol the middle and drain as they are hit; the ring is the sensor each one scans. " +
                "A drone splits in two when it dies, then respawns.",
        };
        _status = new Label();
        Label[] hud = { teams, drones, _status };
        for (int line = 0; line < hud.Length; line++)
        {
            hud[line].Position = new Vector2(8 - TurretMargin, HudTop + line * HudLineHeight);
        }
        // Bottom right, on the row of the live counts: the one corner nothing else uses.
        _framesPerSecond = new Label { HorizontalAlignment = HorizontalAlignment.Right };
        _framesPerSecond.Position = new Vector2((float)Width + TurretMargin - 8 - FpsLabelWidth, HudTop + 2 * HudLineHeight);
        _framesPerSecond.Size = new Vector2(FpsLabelWidth, HudLineHeight);
        foreach (Label label in new[] { teams, drones, _status, _framesPerSecond })
        {
            label.AddThemeFontSizeOverride("font_size", 13);
            label.AddThemeColorOverride("font_color", Art.Text);
            AddChild(label);
        }
        // The lanes and the turret lines are drawn here once; in draw mode every frame redraws them with the bullets.
        QueueRedraw();

        for (int i = 0; i < DroneCount; i++)
        {
            SpawnDrone(RandomMiddleX(), RandomY(), original: true);
        }
    }

    public override void _PhysicsProcess(double delta)
    {
        ScriptCalls.Count++;
        _physicsFrame++;
        while (_pendingRespawns.Count > 0 && _pendingRespawns.Peek() <= _physicsFrame)
        {
            _pendingRespawns.Dequeue();
            Respawn();
        }

        // Looked up by name every frame, as game code that does not cache its nodes does.
        Node bullets = Bookkeeping ? GetNode(BulletsName) : _bulletContainer;
        for (int i = 0; i < _bulletsPerFrame; i++)
        {
            if (_live >= _maxLive)
            {
                _skipped++;
                continue;
            }
            int team = i % 2;
            int firstLane = team == 0 ? 0 : Lanes - LanesPerTeam;
            int lane = _random.RandiRange(firstLane, firstLane + LanesPerTeam - 1);
            var bullet = new Bullet();
            bullet.Launch(
                arena: this,
                team: team,
                x: team == 0 ? 0.0 : Width,
                y: Top + lane * LaneSpacing,
                velocityX: team == 0 ? BulletSpeed : -BulletSpeed,
                lifetimeFrames: _lifetimeFrames,
                shape: _bulletShape,
                texture: _bulletTextures[team]);
            bullets.AddChild(bullet);
            if (_drawBullets) _drawnBullets.Add(bullet);
            _live++;
            _spawned++;
        }
        if (_drawBullets) QueueRedraw();
        // The live counts are only for a viewer, so a headless run does not build them. In a measured run the window
        // plays as fast as it can, so the FPS shown is how fast frames are computed.
        if (Effects && --_framesUntilStatus <= 0)
        {
            _framesUntilStatus = StatusIntervalFrames;
            _status.Text = $"Live bullets {_live}   bullet hits {_bulletHits}   drone hits {_droneHits}   kills {_kills}   " +
                $"splits {_splits}   respawns {_respawns}   expired {_expired}";
            _framesPerSecond.Text = $"{Engine.GetFramesPerSecond():0} FPS";
        }
    }

    public override void _Draw()
    {
        ScriptCalls.Count++;
        for (int lane = 0; lane < Lanes; lane++)
        {
            float y = (float)(Top + lane * LaneSpacing);
            DrawLine(new Vector2(0, y), new Vector2((float)Width, y), Art.Lane, 1f);
        }
        // Each team's turrets stand on a base strip outside the play field, one at the start of every lane it fires
        // into, the barrel pointing into the lane where the bullets leave it.
        float baseHeight = (float)(LanesPerTeam * LaneSpacing);
        int firstLaneB = Lanes - LanesPerTeam;
        DrawRect(new Rect2(-TurretMargin, (float)(Top - LaneSpacing / 2), TurretMargin, baseHeight), Art.TeamABase);
        DrawRect(new Rect2((float)Width, (float)(Top + (firstLaneB - 0.5) * LaneSpacing), TurretMargin, baseHeight), Art.TeamBBase);
        // Each body sits TurretInset from the outer edge, its barrel reaching to just short of the play field.
        float bodyA = -TurretMargin + TurretInset;
        float bodyB = (float)Width + TurretMargin - TurretInset - TurretBody;
        for (int lane = 0; lane < LanesPerTeam; lane++)
        {
            float yA = (float)(Top + lane * LaneSpacing);
            float yB = (float)(Top + (firstLaneB + lane) * LaneSpacing);
            DrawRect(new Rect2(bodyA, yA - TurretHalfHeight, TurretBody, 2 * TurretHalfHeight), Art.TeamA);
            DrawLine(new Vector2(bodyA + TurretBody, yA), new Vector2(-BarrelGap, yA), Art.TeamA, TurretBarrel);
            DrawRect(new Rect2(bodyB, yB - TurretHalfHeight, TurretBody, 2 * TurretHalfHeight), Art.TeamB);
            DrawLine(new Vector2(bodyB, yB), new Vector2((float)Width + BarrelGap, yB), Art.TeamB, TurretBarrel);
        }
        foreach (Bullet bullet in _drawnBullets)
        {
            DrawCircle(bullet.Position, BulletDrawnRadius, bullet.Team == 0 ? Art.TeamA : Art.TeamB);
        }
    }

    public void RecordBulletHit(Bullet bullet, bool hitDrone)
    {
        if (hitDrone) _droneStrikes++;
        else _bulletHits++;
        RemoveBullet(bullet);
    }

    public void RecordExpired(Bullet bullet)
    {
        _expired++;
        RemoveBullet(bullet);
    }

    private void RemoveBullet(Bullet bullet)
    {
        _live--;
        if (_drawBullets) _drawnBullets.Remove(bullet);
    }

    public void RecordDroneHit() => _droneHits++;

    public void RecordKill(bool original)
    {
        _kills++;
        _liveDrones--;
        if (!original) _childKills++;
        if (Bookkeeping)
        {
            string key = original ? Originals : Children;
            _score[key] = _score[key] + 1;
        }
    }

    public void RecordScan(int bulletsNearby, int drones)
    {
        _scans++;
        _scannedBullets += bulletsNearby;
        _scannedDrones += drones;
    }

    /// <summary>The respawn of a dead drone when reactions are off: the same delay, counted in physics frames by the arena.</summary>
    public void ScheduleRespawn() => _pendingRespawns.Enqueue(_physicsFrame + RespawnFrames);

    public void Respawn()
    {
        _respawns++;
        SpawnDrone(RandomMiddleX(), RandomY(), original: true);
    }

    /// <summary>Two children where an original died, deferred to here because the engine refuses new areas in a collision.</summary>
    public void Split(double x, double y)
    {
        ScriptCalls.Count++;
        if (_liveDrones + 2 > MaxDrones) return;
        _splits++;
        SpawnDrone(Math.Clamp(x - SplitOffset, MiddleLeft, MiddleRight), y, original: false);
        SpawnDrone(Math.Clamp(x + SplitOffset, MiddleLeft, MiddleRight), y, original: false);
    }

    private void SpawnDrone(double x, double y, bool original)
    {
        var drone = new Drone();
        drone.Place(this, x, y, RandomDirection() * DroneSpeedX, RandomDirection() * DroneSpeedY, original);
        Node drones = Bookkeeping ? GetNode(DronesName) : _droneContainer;
        drones.AddChild(drone);
        _liveDrones++;
    }

    private double RandomDirection() => _random.RandiRange(0, 1) == 0 ? -1.0 : 1.0;

    private double RandomMiddleX() => _random.RandfRange((float)MiddleLeft, (float)MiddleRight);

    private double RandomY() => _random.RandfRange((float)Top, (float)Bottom);

    public int live_bullets() => _live;

    public Dictionary<string, long> runtime_counters() => RuntimeCounters.Snapshot();

    public string garbage_collectors() => RuntimeCounters.CollectorNames();

    public Dictionary<string, long> stats() => new()
    {
        ["spawned"] = _spawned,
        ["bullet_hits"] = _bulletHits,
        ["drone_strikes"] = _droneStrikes,
        ["expired"] = _expired,
        ["skipped"] = _skipped,
        ["live"] = _live,
        ["drone_hits"] = _droneHits,
        ["kills"] = _kills,
        ["child_kills"] = _childKills,
        ["splits"] = _splits,
        ["respawns"] = _respawns,
        ["live_drones"] = _liveDrones,
        ["scans"] = _scans,
        ["scanned_bullets"] = _scannedBullets,
        ["scanned_drones"] = _scannedDrones,
    };
}
