package com.swapi.core.dagger.module

import androidx.lifecycle.ViewModel
import com.swapi.core.dagger.ViewModelKey
import com.swapi.presentation.people.viewmodel.PeopleDetailsViewModel
import com.swapi.presentation.people.viewmodel.PeopleViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PeopleViewModel::class)
    internal abstract  fun bindPeopleViewModel(viewModel: PeopleViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PeopleDetailsViewModel::class)
    internal abstract  fun bindPeopleDetailsViewModel(viewModel: PeopleDetailsViewModel) : ViewModel

}