package com.swapi.domain.films

import com.swapi.data.api.model.film.Film
import io.reactivex.Single

interface SearchFilmsUseCase {

    fun invoke(query : String): Single<List<Film>>

}