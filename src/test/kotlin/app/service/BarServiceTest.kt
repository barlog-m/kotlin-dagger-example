package app.service

import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class BarServiceTest {
    @Test
    fun action() {
        val fooService = mock(FooService::class.java)
        val barService = BarServiceDefault(fooService)
        barService.bar()
        verify(fooService).foo()
    }
}
