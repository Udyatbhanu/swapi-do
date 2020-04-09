package com.swapi.core.dagger.module

import com.swapi.presentation.MainActivity
import com.swapi.presentation.MainFragment
import com.swapi.presentation.films.ui.FilmDetailsFragment
import com.swapi.presentation.films.ui.FilmsFragment
import com.swapi.presentation.misc.ComingSoonFragment
import com.swapi.presentation.people.ui.PeopleDetailsFragment
import com.swapi.presentation.people.ui.PeopleFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Module to declare UI components that have injectable members
 */
@Module
abstract class BindingModule {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindMMainFragment(): MainFragment



    @ContributesAndroidInjector
    abstract fun bindPeopleFragment(): PeopleFragment

    @ContributesAndroidInjector
    abstract fun bindFilmFragment(): FilmsFragment


    @ContributesAndroidInjector
    abstract fun bindPeopleDetailsFragment(): PeopleDetailsFragment


    @ContributesAndroidInjector
    abstract fun bindComingSoonFragment(): ComingSoonFragment


    @ContributesAndroidInjector
    abstract fun bindFilmDetailsFragment(): FilmDetailsFragment



}