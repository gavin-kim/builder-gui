import java.io.FileInputStream
import java.util.*

object FileLoader {
    fun loadProperties(file: String): Properties {
        val inputStream = FileInputStream(file)
        val properties = Properties()

        properties.load(inputStream)
        return properties
    }
}