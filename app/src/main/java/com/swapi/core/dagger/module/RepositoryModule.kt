package com.swapi.core.dagger.module

import com.swapi.data.repository.PeopleRepository
import com.swapi.data.repository.impl.PeopleRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule{

    @Binds
    abstract fun providePeopleRepository(getPeopleRepository : PeopleRepositoryImpl): PeopleRepository



}