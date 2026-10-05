extends RefCounted

var samples: Array[float] = []


func add(value: float) -> void:
	samples.append(value)


func size() -> int:
	return samples.size()


func to_dict(keep_samples: bool) -> Dictionary:
	var sorted := samples.duplicate()
	sorted.sort()
	var count := sorted.size()
	var total := 0.0
	for sample in sorted:
		total += sample
	var mean := total / count

	var variance := 0.0
	for sample in sorted:
		variance += (sample - mean) * (sample - mean)
	var median := _percentile(sorted, 0.5)

	var deviations: Array[float] = []
	for sample in sorted:
		deviations.append(absf(sample - median))
	deviations.sort()

	var stats := {
		"n": count,
		"min": sorted[0],
		"max": sorted[count - 1],
		"mean": mean,
		"median": median,
		"p90": _percentile(sorted, 0.90),
		"p95": _percentile(sorted, 0.95),
		"p99": _percentile(sorted, 0.99),
		"stddev": sqrt(variance / count),
		"mad": _percentile(deviations, 0.5),
	}
	if keep_samples:
		stats["samples"] = samples.duplicate()
	return stats


## Linear interpolation between the two neighbouring samples, so a percentile does not snap to a sample value.
func _percentile(sorted: Array, ratio: float) -> float:
	var count := sorted.size()
	if count == 1:
		return sorted[0]
	var position := ratio * (count - 1)
	var lower := int(floor(position))
	var upper := mini(lower + 1, count - 1)
	return lerpf(sorted[lower], sorted[upper], position - lower)
