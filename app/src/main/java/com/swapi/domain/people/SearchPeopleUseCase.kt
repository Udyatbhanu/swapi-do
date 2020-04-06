package com.swapi.domain.people

import com.swapi.core.UseCase
import com.swapi.data.api.model.people.People
import io.reactivex.Single

interface SearchPeopleUseCase {

    fun invoke(query : String): Single<List<People>>

}