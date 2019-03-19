package app.service

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FooService @Inject constructor() {
    fun action() = "foo"
}
