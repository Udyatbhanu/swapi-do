package com.swapi.presentation.films.viewmodel

import androidx.lifecycle.ViewModel
import com.swapi.core.dagger.module.SCHEDULER_IO
import com.swapi.core.dagger.module.SCHEDULER_MAIN_THREAD
import com.swapi.domain.films.usecase.GetFilmsUseCase
import com.swapi.domain.people.GetPeopleUseCase
import com.swapi.domain.people.SearchPeopleUseCase
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

class FilmsViewModel @Inject constructor(
    private val getFilmsUseCase: GetFilmsUseCase,
    private val searchPeopleUseCase: SearchPeopleUseCase,
    @Named(SCHEDULER_IO) val subscribeOnScheduler: Scheduler,
    @Named(SCHEDULER_MAIN_THREAD) val observeOnScheduler: Scheduler
) : ViewModel() {


}