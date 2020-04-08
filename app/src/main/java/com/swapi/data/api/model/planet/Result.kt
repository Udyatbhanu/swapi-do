package com.swapi.data.api.model.planet


import com.fasterxml.jackson.annotation.JsonProperty

data class Result(
    @JsonProperty("climate")
    val climate: String = "",
    @JsonProperty("created")
    val created: String = "",
    @JsonProperty("diameter")
    val diameter: String = "",
    @JsonProperty("edited")
    val edited: String = "",
    @JsonProperty("films")
    val films: List<String> = listOf(),
    @JsonProperty("gravity")
    val gravity: String = "",
    @JsonProperty("name")
    val name: String = "",
    @JsonProperty("orbital_period")
    val orbitalPeriod: String = "",
    @JsonProperty("population")
    val population: String = "",
    @JsonProperty("residents")
    val residents: List<String> = listOf(),
    @JsonProperty("rotation_period")
    val rotationPeriod: String = "",
    @JsonProperty("surface_water")
    val surfaceWater: String = "",
    @JsonProperty("terrain")
    val terrain: String = "",
    @JsonProperty("url")
    val url: String = ""
)