package com.swapi.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.swapi.R
import com.swapi.data.Images
import com.swapi.databinding.MainFragmentBinding
import dagger.android.support.DaggerFragment

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

        val requestOptions = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.NONE) // because file name is always same
            .skipMemoryCache(true)


        Glide.with(binding.root.context)
            .asBitmap()
            .load(Images.HOME_IMAGE)
            .centerCrop()
            .into(binding.homeBannerImage)


        Glide.with(binding.root.context)
            .asBitmap()
            .load(Images.PEOPLE_IMAGE)
            .centerCrop()
            .into(binding.people)
    }
    /**
     *
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        testButton.setOnClickListener{
//            Navigation.findNavController(binding.root).navigate(R.id.peopleFragment)
//        }
    }


}