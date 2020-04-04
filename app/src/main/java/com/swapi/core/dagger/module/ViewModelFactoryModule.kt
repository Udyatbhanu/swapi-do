package com.swapi.core.dagger.module

import androidx.lifecycle.ViewModelProvider
import com.swapi.core.dagger.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule{

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}