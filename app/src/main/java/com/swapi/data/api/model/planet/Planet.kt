package com.swapi.data.api.model.planet



data class Planet(

    val climate: String? = "",
    val diameter: String? = "",
    val name: String? = "",
    val orbitalPeriod: String? = "",
    val population: String? = "",
    val residents: List<String>? = listOf(),

    val url: String? = ""
)