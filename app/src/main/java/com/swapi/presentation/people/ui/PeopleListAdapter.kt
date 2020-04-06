package com.swapi.presentation.people.ui;

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.swapi.R
import com.swapi.databinding.PeopleListItemBinding
import com.swapi.presentation.people.viewmodel.PeopleListItemViewModel


/**
 * https://www.zoftino.com/passing-data-between-android-fragments-using-viewmodel
 */
class PeopleListAdapter (private val people : ArrayList<PeopleListItemViewModel>) :
        RecyclerView.Adapter<PeopleListAdapter.ViewHolder>() {


    /**
     *
     */
    override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int
        ): PeopleListAdapter.ViewHolder {
            val binding: PeopleListItemBinding  = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.people_list_item,
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
            return people.size
        }


    /**
     *
     */
    override fun onBindViewHolder(holder: PeopleListAdapter.ViewHolder, position: Int) {
            val peopleListItemViewModel = people[position]
            holder.bind( peopleListItemViewModel)
        }

        class ViewHolder(private val binding : PeopleListItemBinding ) :
                RecyclerView.ViewHolder(binding.root) {

            fun bind(

                peopleListItemViewModel: PeopleListItemViewModel
            ) {

                with(binding) {

                    viewModel = peopleListItemViewModel

                    binding.mainLayout.setOnClickListener{
                        peopleListItemViewModel.name
                    }
                }

            }

        }
}
