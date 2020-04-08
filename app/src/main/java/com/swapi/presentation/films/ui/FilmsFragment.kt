package com.swapi.presentation.films.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.swapi.R
import com.swapi.databinding.ResourcesFragmentBinding
import dagger.android.support.DaggerFragment

class FilmsFragment : DaggerFragment() {
    private lateinit var binding: ResourcesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.resources_fragment, container, false)



        return binding.root
    }



}