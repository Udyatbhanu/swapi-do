package com.swapi.data.repository.impl

import com.swapi.data.api.PeopleApi
import com.swapi.data.api.PlanetsApi
import com.swapi.data.api.model.people.People
import com.swapi.data.api.model.planet.Planet
import com.swapi.data.repository.PeopleRepository
import com.swapi.data.repository.PlanetsRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlanetsRepositoryImpl @Inject constructor(private val planetsApi: PlanetsApi) :
    PlanetsRepository {
    override fun getPlanets(): Single<List<Planet>> {
        TODO("Not yet implemented")
    }

    override fun searchPlanets(query: String): Single<List<Planet>> {
        TODO("Not yet implemented")
    }

    override fun getPlanet(id: String): Single<Planet> {
        TODO("Not yet implemented")
    }


}