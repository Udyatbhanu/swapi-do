package com.swapi.data.api.model.people


/**
 * This is custom object, we don't need to do this, we would ideally use a mapper from the service response to build this
 */
data class People(
    val name: String,
    val height: String,
    val mass: String,
    val films: List<String>?,
    val species: List<String>?,
    val vehicles: List<String>?,
    val starships: List<String>?,
    val url :String?
)