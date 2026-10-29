package godot.tests.dependencies

import com.fasterxml.jackson.databind.Module
import godot.annotation.Register
import godot.annotation.Script
import godot.api.Node
import org.apache.commons.io.IOUtils
import org.apache.commons.lang3.StringUtils
import org.apache.logging.log4j.util.StackLocatorUtil
import org.joda.time.LocalDate
import java.nio.charset.StandardCharsets
import java.util.ServiceLoader

// Exercises one dependency of each Gradle configuration: implementation ends up in godot-bootstrap.jar,
// godotGameImplementation is shaded into usercode.jar and godotSplitImplementation stays an intact jar
// under jvm/<variant>/dependencies/ that the manifest references. The runtime-only variants are packaged the
// same way but are not on the compile classpath, so they can only be reached by name.
@Script
class DependencyTest : Node() {
    @Register
    fun bootstrapJarDependency(): String = LocalDate(2024, 1, 1).year.toString()

    @Register
    fun userCodeJarDependency(): String = StringUtils.capitalize("godot")

    @Register
    fun singleJarDependency(): String =
        IOUtils.toString(IOUtils.toInputStream("jvm", StandardCharsets.UTF_8), StandardCharsets.UTF_8)

    @Register
    fun userCodeJarRuntimeOnlyDependency(): String = Class.forName("org.apache.commons.collections4.Bag").simpleName

    @Register
    fun singleJarRuntimeOnlyDependency(): String = Class.forName("org.apache.commons.codec.binary.Hex").simpleName

    @Register
    fun mergedServiceProviders(): String =
        ServiceLoader.load(Module::class.java, javaClass.classLoader)
            .map { module -> module.javaClass.simpleName }
            .sorted()
            .joinToString(",")

    // log4j-api ships a Java 9+ StackLocator under META-INF/versions/9; its Java 8 one returns null on current JDKs.
    @Register
    fun multiReleaseDependency(): String = StackLocatorUtil.getCallerClass(1)?.simpleName ?: "null"
}
