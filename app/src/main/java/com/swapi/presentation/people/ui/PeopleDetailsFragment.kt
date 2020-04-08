package com.swapi.presentation.people.ui

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
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.swapi.R
import com.swapi.core.dagger.ViewModelFactory
import com.swapi.data.Images
import com.swapi.databinding.PeopleDetailsFragmentBinding
import com.swapi.databinding.PeopleFragmentBinding
import com.swapi.presentation.SharedViewModel
import com.swapi.presentation.people.viewmodel.PeopleDetailsViewModel
import com.swapi.presentation.people.viewmodel.PeopleViewModel
import dagger.android.support.DaggerFragment
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.people_details_fragment.view.*
import kotlinx.android.synthetic.main.people_fragment.*
import javax.inject.Inject

class PeopleDetailsFragment : DaggerFragment(){
    private lateinit var binding: PeopleDetailsFragmentBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var peopleDetailsViewModel: PeopleDetailsViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? AppCompatActivity)?.supportActionBar?.show()

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
        binding = DataBindingUtil.inflate(inflater, R.layout.people_details_fragment, container, false)


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
            .apply(bitmapTransform(BlurTransformation(25, 5)))
            .centerCrop()
            .into(binding.background)

    }


    private fun initViewModels(args : String){

        activity?.let {
            peopleDetailsViewModel = ViewModelProvider(it, viewModelFactory).get(PeopleDetailsViewModel::class.java)
        }
        peopleDetailsViewModel.setArgs(args);

    }

    private fun subscribeUi() {
        peopleDetailsViewModel.getPerson.observe(viewLifecycleOwner, Observer {personViewModel ->
          binding.name.text = personViewModel.name
          binding.height.text = personViewModel.height
          binding.mass.text = personViewModel.mass
        })
    }


}