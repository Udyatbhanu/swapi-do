package com.swapi.domain.films.impl

import com.swapi.data.api.model.film.Film
import com.swapi.data.repository.FilmsRepository
import com.swapi.domain.films.SearchFilmsUseCase
import io.reactivex.Single
import javax.inject.Inject

class SearchFilmsUseCaseImpl @Inject constructor(private val filmsRepository: FilmsRepository):
    SearchFilmsUseCase {
    override fun invoke(query: String): Single<List<Film>> {
        return filmsRepository.searchFilms(query)
    }

}