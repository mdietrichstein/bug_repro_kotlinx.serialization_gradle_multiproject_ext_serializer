### kotlinx.serialization Bug Repro

The compiler throws `java.lang.IllegalStateException: Class Data have constructor parameters which are not properties and therefore it is not serializable automatically` when trying to run `./gradlew clean test`. The root cause seems to be that the class `Data` is defined in a different gradle module than the serializer. See `ExternalSerializerTest`.

If both are defined in the same module the exceptions does not occur. See `InternalSerializerTest`. Note that you'll have to comment out the code in `ExternalSerializerTest` to get rid of the compiler error and run this.
