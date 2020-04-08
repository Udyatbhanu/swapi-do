package com.swapi.data.repository

import com.swapi.data.api.model.film.Film
import io.reactivex.Single

interface FilmsRepository{

    fun getFilms(): Single<List<Film>>

    fun searchFilms(query : String): Single<List<Film>>


    fun getFilm(id : String): Single<Film>

}