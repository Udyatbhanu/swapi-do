package com.swapi.core.dagger.module

import com.swapi.domain.people.GetPeopleUseCase
import com.swapi.domain.people.impl.GetPeopleUseCaseImpl
import dagger.Binds
import dagger.Module


@Module
abstract class UseCaseModule {

    /**
     *
     */
    @Binds
    abstract fun provideGetPeopleUseCase(getDisplayUseCase: GetPeopleUseCaseImpl): GetPeopleUseCase

}