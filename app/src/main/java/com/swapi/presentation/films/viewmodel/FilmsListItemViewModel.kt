package com.swapi.presentation.films.viewmodel

import androidx.lifecycle.ViewModel
import com.swapi.data.api.model.film.Film

class FilmsListItemViewModel (film : Film) : ViewModel(){

    val episodeId = film.episodeId
    val title = film.title
    val openingCrawl = film.openingCrawl
    val releaseDate = film.releaseDate
    val director =  film.director
    val url = film.url

}