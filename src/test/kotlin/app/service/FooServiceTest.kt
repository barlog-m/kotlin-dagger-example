package app.service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class FooServiceTest {
    @Test
    fun action() {
        val fooService = FooServiceDefault()
        assertEquals("foo", fooService.foo())
    }
}
