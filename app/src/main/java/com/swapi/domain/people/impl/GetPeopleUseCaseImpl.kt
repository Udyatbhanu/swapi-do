package com.swapi.domain.people.impl

import com.swapi.data.api.model.people.People
import com.swapi.data.repository.PeopleRepository
import com.swapi.domain.people.GetPeopleUseCase
import io.reactivex.Single
import javax.inject.Inject

/**
 * Implementation of the get people use case, ideally this should be a paginated implementation (TODO for future releases)
 */
class GetPeopleUseCaseImpl @Inject constructor(private val peopleRepository: PeopleRepository):
    GetPeopleUseCase {
    override fun invoke(): Single<List<People>> {
       return peopleRepository.getPeople()
    }

}