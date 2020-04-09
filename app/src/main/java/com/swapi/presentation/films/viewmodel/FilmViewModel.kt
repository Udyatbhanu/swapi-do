package com.swapi.presentation.films.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.swapi.core.dagger.module.SCHEDULER_IO
import com.swapi.core.dagger.module.SCHEDULER_MAIN_THREAD
import com.swapi.data.api.model.film.Film
import com.swapi.domain.films.GetFilmsUseCase
import com.swapi.domain.films.SearchFilmsUseCase

import io.reactivex.Scheduler
import io.reactivex.disposables.Disposables
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Named

class FilmsViewModel @Inject constructor(
    private val getFilmsUseCase: GetFilmsUseCase,
    private val searchFilmsUseCase: SearchFilmsUseCase,
    @Named(SCHEDULER_IO) val subscribeOnScheduler: Scheduler,
    @Named(SCHEDULER_MAIN_THREAD) val observeOnScheduler: Scheduler
) : ViewModel() {

    private var _filmsListItemViewModel = MutableLiveData<ArrayList<FilmsListItemViewModel>>()




    private val searchQuerySubject = PublishSubject.create<String>()
    private var searchQueryDisposable = Disposables.disposed()




    val getFilms: LiveData<ArrayList<FilmsListItemViewModel>>
        get() = _filmsListItemViewModel


    private var _filmsList = ArrayList<FilmsListItemViewModel>()


    init {
        getFilms()
        searchQueryDisposable = searchQuerySubject
            .flatMapSingle { query ->

                if (query.isNullOrEmpty()){
                    getFilmsUseCase.invoke()
                } else{
                    searchFilmsUseCase.invoke(query)
                }


            }
            .subscribeOn(subscribeOnScheduler)
            .observeOn(observeOnScheduler)
            .subscribe(this::onResponse, this::onError)


    }

    @SuppressLint("CheckResult")
    private fun getFilms() {
        getFilmsUseCase.invoke()
            .subscribeOn(subscribeOnScheduler)
            .observeOn(observeOnScheduler)
            .subscribe(this::onResponse, this::onError)
    }


    private fun onResponse(people: List<Film>) {
        _filmsList.clear()
        people.map { item ->
            _filmsList.add(FilmsListItemViewModel(item))
        }

        _filmsListItemViewModel.value = _filmsList
    }

    private fun onError(error: Throwable) {
        error // TODO handle error state here
    }


    /**
     *
     */
    fun onQueryChange(query: String){
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