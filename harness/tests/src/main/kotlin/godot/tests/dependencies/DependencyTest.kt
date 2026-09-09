package godot.tests.dependencies

import godot.annotation.Register
import godot.annotation.Script
import godot.api.Node
import org.apache.commons.io.IOUtils
import org.apache.commons.lang3.StringUtils
import org.joda.time.LocalDate
import java.nio.charset.StandardCharsets

// Exercises one dependency of each Gradle configuration: implementation ends up in godot-bootstrap.jar, godotMain is
// shaded into main.jar and godotSingle stays an intact jar under jvm/external/ that main.jar's manifest references.
@Script
class DependencyTest : Node() {
    @Register
    fun bootstrapJarDependency(): String = LocalDate(2024, 1, 1).year.toString()

    @Register
    fun mainJarDependency(): String = StringUtils.capitalize("godot")

    @Register
    fun singleJarDependency(): String =
        IOUtils.toString(IOUtils.toInputStream("jvm", StandardCharsets.UTF_8), StandardCharsets.UTF_8)
}
