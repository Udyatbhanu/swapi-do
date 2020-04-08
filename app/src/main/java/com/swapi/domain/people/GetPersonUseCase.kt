package com.swapi.domain.people

import com.swapi.data.api.model.people.People
import io.reactivex.Single

interface GetPersonUseCase{
    fun invoke(id : String): Single<People>
}