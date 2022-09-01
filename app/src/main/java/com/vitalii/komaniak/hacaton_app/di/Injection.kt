package com.vitalii.komaniak.hacaton_app.di

import androidx.lifecycle.ViewModelStoreOwner
import com.vitalii.komaniak.hacaton_app.main.MainViewModel
import com.vitalii.komaniak.hacaton_app.screens.home.CollectionViewModel

class Injection {

    fun getMainViewModel(owner: ViewModelStoreOwner): MainViewModel {
        return AppModule.getMainViewModel(owner = owner)
    }
}