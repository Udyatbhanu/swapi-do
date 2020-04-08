package com.swapi.data.api.model.film


import com.fasterxml.jackson.annotation.JsonProperty

data class FilmsResponse(
    @JsonProperty("count")
    val count: Int = 0,
    @JsonProperty("next")
    val next: Any? = null,
    @JsonProperty("previous")
    val previous: Any? = null,
    @JsonProperty("results")
    val results: List<Result> = listOf()
)