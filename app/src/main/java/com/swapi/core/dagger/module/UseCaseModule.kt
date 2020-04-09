package com.swapi.core.dagger.module

import com.swapi.domain.films.GetFilmUseCase
import com.swapi.domain.films.GetFilmsUseCase
import com.swapi.domain.films.SearchFilmsUseCase

import com.swapi.domain.films.impl.GetFilmUseCaseImpl
import com.swapi.domain.films.impl.GetFilmsUseCaseImpl
import com.swapi.domain.films.impl.SearchFilmsUseCaseImpl
import com.swapi.domain.people.GetPeopleUseCase
import com.swapi.domain.people.GetPersonUseCase
import com.swapi.domain.people.SearchPeopleUseCase
import com.swapi.domain.people.impl.GetPeopleUseCaseImpl
import com.swapi.domain.people.impl.GetPersonUseCaseImpl
import com.swapi.domain.people.impl.SearchPeopleUseCaseImpl
import dagger.Binds
import dagger.Module


/**
 * Use case modules used in the domain layer
 */
@Module
abstract class UseCaseModule {

    /**
     *
     */
    @Binds
    abstract fun provideGetPeopleUseCase(getPeopleUseCase: GetPeopleUseCaseImpl): GetPeopleUseCase


    /**
     *
     */
    @Binds
    abstract fun provideSearchPeopleUseCase(getSearchPeopleUseCase: SearchPeopleUseCaseImpl): SearchPeopleUseCase


    /**
     *
     */
    @Binds
    abstract fun provideGetPersonUseCase(getPersonUseCaseImpl: GetPersonUseCaseImpl): GetPersonUseCase









    /**
     *
     */
    @Binds
    abstract fun provideGetFilmsUseCase(getFilmsUseCase: GetFilmsUseCaseImpl): GetFilmsUseCase


    /**
     *
     */
    @Binds
    abstract fun provideSearchFilmsUseCase(searchFilmsUseCase: SearchFilmsUseCaseImpl): SearchFilmsUseCase

    /**
     *
     */
    @Binds
    abstract fun provideFilmUseCase(getFilmUseCase: GetFilmUseCaseImpl): GetFilmUseCase


}