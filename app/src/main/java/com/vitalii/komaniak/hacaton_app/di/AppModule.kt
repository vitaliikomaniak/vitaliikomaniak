package com.vitalii.komaniak.hacaton_app.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.vitalii.komaniak.data.di.DataModule
import com.vitalii.komaniak.domain.di.DomainModule
import com.vitalii.komaniak.domain.usecase.LoadConfigUseCase
import com.vitalii.komaniak.domain.usecase.LoadContentUseCase
import com.vitalii.komaniak.hacaton_app.main.MainViewModel
import com.vitalii.komaniak.hacaton_app.screens.settings.SettingsViewModel
import com.vitalii.komaniak.hacaton_app.screens.collection.CollectionViewModel
import com.vitalii.komaniak.hacaton_app.screens.live.LiveViewModel
import com.vitalii.komaniak.hacaton_app.screens.navigation.NavigationViewModel

object AppModule {

    fun getMainViewModel(owner: ViewModelStoreOwner): MainViewModel {
        val factory = MainViewModelFactory(loadConfigUseCase = getLoadConfigUseCase())
        return ViewModelProvider(owner, factory)[MainViewModel::class.java]
    }

    fun getCollectionViewModelFactory(context: Context): ViewModelProvider.Factory {
        return CollectionViewModelFactory(loadContentUseCase = getLoadContentUseCase(context))
    }

    fun getSettingsViewModelFactory(context: Context): ViewModelProvider.Factory {
        return SettingsViewModelFactory(loadContentUseCase = getLoadContentUseCase(context))
    }

    fun getNavigationViewModelFactory(context: Context): ViewModelProvider.Factory {
        return NavigationViewModelFactory(loadContentUseCase = getLoadContentUseCase(context))
    }

    fun getLiveViewModelFactory(context: Context): ViewModelProvider.Factory {
        return LiveViewModelFactory(loadContentUseCase = getLoadContentUseCase(context))
    }

    private fun getLoadContentUseCase(context: Context): LoadContentUseCase {
        val contentRepository = DataModule.getContentRepository(context)
        return DomainModule.getLoadContentUseCase(contentRepository = contentRepository)
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

    private class CollectionViewModelFactory(private val loadContentUseCase: LoadContentUseCase) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CollectionViewModel(loadContentUseCase = loadContentUseCase) as T
        }
    }

    private class SettingsViewModelFactory(private val loadContentUseCase: LoadContentUseCase) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return SettingsViewModel(loadContentUseCase = loadContentUseCase) as T
        }
    }

    private class NavigationViewModelFactory(private val loadContentUseCase: LoadContentUseCase) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return NavigationViewModel(loadContentUseCase = loadContentUseCase) as T
        }
    }

    private class LiveViewModelFactory(private val loadContentUseCase: LoadContentUseCase) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return LiveViewModel(loadContentUseCase = loadContentUseCase) as T
        }
    }
}