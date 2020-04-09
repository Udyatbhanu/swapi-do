package com.swapi.presentation.misc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.swapi.R
import com.swapi.data.Images
import com.swapi.databinding.ComingSoonFragmentBinding
import dagger.android.support.DaggerFragment
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.coming_soon_fragment.toolbar

class ComingSoonFragment : DaggerFragment() {

    private lateinit var binding: ComingSoonFragmentBinding


    /**
     * Set the toolbar after activity is created
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //Toolbar
        (activity as? AppCompatActivity)?.setSupportActionBar(toolbar)

        toolbar.setNavigationIcon(R.drawable.ic_action_back)
        toolbar.setNavigationOnClickListener {
            Navigation.findNavController(binding.root).popBackStack()
        }


    }


    /**
     * Inflate the view
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.coming_soon_fragment, container, false)

        initUI()

        return binding.root
    }


    /**
     * Image setup
     */
    private fun initUI() {


        //Image
        Glide.with(binding.root.context)
            .asBitmap()
            .load(Images.COMING_SOON)
            .apply(RequestOptions.bitmapTransform(BlurTransformation(25, 5)))
            .centerCrop()
            .into(binding.background)

    }

}