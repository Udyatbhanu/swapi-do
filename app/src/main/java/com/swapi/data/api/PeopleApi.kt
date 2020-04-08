package com.swapi.data.api

import com.swapi.data.api.Endpoints
import com.swapi.data.api.model.people.People
import com.swapi.data.api.model.people.PeopleResponse
import com.swapi.data.api.model.people.PersonResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url


/**
 *
 */
interface PeopleApi {

    /**
     * Get People
     */
    @GET(Endpoints.PEOPLE)
    fun getPeople(): Single<PeopleResponse>


    /**
     * Search people
     */
    @GET(Endpoints.PEOPLE)
    fun searchPeople(@Query("search") search: String): Single<PeopleResponse>


    /**
     * Get person from url
     */
    @GET
    fun getPerson(@Url url: String): Single<PersonResponse>
}