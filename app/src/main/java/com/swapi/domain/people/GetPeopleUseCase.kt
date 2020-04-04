package com.swapi.domain.people

import com.swapi.core.UseCase
import com.swapi.data.api.model.people.People
import io.reactivex.Single


/**
 * Get people use case
 */
interface GetPeopleUseCase  : UseCase<List<People>> {
    override operator fun invoke(): Single<List<People>>

}