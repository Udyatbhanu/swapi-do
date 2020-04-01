package com.swapi.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.swapi.R
import dagger.android.support.DaggerAppCompatActivity

class MainActivity :  DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
