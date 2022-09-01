package com.vitalii.komaniak.hacaton_app.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.vitalii.komaniak.data.di.DataModule
import com.vitalii.komaniak.domain.di.DomainModule
import com.vitalii.komaniak.domain.usecase.LoadConfigUseCase
import com.vitalii.komaniak.hacaton_app.main.MainViewModel
import com.vitalii.komaniak.hacaton_app.screens.details.DetailsViewModel
import com.vitalii.komaniak.hacaton_app.screens.collection.CollectionViewModel

object AppModule {

    fun getMainViewModel(owner: ViewModelStoreOwner): MainViewModel {
        val factory = MainViewModelFactory(loadConfigUseCase = getLoadConfigUseCase())
        return ViewModelProvider(owner, factory)[MainViewModel::class.java]
    }

    fun getCollectionViewModelFactory(): ViewModelProvider.Factory {
        return CollectionViewModelFactory()
    }

    fun getDetailsViewModelFactory(): ViewModelProvider.Factory {
        return CollectionViewModelFactory()
    }

    private fun getLoadConfigUseCase(): LoadConfigUseCase {
        val configRepository = DataModule.getConfigRepository()
        return DomainModule.getLoadConfigUseCase(configRepository = configRepository)
    }

    private class MainViewModelFactory(private val loadConfigUseCase: LoadConfigUseCase) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(loadConfigUseCase = loadConfigUseCase) as T
        }
    }

    private class CollectionViewModelFactory() : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CollectionViewModel() as T
        }
    }

    private class DetailsViewModelFactory() : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return DetailsViewModel() as T
        }
    }
}