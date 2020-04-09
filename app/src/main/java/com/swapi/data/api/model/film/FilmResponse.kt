package com.swapi.data.api.model.film

import com.fasterxml.jackson.annotation.JsonProperty

data class FilmResponse( @JsonProperty("characters")
                           val characters: List<String>? = listOf(),
                           @JsonProperty("created")
                           val created: String? = "",
                           @JsonProperty("director")
                           val director: String? = "",
                           @JsonProperty("edited")
                           val edited: String? = "",
                           @JsonProperty("episode_id")
                           val episodeId: Int? = 0,
                           @JsonProperty("opening_crawl")
                           val openingCrawl: String? = "",
                           @JsonProperty("planets")
                           val planets: List<String>? = listOf(),
                           @JsonProperty("producer")
                           val producer: String? = "",
                           @JsonProperty("release_date")
                           val releaseDate: String? = "",
                           @JsonProperty("species")
                           val species: List<String>? = listOf(),
                           @JsonProperty("starships")
                           val starships: List<String>? = listOf(),
                           @JsonProperty("title")
                           val title: String? = "",
                           @JsonProperty("url")
                           val url: String? = "",
                           @JsonProperty("vehicles")
                           val vehicles: List<String>? = listOf())