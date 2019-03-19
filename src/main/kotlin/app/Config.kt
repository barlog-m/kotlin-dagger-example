package app

import app.service.BarService
import app.service.BarServiceDefault
import app.service.FooService
import app.service.FooServiceDefault
import dagger.Provides
import dagger.Module
import javax.inject.Singleton

@Module
class Config {
    @Provides
    @Singleton
    fun fooService(): FooService = FooServiceDefault()

    @Provides
    @Singleton
    fun barService(fooService: FooService): BarService = BarServiceDefault(fooService)
}
