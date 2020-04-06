package com.swapi.domain.people.impl

import com.swapi.data.api.model.people.People
import com.swapi.data.repository.PeopleRepository
import com.swapi.domain.people.SearchPeopleUseCase
import io.reactivex.Single
import javax.inject.Inject

class SearchPeopleUseCaseImpl  @Inject constructor(private val peopleRepository: PeopleRepository): SearchPeopleUseCase{


    /**
     * Invoke search use case
     */
    override fun invoke(query: String): Single<List<People>> {
        return peopleRepository.searchPeople(query)
    }

}