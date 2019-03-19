package app.service

import mu.KLogging
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BarServiceDefault @Inject constructor(
    private val fooService: FooService
) : BarService {
    companion object : KLogging()

    override fun bar() {
        logger.debug { "invoked" }
        val msg: String = fooService.foo()
        printMessage(msg)
    }

    private fun printMessage(msg: String) {
        println("foo message: '$msg'")
    }
}
