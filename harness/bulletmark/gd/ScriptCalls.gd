## Counts every call the engine makes into the scene's scripts: physics steps, signal handlers, draws, deferred calls
## and timer lambdas. The game is deterministic, so two runs with the same settings make exactly the same calls, in
## any language.

static var count := 0
