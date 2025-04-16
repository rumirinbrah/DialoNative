package com.zzz.dialonative.di

import com.zzz.dialonative.feature_contact.platform.call_service.CallNotificationManager
import com.zzz.dialonative.feature_contact.presentation.dial.DialViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val dialModule = module {
    viewModel {
        DialViewModel()
    }
}
val callModule = module{
    single {
        CallNotificationManager(androidContext())
    }
}


