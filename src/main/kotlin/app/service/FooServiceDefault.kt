package app.service

import app.model.Message
import mu.KLogging
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FooServiceDefault @Inject constructor() : FooService {
    companion object: KLogging()

    override fun foo() : Message {
        logger.debug { "invoked" }
        return Message("foo")
    }
}
