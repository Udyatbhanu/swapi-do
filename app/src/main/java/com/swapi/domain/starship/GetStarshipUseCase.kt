package com.swapi.domain.starship

import com.swapi.data.api.model.starship.Starship
import io.reactivex.Single


interface GetStarshipsUseCase{
    fun invoke(url : String): Single<Starship>
}