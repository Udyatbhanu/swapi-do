package com.swapi.presentation.people.viewmodel

import androidx.lifecycle.ViewModel
import com.swapi.core.dagger.module.SCHEDULER_IO
import com.swapi.core.dagger.module.SCHEDULER_MAIN_THREAD
import com.swapi.domain.people.GetPeopleUseCase
import com.swapi.domain.people.GetPersonUseCase
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

class PeopleDetailsViewModel @Inject constructor(
    private val getPeopleUseCase: GetPersonUseCase, @Named(SCHEDULER_IO) val subscribeOnScheduler: Scheduler,
    @Named(SCHEDULER_MAIN_THREAD) val observeOnScheduler: Scheduler
) : ViewModel() {

}