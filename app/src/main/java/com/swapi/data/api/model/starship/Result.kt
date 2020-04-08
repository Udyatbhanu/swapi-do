package com.swapi.data.api.model.starship


import com.fasterxml.jackson.annotation.JsonProperty

data class Result(
    @JsonProperty("cargo_capacity")
    val cargoCapacity: String = "",
    @JsonProperty("consumables")
    val consumables: String = "",
    @JsonProperty("cost_in_credits")
    val costInCredits: String = "",
    @JsonProperty("created")
    val created: String = "",
    @JsonProperty("crew")
    val crew: String = "",
    @JsonProperty("edited")
    val edited: String = "",
    @JsonProperty("films")
    val films: List<String> = listOf(),
    @JsonProperty("hyperdrive_rating")
    val hyperdriveRating: String = "",
    @JsonProperty("length")
    val length: String = "",
    @JsonProperty("MGLT")
    val mGLT: String = "",
    @JsonProperty("manufacturer")
    val manufacturer: String = "",
    @JsonProperty("max_atmosphering_speed")
    val maxAtmospheringSpeed: String = "",
    @JsonProperty("model")
    val model: String = "",
    @JsonProperty("name")
    val name: String = "",
    @JsonProperty("passengers")
    val passengers: String = "",
    @JsonProperty("pilots")
    val pilots: List<String> = listOf(),
    @JsonProperty("starship_class")
    val starshipClass: String = "",
    @JsonProperty("url")
    val url: String = ""
)