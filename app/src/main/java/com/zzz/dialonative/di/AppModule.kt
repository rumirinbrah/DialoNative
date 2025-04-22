package com.zzz.dialonative.di

import androidx.room.Room
import com.zzz.dialonative.feature_contact.data.local.contact_db.DialoDatabase
import com.zzz.dialonative.feature_contact.data.local.repository.RoomContactsSource
import com.zzz.dialonative.feature_contact.data.local.repository.RoomRecentContactsSrc
import com.zzz.dialonative.feature_contact.data.local.util.DBConstants
import com.zzz.dialonative.feature_contact.data.repo.LiveOngoingCallSource
import com.zzz.dialonative.feature_contact.domain.source.ContactsSource
import com.zzz.dialonative.feature_contact.domain.source.OngoingCallSource
import com.zzz.dialonative.feature_contact.domain.source.RecentContactsSource
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

//DB
val databaseModule = module {
    //========= DB =========
    single<DialoDatabase> {
        Room.databaseBuilder(
            androidContext(),
            DialoDatabase :: class.java,
            DBConstants.DB_NAME
        ).build()
    }

    //========= CONTACTS SRC =========
    single<ContactsSource> {
        val db = get<DialoDatabase>()
        RoomContactsSource(db.contactsDao)
    }

    //========= CONTACTS SRC =========
    single<RecentContactsSource> {
        val db = get<DialoDatabase>()
        RoomRecentContactsSrc(db.recentContactsDao)
    }

}


