package com.swapi.core.dagger.module

import com.swapi.presentation.MainActivity
import com.swapi.presentation.MainFragment
import com.swapi.presentation.search.ui.SearchFragment
import com.swapi.presentation.search.ui.SearchResultsFragment
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
    abstract fun bindMainFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun bindSearchFragment(): SearchFragment

    @ContributesAndroidInjector
    abstract fun bindSearchResultsFragment(): SearchResultsFragment
}