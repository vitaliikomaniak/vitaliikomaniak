package com.vitalii.komaniak.hacaton_app.di

import androidx.lifecycle.ViewModelStoreOwner
import com.vitalii.komaniak.hacaton_app.main.MainViewModel

class Injection {

    fun getMainViewModel(owner: ViewModelStoreOwner): MainViewModel {
        return AppModule.getMainViewModel(owner = owner)
    }
}