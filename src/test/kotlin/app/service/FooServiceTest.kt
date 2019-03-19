package app.service

import app.model.Message
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class FooServiceTest {
    @Test
    fun action() {
        val fooService = FooServiceDefault()
        assertEquals(Message("foo"), fooService.foo())
    }
}
