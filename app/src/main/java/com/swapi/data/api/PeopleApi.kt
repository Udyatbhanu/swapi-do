package com.swapi.data.api

import com.swapi.data.api.Endpoints
import com.swapi.data.api.model.people.People
import com.swapi.data.api.model.people.PeopleResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


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
     *
     */
    @GET(Endpoints.PEOPLE)
    fun getPerson(@Path("id" )id: String): Single<People>
}