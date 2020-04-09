package com.swapi.domain.films.impl

import com.swapi.data.api.model.film.Film
import com.swapi.data.repository.FilmsRepository
import com.swapi.domain.films.GetFilmsUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetFilmsUseCaseImpl  @Inject constructor(private val filmsRepository: FilmsRepository):
    GetFilmsUseCase {
    override fun invoke(): Single<List<Film>> {
        return filmsRepository.getFilms()
    }

}