package com.swapi.data.repository.impl

import com.swapi.data.api.PeopleApi
import com.swapi.data.api.model.people.People
import com.swapi.data.repository.PeopleRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton


/**
 *
 */
@Singleton
class PeopleRepositoryImpl @Inject constructor(private val peopleApi: PeopleApi) :
    PeopleRepository {


    /**
     * Map the people response
     */
    override fun getPeople(): Single<List<People>> {
        return peopleApi.getPeople().map {
            it.results.map { people ->
                People(people.name, people.films, people.species, people.vehicles, people.starships)
            }
        }
    }


    /**
     * For search use case
     */
    override fun searchPeople(query: String): Single<List<People>> {
        return peopleApi.searchPeople(query).map {
            it.results.map { people ->
                People(people.name, people.films, people.species, people.vehicles, people.starships)
            }
        }
    }

}