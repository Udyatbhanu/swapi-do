package com.swapi.domain.films

import com.swapi.data.api.model.film.Film
import io.reactivex.Single

interface GetFilmUseCase{
    fun invoke(url : String): Single<Film>

}