package com.swapi.data.api

import com.swapi.data.api.model.people.PeopleResponse
import com.swapi.data.api.model.people.PersonResponse
import com.swapi.data.api.model.planet.PlanetsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url


interface PlanetsApi {

    /**
     * Get Planets
     */
    @GET(Endpoints.PLANETS)
    fun getPeople(): Single<PlanetsResponse>


    /**
     * Search Planets
     */
    @GET(Endpoints.PLANETS)
    fun searchPeople(@Query("search") search: String): Single<PlanetsResponse>


    /**
     * Get Planet from url
     */
    @GET
    fun getPerson(@Url url: String): Single<PlanetsResponse>
}