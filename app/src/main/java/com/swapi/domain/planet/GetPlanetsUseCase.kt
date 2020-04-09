package com.swapi.domain.planet

import com.swapi.data.api.model.planet.Planet
import io.reactivex.Single

interface GetPlanetsUseCase{
    fun invoke(url : String): Single<Planet>
}