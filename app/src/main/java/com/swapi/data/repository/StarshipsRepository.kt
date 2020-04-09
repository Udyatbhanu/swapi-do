package com.swapi.data.repository

import com.swapi.data.api.model.starship.Starship
import io.reactivex.Single

interface StarshipsRepository{



    fun getStarships(): Single<List<Starship>>

    fun searchStarships(query : String): Single<List<Starship>>


    fun getStarship(id : String): Single<Starship>
}