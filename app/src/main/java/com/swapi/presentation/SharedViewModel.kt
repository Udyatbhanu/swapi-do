package com.swapi.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.swapi.presentation.people.viewmodel.PeopleListItemViewModel
import javax.inject.Inject

class SharedViewModel @Inject constructor(): ViewModel(){
    val selectedPersonItem = MutableLiveData<PeopleListItemViewModel>()

    fun selectPerson(item: PeopleListItemViewModel) {
        selectedPersonItem.value = item
    }
}