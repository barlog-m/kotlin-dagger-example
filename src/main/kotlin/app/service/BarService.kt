package app.service

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BarService @Inject constructor(
    private val fooService: FooService
) {
    fun action() {
        println(fooService.action())
    }
}
