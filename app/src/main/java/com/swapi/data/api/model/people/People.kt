package com.swapi.data.api.model.people

data class People(val name:String,  val height:String, val mass : String, val films : List<String>?,  val species : List<String>?,  val vehicles : List<String>?,  val starships : List<String>?)