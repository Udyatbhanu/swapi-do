package com.swapi.presentation.people.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.databinding.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.swapi.core.dagger.module.SCHEDULER_IO
import com.swapi.core.dagger.module.SCHEDULER_MAIN_THREAD
import com.swapi.data.api.model.people.People
import com.swapi.domain.people.GetPeopleUseCase
import com.swapi.domain.people.SearchPeopleUseCase
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Named

/**
 *
 */
class PeopleViewModel @Inject constructor(
    private val getPeopleUseCase: GetPeopleUseCase,
    private val searchPeopleUseCase: SearchPeopleUseCase,
    @Named(SCHEDULER_IO) val subscribeOnScheduler: Scheduler,
    @Named(SCHEDULER_MAIN_THREAD) val observeOnScheduler: Scheduler
) : ViewModel() {
    private var _peopleViewModelList = MutableLiveData<ArrayList<PeopleListItemViewModel>>()

    private var _isLoading = MutableLiveData<Boolean>()
    private var _errorState = MutableLiveData<Boolean>()

    private val searchQuerySubject = PublishSubject.create<String>()
    private var searchQueryDisposable = Disposables.disposed()





    val getLoadState: LiveData<Boolean>
        get() = _isLoading


    val getErrorState: LiveData<Boolean>
        get() = _errorState

    val getPeople: LiveData<ArrayList<PeopleListItemViewModel>>
        get() = _peopleViewModelList


    private var _peopleList = ArrayList<PeopleListItemViewModel>()


    init {
        _isLoading.value = true
        getPeople()
        searchQueryDisposable = searchQuerySubject
            .flatMapSingle { query ->

                if (query.isNullOrEmpty()) {
                    getPeopleUseCase.invoke()
                } else {
                    searchPeopleUseCase.invoke(query)
                }


            }
            .subscribeOn(subscribeOnScheduler)
            .observeOn(observeOnScheduler)
            .subscribe(this::onResponse, this::onError)


    }

    @SuppressLint("CheckResult")
    private fun getPeople() {
        _isLoading.value = true
        getPeopleUseCase.invoke()
            .subscribeOn(subscribeOnScheduler)
            .observeOn(observeOnScheduler)
            .subscribe(this::onResponse, this::onError)
    }


    /**
     * On success response
     */
    private fun onResponse(people: List<People>) {
        _isLoading.value = false
        _errorState.value = false
        _peopleList.clear()
        people.map { item ->
            _peopleList.add(PeopleListItemViewModel(item))
        }

        _peopleViewModelList.value = _peopleList
    }


    /**
     * Update the error state
     */
    private fun onError(error: Throwable) {
        _isLoading.value = false
        _errorState.value = true
    }


    /**
     *
     */
    fun onQueryChange(query: String) {
        searchQuerySubject.onNext(query)
    }


    /**
     *
     */
    override fun onCleared() {
        super.onCleared()
        searchQueryDisposable.dispose()
    }


}