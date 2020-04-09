package com.swapi.data.repository.impl

import com.swapi.data.api.PeopleApi
import com.swapi.data.api.StarshipsApi
import com.swapi.data.api.model.starship.Starship
import com.swapi.data.repository.StarshipsRepository
import io.reactivex.Single
import javax.inject.Inject

class StarshipsRepositoryImpl @Inject constructor(private val peopleApi: StarshipsApi):
    StarshipsRepository {
    override fun getStarships(): Single<List<Starship>> {
        TODO("Not yet implemented")
    }

    override fun searchStarships(query: String): Single<List<Starship>> {
        TODO("Not yet implemented")
    }

    override fun getStarship(id: String): Single<Starship> {
        TODO("Not yet implemented")
    }

}