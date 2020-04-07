package com.swapi.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.bumptech.glide.Glide

import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.swapi.R
import com.swapi.data.Images
import com.swapi.databinding.MainFragmentBinding
import dagger.android.support.DaggerFragment
import jp.wasabeef.glide.transformations.BlurTransformation

import kotlinx.android.synthetic.main.main_fragment.*


class MainFragment : DaggerFragment() {

    private lateinit var binding: MainFragmentBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)

        initUI()

        return binding.root
    }

    private fun initUI() {


        //Background
        Glide.with(binding.root.context)
            .asBitmap()
            .load(Images.BACKGROUND)
            .apply(bitmapTransform(BlurTransformation(25, 5)))
            .centerCrop()
            .into(binding.background)


        //People
        Glide.with(binding.root.context)
            .asBitmap()
            .load(Images.PEOPLE_IMAGE)
            .centerCrop()
            .into(binding.people)


        //Films
        Glide.with(binding.root.context)
            .asBitmap()
            .load(Images.FILMS)
            .centerCrop()
            .into(binding.films)

        //Planets
        Glide.with(binding.root.context)
            .asBitmap()
            .load(Images.PLANETS)
            .centerCrop()
            .into(binding.planets)


        //Starships
        Glide.with(binding.root.context)
            .asBitmap()
            .load(Images.STARSHIPS)
            .centerCrop()
            .into(binding.starships)


    }
    /**
     *
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        peopleLayout.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.peopleFragment)
        }
    }


}