package com.swapi.presentation.people.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.swapi.core.dagger.module.SCHEDULER_IO
import com.swapi.core.dagger.module.SCHEDULER_MAIN_THREAD
import com.swapi.data.api.model.people.People
import com.swapi.domain.people.GetPeopleUseCase
import com.swapi.domain.people.GetPersonUseCase
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

class PeopleDetailsViewModel @Inject constructor(
    private val getPeopleUseCase: GetPersonUseCase, @Named(SCHEDULER_IO) val subscribeOnScheduler: Scheduler,
    @Named(SCHEDULER_MAIN_THREAD) val observeOnScheduler: Scheduler
) : ViewModel() {
    private var _people = MutableLiveData<People>()

    val getPerson: LiveData<People>
        get() = _people

    var url : String = ""



    /**
     *
     */
     fun setArgs(url :String){
        this.url = url
        getPerson()
    }

    @SuppressLint("CheckResult")
    private fun getPerson(){
        getPeopleUseCase.invoke(url)
            .subscribeOn(subscribeOnScheduler)
            .observeOn(observeOnScheduler)
            .subscribe(this::onResponse, this::onError)

    }



    private fun onResponse(people: People) {
        _people.value = people
    }

    private fun onError(error: Throwable) {
        error // TODO handle error state here
    }

}