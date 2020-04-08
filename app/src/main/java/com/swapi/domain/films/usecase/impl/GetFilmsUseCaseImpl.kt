package com.swapi.domain.films.usecase.impl

import com.swapi.data.api.model.film.Film
import com.swapi.domain.films.usecase.GetFilmsUseCase
import io.reactivex.Single

class GetFilmsUseCaseImpl : GetFilmsUseCase {
    override fun invoke(): Single<List<Film>> {
        TODO("Not yet implemented")
    }

}