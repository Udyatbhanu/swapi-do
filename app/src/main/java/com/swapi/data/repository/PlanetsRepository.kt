package com.swapi.data.repository

import com.swapi.data.api.model.planet.Planet
import io.reactivex.Single

interface PlanetsRepository{


    fun getPlanets(): Single<List<Planet>>

    fun searchPlanets(query : String): Single<List<Planet>>


    fun getPlanet(id : String): Single<Planet>

}