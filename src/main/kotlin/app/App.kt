package app

import app.service.BarService
import dagger.Component
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {
    fun app(): App
}

class App @Inject constructor(
   private val barService: BarService
): Runnable {
    override fun run() {
        barService.action()
    }
}

fun main() {
    DaggerAppComponent.create().app().run()
}
