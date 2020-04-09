package com.swapi.presentation.planets.viewmodel

import androidx.lifecycle.ViewModel
import com.swapi.data.api.model.planet.Planet

class PlanetListItemViewModel (planet : Planet) : ViewModel() {
    val name = planet.name
    val height = planet.population
    val residents = planet.residents?.size
    val url = planet.url
}
