package com.swapi.domain.films.impl

import com.swapi.data.api.model.film.Film
import com.swapi.data.repository.FilmsRepository
import com.swapi.domain.films.GetFilmUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetFilmUseCaseImpl @Inject constructor(private val filmsRepository: FilmsRepository) :
    GetFilmUseCase {
    override fun invoke(url: String): Single<Film> {
        return filmsRepository.getFilm(url)
    }

}