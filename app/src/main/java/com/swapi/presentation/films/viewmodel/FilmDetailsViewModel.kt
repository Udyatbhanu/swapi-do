package com.swapi.presentation.films.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.swapi.core.dagger.module.SCHEDULER_IO
import com.swapi.core.dagger.module.SCHEDULER_MAIN_THREAD
import com.swapi.data.api.model.film.Film
import com.swapi.data.api.model.people.People
import com.swapi.domain.films.GetFilmUseCase
import com.swapi.domain.people.GetPersonUseCase
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

class FilmDetailsViewModel @Inject constructor(
    private val getFilmUseCase: GetFilmUseCase, @Named(SCHEDULER_IO) val subscribeOnScheduler: Scheduler,
    @Named(SCHEDULER_MAIN_THREAD) val observeOnScheduler: Scheduler
) : ViewModel() {

    private var _film = MutableLiveData<Film>()

    val getFilm: LiveData<Film>
        get() = _film

    var url : String = ""



    /**
     *
     */
    fun setArgs(url :String){
        this.url = url
        getFilm()
    }

    @SuppressLint("CheckResult")
    private fun getFilm(){
        getFilmUseCase.invoke(url)
            .subscribeOn(subscribeOnScheduler)
            .observeOn(observeOnScheduler)
            .subscribe(this::onResponse, this::onError)

    }



    private fun onResponse(people: Film) {
        _film.value = people
    }

    private fun onError(error: Throwable) {
        error // TODO handle error state here
    }
}