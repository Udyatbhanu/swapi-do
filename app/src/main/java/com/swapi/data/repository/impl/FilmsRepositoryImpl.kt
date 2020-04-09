package com.swapi.data.repository.impl

import com.swapi.data.api.FilmsApi
import com.swapi.data.api.model.film.Film
import com.swapi.data.repository.FilmsRepository
import io.reactivex.Single
import javax.inject.Inject

class FilmsRepositoryImpl @Inject constructor(private val filmsApi: FilmsApi) : FilmsRepository {


    /**
     *
     */
    override fun getFilms(): Single<List<Film>> {
        return filmsApi.getFilms().map {
            it.results.map { film ->
                Film(film.director, film.episodeId, film.openingCrawl, film.producer, film.releaseDate, film.title, film.url )
            }
        }
    }


    /**
     *
     */
    override fun searchFilms(query: String): Single<List<Film>> {
        return filmsApi.searchFilms(query).map {
            it.results.map { film ->
                Film(film.director, film.episodeId, film.openingCrawl, film.producer, film.releaseDate, film.title, film.url )
            }
        }
    }


    /**
     *
     */
    override fun getFilm(url: String): Single<Film> {
        return  filmsApi.getFilm(url).flatMap { film ->
            Single.just(  Film(film.director, film.episodeId, film.openingCrawl, film.producer, film.releaseDate, film.title, film.url ))
        }
    }

}