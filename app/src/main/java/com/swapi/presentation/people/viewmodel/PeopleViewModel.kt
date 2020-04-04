package com.swapi.presentation.people.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.swapi.core.dagger.module.SCHEDULER_IO
import com.swapi.core.dagger.module.SCHEDULER_MAIN_THREAD
import com.swapi.data.api.model.people.People
import com.swapi.domain.people.GetPeopleUseCase
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

/**
 *
 */
class PeopleViewModel @Inject constructor(
    private val getPeopleUseCase: GetPeopleUseCase,
    @Named(SCHEDULER_IO) val subscribeOnScheduler: Scheduler,
    @Named(SCHEDULER_MAIN_THREAD) val observeOnScheduler: Scheduler
) : ViewModel() {

    private var _peopleViewModelList = MutableLiveData<ArrayList<PeopleListItemViewModel>>()


    val getPeople: LiveData<ArrayList<PeopleListItemViewModel>>
        get() = _peopleViewModelList


    private var _peopleList = ArrayList<PeopleListItemViewModel>()


    init {
        getPeople()
    }

    @SuppressLint("CheckResult")
    private fun getPeople() {
        getPeopleUseCase.invoke()
            .subscribeOn(subscribeOnScheduler)
            .observeOn(observeOnScheduler)
            .subscribe(this::onResponse, this::onError)
    }


    private fun onResponse(people: List<People>) {
        people.map { item ->
            _peopleList.add(PeopleListItemViewModel(item))
        }

        _peopleViewModelList.value = _peopleList
    }

    private fun onError(error: Throwable) {
        error // TODO handle error state here
    }

}