package godot.tests.dependencies

import org.apache.commons.io.IOUtils
import org.apache.commons.lang3.StringUtils
import java.nio.charset.StandardCharsets

object GodotDependencyConfigurations {
    fun mainJarDependency(): String = StringUtils.capitalize("godot")

    fun singleJarDependency(): String =
        IOUtils.toString(IOUtils.toInputStream("jvm", StandardCharsets.UTF_8), StandardCharsets.UTF_8)
}
