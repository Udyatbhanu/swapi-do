package com.swapi.presentation.people.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.swapi.R
import com.swapi.core.dagger.ViewModelFactory
import com.swapi.databinding.PeopleFragmentBinding
import com.swapi.presentation.people.viewmodel.PeopleViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PeopleFragment : DaggerFragment(){

    private lateinit var binding: PeopleFragmentBinding
    private lateinit var peopleViewModel: PeopleViewModel

    private lateinit var peopleListAdapter: PeopleListAdapter



    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.people_fragment, container, false)



        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? AppCompatActivity)?.supportActionBar?.show()
        initViewModels()
        initUi()
        subscribeUi()


    }


    /**
     *
     */
    private fun subscribeUi() {
        peopleViewModel.getPeople.observe(viewLifecycleOwner, Observer {peopleListItemViewModels ->
            peopleListAdapter = PeopleListAdapter(peopleListItemViewModels)
            binding.peopleList.adapter = peopleListAdapter

        })

    }

    private fun initUi() {
        binding.peopleList
    }

    private fun initViewModels(){

        activity?.let {
            peopleViewModel = ViewModelProvider(it, viewModelFactory).get(PeopleViewModel::class.java)
        }


    }


}