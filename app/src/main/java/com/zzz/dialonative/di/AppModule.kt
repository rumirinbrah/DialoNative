package com.zzz.dialonative.di

import com.zzz.dialonative.feature_contact.data.repo.LiveOngoingCallSource
import com.zzz.dialonative.feature_contact.domain.source.OngoingCallSource
import com.zzz.dialonative.feature_contact.domain.system.PhoneAccountHandler
import com.zzz.dialonative.feature_contact.platform.call_service.CallNotificationManager
import com.zzz.dialonative.feature_contact.platform.phone_account.TelecomPhoneAccountHandler
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
    //======NOTIFICATION MANAGER=======
    single {
        CallNotificationManager(androidContext())
    }

    //======ONGOING CALL=======
    single<OngoingCallSource> {
        LiveOngoingCallSource()
    }

    //========= PH ACC HANDLE =========
    single<PhoneAccountHandler> {
        TelecomPhoneAccountHandler(androidContext())
    }
}


