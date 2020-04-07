package com.swapi.presentation.people.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.swapi.R
import com.swapi.databinding.PeopleDetailsFragmentBinding
import com.swapi.databinding.PeopleFragmentBinding
import dagger.android.support.DaggerFragment

class PeopleDetailsFragment : DaggerFragment(){
    private lateinit var binding: PeopleDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.people_details_fragment, container, false)


        val name = arguments?.getString("userName") ?: ""
        return binding.root
    }

}