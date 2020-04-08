package com.swapi.core.dagger.module

import com.swapi.data.repository.FilmsRepository
import com.swapi.data.repository.PeopleRepository
import com.swapi.data.repository.impl.FilmsRepositoryImpl
import com.swapi.data.repository.impl.PeopleRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule{

    @Binds
    abstract fun providePeopleRepository(getPeopleRepository : PeopleRepositoryImpl): PeopleRepository

    @Binds
    abstract fun provideFilmsRepository(filmsRepository : FilmsRepositoryImpl): FilmsRepository



}