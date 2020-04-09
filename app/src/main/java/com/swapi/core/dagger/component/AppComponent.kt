package com.swapi.core.dagger.component

import android.app.Application
import com.swapi.core.dagger.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton


/**
 * AppComponent binds all the modules
 */
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ViewModelFactoryModule::class,
        AppModule::class,
        BindingModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        UseCaseModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}