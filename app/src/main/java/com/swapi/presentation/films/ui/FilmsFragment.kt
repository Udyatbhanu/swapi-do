package com.swapi.presentation.films.ui

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DefaultItemAnimator
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.swapi.R
import com.swapi.core.dagger.ViewModelFactory
import com.swapi.data.Images
import com.swapi.databinding.ResourcesFragmentBinding
import com.swapi.presentation.SharedViewModel
import com.swapi.presentation.films.viewmodel.FilmsViewModel
import com.swapi.presentation.people.ui.PeopleListAdapter
import com.swapi.presentation.people.viewmodel.PeopleViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search.toolbar
import kotlinx.android.synthetic.main.resources_fragment.*
import javax.inject.Inject

class FilmsFragment : DaggerFragment() {
    private lateinit var binding: ResourcesFragmentBinding


    private lateinit var filmsViewModel: FilmsViewModel


    private lateinit var filmsListAdapter: FilmsListAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.resources_fragment, container, false)

        return binding.root
    }


    /**
     *
     */
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

    private fun subscribeUi() {
        filmsViewModel.getFilms.observe(viewLifecycleOwner, Observer { filmsListItemViewModels ->
            filmsListAdapter = FilmsListAdapter()
            filmsListAdapter.onResults(filmsListItemViewModels)
            list.adapter = filmsListAdapter

        })


        /**
         * Search query text watcher
         */
        searchInputText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                filmsViewModel.onQueryChange(s.toString())
            }
        })


        /**
         * Handle the progress bar state
         */
        filmsViewModel.getLoadState.observe(viewLifecycleOwner, Observer {
            if(it){
                progressBarHolder.visibility = View.VISIBLE
            } else{
                progressBarHolder.visibility = View.GONE
            }
        } )


        /**
         * We want to show a snack bar on error state
         */
        val errorSnackBar = Snackbar.make(binding.root,resources.getString(R.string.service_error), Snackbar.LENGTH_LONG)
        val errorSnackBarView = errorSnackBar.view
        errorSnackBarView.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.md_error_color))
        val errorSnackBarTextView = errorSnackBarView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
        errorSnackBarTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_clear_black_24dp, 0, 0, 0)
        errorSnackBarTextView.compoundDrawablePadding = resources.getDimensionPixelOffset(R.dimen.space_16)


        filmsViewModel.getErrorState.observe(viewLifecycleOwner, Observer {
            if(it){
                errorSnackBar.show()
            }
        })


    }

    private fun initUi() {

        binding.collapsingToolbar.setExpandedTitleColor(Color.TRANSPARENT)


        //We could use databinding or ktx extensions
        list.itemAnimator = DefaultItemAnimator()


        Glide.with(binding.root.context)
            .asBitmap()
            .load(Images.PEOPLE_BANNER_IMAGE)
            .centerCrop()
            .into(binding.bannerImage)


    }


    private fun initViewModels() {

        activity?.let {
            filmsViewModel = ViewModelProvider(it, viewModelFactory).get(FilmsViewModel::class.java)
        }


    }


}