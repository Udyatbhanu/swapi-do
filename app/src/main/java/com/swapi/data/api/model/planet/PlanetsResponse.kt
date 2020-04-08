package com.swapi.data.api.model.planet


import com.fasterxml.jackson.annotation.JsonProperty

data class PlanetsResponse(
    @JsonProperty("count")
    val count: Int = 0,
    @JsonProperty("next")
    val next: String = "",
    @JsonProperty("previous")
    val previous: Any? = null,
    @JsonProperty("results")
    val results: List<Result> = listOf()
)