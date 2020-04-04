package com.swapi.data.api.model.people


import com.fasterxml.jackson.annotation.JsonProperty

data class Result(
    @JsonProperty("birth_year")
    val birthYear: String = "",
    @JsonProperty("created")
    val created: String = "",
    @JsonProperty("edited")
    val edited: String = "",
    @JsonProperty("eye_color")
    val eyeColor: String = "",
    @JsonProperty("films")
    val films: List<String> = listOf(),
    @JsonProperty("gender")
    val gender: String = "",
    @JsonProperty("hair_color")
    val hairColor: String = "",
    @JsonProperty("height")
    val height: String = "",
    @JsonProperty("homeworld")
    val homeworld: String = "",
    @JsonProperty("mass")
    val mass: String = "",
    @JsonProperty("name")
    val name: String = "",
    @JsonProperty("skin_color")
    val skinColor: String = "",
    @JsonProperty("species")
    val species: List<String> = listOf(),
    @JsonProperty("starships")
    val starships: List<String> = listOf(),
    @JsonProperty("url")
    val url: String = "",
    @JsonProperty("vehicles")
    val vehicles: List<String> = listOf()
)