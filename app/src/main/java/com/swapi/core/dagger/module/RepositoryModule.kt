package com.swapi.core.dagger.module

import com.swapi.data.repository.FilmsRepository
import com.swapi.data.repository.PeopleRepository
import com.swapi.data.repository.PlanetsRepository
import com.swapi.data.repository.StarshipsRepository
import com.swapi.data.repository.impl.FilmsRepositoryImpl
import com.swapi.data.repository.impl.PeopleRepositoryImpl
import com.swapi.data.repository.impl.PlanetsRepositoryImpl
import com.swapi.data.repository.impl.StarshipsRepositoryImpl
import dagger.Binds
import dagger.Module


/**
 * Repository dagger module for which will be the single source of data
 */
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun providePeopleRepository(getPeopleRepository: PeopleRepositoryImpl): PeopleRepository

    @Binds
    abstract fun provideFilmsRepository(filmsRepository: FilmsRepositoryImpl): FilmsRepository


    @Binds
    abstract fun providePlanetsRepository(planetsRepository: PlanetsRepositoryImpl): PlanetsRepository


    @Binds
    abstract fun provideStarshipsRepository(starshipsRepository: StarshipsRepositoryImpl): StarshipsRepository


}