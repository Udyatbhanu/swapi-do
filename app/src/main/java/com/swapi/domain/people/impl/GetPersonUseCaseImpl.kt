package com.swapi.domain.people.impl

import com.swapi.data.api.model.people.People
import com.swapi.data.repository.PeopleRepository
import com.swapi.domain.people.GetPersonUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetPersonUseCaseImpl @Inject constructor(private val peopleRepository: PeopleRepository) : GetPersonUseCase {
    override fun invoke(id: String): Single<People> {
        return peopleRepository.getPerson(id)
    }

}