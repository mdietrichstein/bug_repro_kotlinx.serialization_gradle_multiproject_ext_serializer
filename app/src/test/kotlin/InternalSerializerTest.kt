import junit.framework.Assert.assertEquals
import kotlinx.serialization.Serializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import org.junit.Test

data class InternalData(val a: Int, val b: Int)

@Serializer(forClass = InternalData::class)
object ExtInternalDataSerializer

/**
 * Note: Comment out the code in "ExternalSerializerTest.kt" in order to run this
 */
class InternalSerializerTest {
    @Test
    fun test() {
        val json = Json(JsonConfiguration.Stable.copy(unquoted = true))

        val data = InternalData(1, 2)
        assertEquals("{a:1,b:2}", json.stringify(ExtInternalDataSerializer, data))
        assertEquals(data, Json.parse(ExtInternalDataSerializer, "{a:1,b:2}"))
    }
}