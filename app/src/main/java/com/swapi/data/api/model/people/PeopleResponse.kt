package com.swapi.data.api.model.people


import com.fasterxml.jackson.annotation.JsonProperty

data class PeopleResponse(
    @JsonProperty("count")
    val count: Int = 0,
    @JsonProperty("next")
    val next: String = "",
    @JsonProperty("previous")
    val previous: Any? = null,
    @JsonProperty("results")
    val results: List<Result> = listOf()
)