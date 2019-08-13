import junit.framework.Assert.assertEquals
import kotlinx.serialization.Serializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import org.junit.Test

@Serializer(forClass = Data::class)
object ExtExternalDataSerializer

class ExternalSerializerTest {
    @Test
    fun triggerBug() {
        val json = Json(JsonConfiguration.Stable.copy(unquoted = true))

        val data = Data(1, 2)
        assertEquals("{a:1,b:2}", json.stringify(ExtExternalDataSerializer, data))
        assertEquals(data, Json.parse(ExtExternalDataSerializer, "{a:1,b:2}"))
    }
}