//package com.swapi.presentation.planets.ui
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.core.os.bundleOf
//import androidx.databinding.DataBindingUtil
//import androidx.navigation.findNavController
//import androidx.recyclerview.widget.RecyclerView
//import com.swapi.R
//import com.swapi.databinding.PeopleListItemBinding
//import com.swapi.databinding.PlanetsListItemBinding
//import com.swapi.presentation.people.ui.PeopleFragmentDirections
//import com.swapi.presentation.people.ui.PeopleListAdapter
//import com.swapi.presentation.people.viewmodel.PeopleListItemViewModel
//
//class PlanetsListAdapter :
//RecyclerView.Adapter<PlanetsListAdapter.ViewHolder>() {
//
//    private var planets: List<PeopleListItemViewModel> = emptyList()
//
//    /**
//     *
//     */
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): PlanetsListAdapter.ViewHolder {
//        val binding: PlanetsListItemBinding = DataBindingUtil.inflate(
//            LayoutInflater.from(parent.context), R.layout.people_list_item,
//            parent, false
//        )
//        return ViewHolder(
//            binding
//        )
//    }
//
//
//    /**
//     *
//     */
//    override fun getItemCount(): Int {
//        return people.size
//    }
//
//
//    /**
//     *
//     */
//    public fun onResults(people: List<PeopleListItemViewModel>) {
//        this.people = people
//        notifyDataSetChanged()
//    }
//
//
//    /**
//     *
//     */
//    override fun onBindViewHolder(holder: PeopleListAdapter.ViewHolder, position: Int) {
//        val peopleListItemViewModel = people[position]
//        holder.bind(peopleListItemViewModel)
//    }
//
//    class ViewHolder(private val binding: PeopleListItemBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(
//
//            peopleListItemViewModel: PeopleListItemViewModel
//
//        ) {
//
//            with(binding) {
//
//                viewModel = peopleListItemViewModel
//                val direction =
//                    PeopleFragmentDirections.actionPeopleFragmentToPeopleDetailsFragment()
//                binding.mainLayout.setOnClickListener {
//
//
//                    var bundle = bundleOf("url" to peopleListItemViewModel.url)
//                    it.findNavController()
//                        .navigate(R.id.action_peopleFragment_to_peopleDetailsFragment, bundle)
//                }
//            }
//
//        }
//
//    }
//}