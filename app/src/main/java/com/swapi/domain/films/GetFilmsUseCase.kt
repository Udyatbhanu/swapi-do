package com.swapi.domain.films

import com.swapi.core.UseCase
import com.swapi.data.api.model.film.Film
import com.swapi.data.api.model.people.People
import io.reactivex.Single

interface GetFilmsUseCase : UseCase<List<Film>> {
    override operator fun invoke(): Single<List<Film>>

}