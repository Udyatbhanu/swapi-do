package com.swapi.core

import com.swapi.core.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import jp.wasabeef.glide.transformations.BuildConfig
import timber.log.Timber

class SwapiApplication : DaggerApplication(){
    companion object {
        const val TAG = "SearchApp" //TODO
    }
    override fun onCreate() {
        super.onCreate()





    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        return DaggerAppComponent.builder().application(this).build()
    }
}