package com.zzz.dialonative

import android.app.Application
import com.zzz.dialonative.di.dialModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DialApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@DialApp)
            modules(dialModule)
        }
    }
}