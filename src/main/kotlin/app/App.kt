package app

import app.service.BarService
import dagger.Component
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Component(modules = [Config::class])
interface AppComponent {
    fun app(): App
}

class App @Inject constructor(
   private val barService: BarService
): Runnable {
    override fun run() {
        barService.bar()
    }
}

fun main() {
    DaggerAppComponent.create().app().run()
}
