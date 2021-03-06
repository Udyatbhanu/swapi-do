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
                People(people.name,people.height, people.mass, people.films, people.species, people.vehicles, people.starships, people.url)
            }
        }
    }


    /**
     * For search use case
     */
    override fun searchPeople(query: String): Single<List<People>> {
        return peopleApi.searchPeople(query).map {
            it.results.map { people ->
                People(people.name,people.height, people.mass, people.films, people.species, people.vehicles, people.starships, people.url)
            }
        }
    }


    /**
     *
     */
    override fun getPerson(url: String): Single<People> {

        return  peopleApi.getPerson(url).flatMap { people->
            Single.just(People(people.name,people.height, people.mass, people.films, people.species, people.vehicles, people.starships, people.url ))
        }

    }

}