# Bunnymark Computation

The same shape as BunnymarkDrawTexture, drawing every bunny with `draw_texture` and using no nodes at all, but
each bunny orbits a random point of the screen instead of falling and bouncing.

Where the other benchmarks move a bunny with a handful of multiplies and a few comparisons, this one rebuilds the
position from scratch every frame: two waves give an offset, that offset is turned into a distance and an angle,
the angle is perturbed by a third wave, and the result is turned back into a position. Seven transcendental
operations per bunny per frame, against none in the others.

It isolates raw floating-point throughput of the scripting language. Nothing crosses the engine boundary in the
loop, so a result here says little about the binding and a lot about the language runtime's arithmetic.
