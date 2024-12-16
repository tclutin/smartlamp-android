package com.example.smartlamp.di

import com.example.smartlamp.di.module.AppModule
import com.example.smartlamp.presenter.fragment.MainFragment
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        AppModule::class
    ]
)
@Singleton
interface AppComponent {
    fun inject(fragment: MainFragment)
}