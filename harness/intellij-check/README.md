# IntelliJ inspection check project

This project contains a manually reviewable 3x3 inspection matrix. Choose the
matching value under **Settings | Godot-JVM | Annotation processing
mode**, then open the corresponding file:

| Language | Explicit                           | Inferred                           | Automatic                           |
|----------|------------------------------------|------------------------------------|-------------------------------------|
| Kotlin   | `IdeKotlinInspectionExplicit.kt`   | `IdeKotlinInspectionInferred.kt`   | `IdeKotlinInspectionAutomatic.kt`   |
| Java     | `IdeJavaInspectionExplicit.java`   | `IdeJavaInspectionInferred.java`   | `IdeJavaInspectionAutomatic.java`   |
| Scala    | `IdeScalaInspectionExplicit.scala` | `IdeScalaInspectionInferred.scala` | `IdeScalaInspectionAutomatic.scala` |

The files for each language contain equivalent declaration cases. Their
package, class, and custom registered names differ by mode so all nine files
can remain open in the same project without creating cross-file name
collisions.

These are also the source fixtures used by the IDE plugin's
`CodeInsightTestFixture` tests. The assertions in `KotlinInspectionTest`,
`JavaInspectionTest`, and `ScalaInspectionTest` are authoritative for the
diagnostics expected in each mode.

`CopyModificationCheckTestClass.kt` remains a separate Kotlin-only check and
is not part of the registration matrix.

## Registration highlighting examples

The `godot.registration.examples` package contains the exhaustive registration
examples from the user guide as a second 3x3 matrix:

| Language | Explicit                                 | Inferred                                 | Automatic                                 |
|----------|------------------------------------------|------------------------------------------|-------------------------------------------|
| Kotlin   | `KotlinRegistrationExplicitExample.kt`   | `KotlinRegistrationInferredExample.kt`   | `KotlinRegistrationAutomaticExample.kt`   |
| Java     | `JavaRegistrationExplicitExample.java`   | `JavaRegistrationInferredExample.java`   | `JavaRegistrationAutomaticExample.java`   |
| Scala    | `ScalaRegistrationExplicitExample.scala` | `ScalaRegistrationInferredExample.scala` | `ScalaRegistrationAutomaticExample.scala` |

Select the mode matching the file before reviewing it. Explicit and Inferred
examples should show six green declaration lines. Automatic examples should
show seven. These files are valid usage examples; the inspection fixtures above
remain the place to review invalid and candidate declarations.
