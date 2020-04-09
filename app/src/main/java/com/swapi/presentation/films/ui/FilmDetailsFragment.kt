package com.swapi.presentation.films.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.swapi.R
import com.swapi.core.dagger.ViewModelFactory
import com.swapi.data.Images
import com.swapi.databinding.FilmDetailsFragmentBinding
import com.swapi.databinding.PeopleDetailsFragmentBinding
import com.swapi.presentation.films.viewmodel.FilmDetailsViewModel
import com.swapi.presentation.people.viewmodel.PeopleDetailsViewModel
import dagger.android.support.DaggerFragment
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.film_details_fragment.view.*
import kotlinx.android.synthetic.main.fragment_search.*
import javax.inject.Inject

class FilmDetailsFragment : DaggerFragment() {

    private lateinit var binding: FilmDetailsFragmentBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var filmDetailsViewModel: FilmDetailsViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as? AppCompatActivity)?.setSupportActionBar(toolbar)

        toolbar.setNavigationIcon(R.drawable.ic_action_back)
        toolbar.setNavigationOnClickListener {
            Navigation.findNavController(binding.root).popBackStack()
        }




    }


    /**
     *
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.film_details_fragment, container, false)


        val url = arguments?.getString("url") ?: ""

        initUI()
        initViewModels(url);
        subscribeUi()
        return binding.root
    }


    /**
     *
     */
    private fun initUI() {
        Glide.with(binding.root.context)
            .asBitmap()
            .load(Images.BACKGROUND_THEME)
            .apply(RequestOptions.bitmapTransform(BlurTransformation(25, 5)))
            .centerCrop()
            .into(binding.background)

    }


    private fun initViewModels(args : String){

        activity?.let {
            filmDetailsViewModel = ViewModelProvider(it, viewModelFactory).get(
                FilmDetailsViewModel::class.java)
        }
        filmDetailsViewModel.setArgs(args);

    }

    private fun subscribeUi() {
        filmDetailsViewModel.getFilm.observe(viewLifecycleOwner, Observer {film ->

            //we could use the view model as well.
            binding.title.text = film.title
            binding.openingCrawl.text = film.openingCrawl
            binding.director.text = film.director
            binding.releaseDate.text = film.releaseDate
        })
    }



}