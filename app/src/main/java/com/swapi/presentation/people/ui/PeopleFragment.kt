package com.swapi.presentation.people.ui

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DefaultItemAnimator
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.swapi.R
import com.swapi.core.dagger.ViewModelFactory
import com.swapi.data.Images
import com.swapi.databinding.PeopleFragmentBinding
import com.swapi.presentation.SharedViewModel
import com.swapi.presentation.people.viewmodel.PeopleViewModel
import dagger.android.support.DaggerFragment
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.people_fragment.*
import javax.inject.Inject


class PeopleFragment : DaggerFragment(){

    private lateinit var binding: PeopleFragmentBinding
    private lateinit var peopleViewModel: PeopleViewModel

    private lateinit var sharedViewModel: SharedViewModel

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

        (activity as? AppCompatActivity)?.setSupportActionBar(toolbar)

        toolbar.setNavigationIcon(R.drawable.ic_action_back)
        toolbar.setNavigationOnClickListener {
            Navigation.findNavController(binding.root).popBackStack()
        }

        initViewModels()
        initUi()
        subscribeUi()


    }


    /**
     *
     */
    private fun subscribeUi() {
        peopleViewModel.getPeople.observe(viewLifecycleOwner, Observer {peopleListItemViewModels ->
            peopleListAdapter = PeopleListAdapter()
            peopleListAdapter.onResults(peopleListItemViewModels)
            peopleList.adapter = peopleListAdapter

        })

        searchInputText.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                peopleViewModel.onQueryChange(s.toString())
            }
        } )

    }

    private fun initUi() {
        binding.peopleList

        binding.collapsingToolbar.setExpandedTitleColor(Color.TRANSPARENT)


        //We could use databinding or ktx extensions
        peopleList.itemAnimator = DefaultItemAnimator()


        Glide.with(binding.root.context)
            .asBitmap()
            .load(Images.PEOPLE_BANNER_IMAGE)
            .centerCrop()
            .into(binding.peopleBannerImage)



    }



    private fun initViewModels(){

        activity?.let {
            peopleViewModel = ViewModelProvider(it, viewModelFactory).get(PeopleViewModel::class.java)
            sharedViewModel = ViewModelProvider(it, viewModelFactory).get(SharedViewModel::class.java)
        }


    }


}