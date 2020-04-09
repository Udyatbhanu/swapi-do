package com.swapi.presentation.films.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.swapi.R
import com.swapi.databinding.FilmsListItemBinding
import com.swapi.presentation.films.viewmodel.FilmsListItemViewModel
import com.swapi.presentation.people.ui.PeopleFragmentDirections


class FilmsListAdapter : RecyclerView.Adapter<FilmsListAdapter.ViewHolder>() {

    private var films: List<FilmsListItemViewModel> = emptyList()

    /**
     *
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding: FilmsListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.films_list_item,
            parent, false
        )
        return ViewHolder(
            binding
        )
    }


    /**
     *
     */
    override fun getItemCount(): Int {
        return films.size
    }


    /**
     *
     */
    public fun onResults(people: List<FilmsListItemViewModel>) {
        this.films = people
        notifyDataSetChanged()
    }


    /**
     *
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val filmsListItemViewModel = films[position]
        holder.bind(filmsListItemViewModel)
    }

    class ViewHolder(private val binding: FilmsListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(

            filmsListItemViewModel: FilmsListItemViewModel

        ) {

            with(binding) {

                viewModel = filmsListItemViewModel
                val direction =
                    FilmsFragmentDirections.actionFilmsFragmentToFilmDetailsFragment()
                binding.mainLayout.setOnClickListener {


                    var bundle = bundleOf("url" to filmsListItemViewModel.url)
                    it.findNavController()
                        .navigate(R.id.action_filmsFragment_to_filmDetailsFragment, bundle)
                }
            }

        }

    }
}
