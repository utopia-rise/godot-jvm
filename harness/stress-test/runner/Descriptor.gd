extends RefCounted

## Per-test settings, declared by the test itself in the `stress_tests()` dictionary of its suite. Everything that
## describes how hard the whole run is (iterations, warmup, rounds) belongs to the runner instead.
const KEYS := {
	"batch": TYPE_INT,      # objects, or operations, per step
	"threads": TYPE_INT,    # worker threads, race tests only
	"ms": TYPE_INT,         # how long the workers run, race tests only
	"frames": TYPE_INT,     # step budget for a test that would otherwise run forever
	"settle": TYPE_INT,     # frames allowed for everything the test created to be released
	"leftover": TYPE_INT,   # objects tolerated above the baseline once settled, see the README on the last one
	"unit": TYPE_STRING,    # what one operation means in the report, perf tests only
}
const DEFAULTS := {
	"batch": 1000, "threads": 4, "ms": 10000, "frames": 120,
	"settle": 1200, "leftover": 1, "unit": "us/op", "fuzz": false,
}


## A suite declares its tests in `stress_tests()`: test name -> descriptor.
static func declared(suite: Object) -> Dictionary:
	return suite.stress_tests() if suite.has_method("stress_tests") else {}


static func parse(name: String, category: String, descriptor: String) -> Dictionary:
	var test := DEFAULTS.duplicate()
	test.merge({"name": name, "category": category, "descriptor": descriptor}, true)
	for token in descriptor.split(" ", false):
		if token == "fuzz":
			test.fuzz = true
			continue
		var pair := token.split("=", true, 1)
		assert(pair.size() == 2 and KEYS.has(pair[0]), "%s: unknown descriptor token '%s'" % [name, token])
		if KEYS[pair[0]] == TYPE_INT:
			assert(pair[1].is_valid_int(), "%s: '%s' expects an integer" % [name, pair[0]])
			test[pair[0]] = int(pair[1])
		else:
			test[pair[0]] = pair[1]
	return test
