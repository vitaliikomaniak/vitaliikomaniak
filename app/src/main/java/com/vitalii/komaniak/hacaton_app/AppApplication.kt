package com.vitalii.komaniak.hacaton_app

import android.app.Application
import com.vitalii.komaniak.hacaton_app.di.Injection

class AppApplication: Application() {

    private lateinit var injection: Injection

    override fun onCreate() {
        super.onCreate()
        injection = Injection()
//        startKoin {
//            androidLogger()
//            androidContext(this@AppApplication)
//            modules(appModule)
//        }
    }

    fun getInjection(): Injection {
        return injection
    }
}