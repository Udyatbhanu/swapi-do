package com.swapi.data.repository.impl

import com.swapi.data.api.FilmsApi
import com.swapi.data.api.model.film.Film
import com.swapi.data.repository.FilmsRepository
import io.reactivex.Single
import javax.inject.Inject

class FilmsRepositoryImpl @Inject constructor(private val filmsApi: FilmsApi) : FilmsRepository {
    override fun getFilms(): Single<List<Film>> {
        TODO("Not yet implemented")
    }

    override fun searchFilms(query: String): Single<List<Film>> {
        TODO("Not yet implemented")
    }

    override fun getFilm(id: String): Single<Film> {
        TODO("Not yet implemented")
    }

}