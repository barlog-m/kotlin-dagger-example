package app.service

import mu.KLogging
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FooServiceDefault @Inject constructor() : FooService {
    companion object: KLogging()

    override fun foo() : String {
        logger.debug { "invoked" }
        return "foo"
    }
}
