package com.swapi.data.repository

import com.swapi.data.api.model.people.People
import io.reactivex.Single

interface PeopleRepository {

    fun getPeople(): Single<List<People>>

    fun searchPeople(query : String): Single<List<People>>


    fun getPerson(id : String): Single<People>
}