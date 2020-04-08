package com.swapi.presentation.people.viewmodel

import androidx.lifecycle.ViewModel
import com.swapi.data.api.model.people.People

class PeopleListItemViewModel(people : People) : ViewModel(){
    val name = people.name
    val height = people.height
    val mass = people.mass
    val url = people.url

    val filmCount = people.films?.size.toString()
}