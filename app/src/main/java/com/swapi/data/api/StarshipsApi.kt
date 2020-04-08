package com.swapi.data.api

import com.swapi.data.api.model.people.PeopleResponse
import com.swapi.data.api.model.people.PersonResponse
import com.swapi.data.api.model.starship.StarshipsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface StarshipsApi {

    /**
     * Get Starships
     */
    @GET(Endpoints.STARSHIPS)
    fun getPeople(): Single<StarshipsResponse>


    /**
     * Search Starships
     */
    @GET(Endpoints.STARSHIPS)
    fun searchPeople(@Query("search") search: String): Single<StarshipsResponse>


    /**
     * Get Starship from url
     */
    @GET
    fun getPerson(@Url url: String): Single<StarshipsResponse>
}