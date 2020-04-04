package com.swapi.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.swapi.R
import com.swapi.databinding.MainFragmentBinding
import dagger.android.support.DaggerFragment

import kotlinx.android.synthetic.main.main_fragment.*


class MainFragment : DaggerFragment() {

    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)



        return binding.root
    }


    /**
     *
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        testButton.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.peopleFragment)
        }
    }



}