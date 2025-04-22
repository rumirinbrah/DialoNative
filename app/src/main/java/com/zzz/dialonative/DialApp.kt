package com.zzz.dialonative

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.core.content.getSystemService
import com.zzz.dialonative.di.callModule
import com.zzz.dialonative.di.databaseModule
import com.zzz.dialonative.di.dialModule
import com.zzz.dialonative.feature_contact.platform.call_service.util.CallConstants
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DialApp : Application() {
    override fun onCreate() {
        super.onCreate()
        val channel = NotificationChannel(
            CallConstants.CHANNEL_ID , CallConstants.CHANNEL_NAME ,
            NotificationManager.IMPORTANCE_LOW
        ).apply {
            enableVibration(false)
            setSound(null , null)
        }
        val manager = getSystemService<NotificationManager>() as NotificationManager
        manager.createNotificationChannel(channel)

        startKoin {
            androidContext(this@DialApp)
            modules(dialModule , callModule , databaseModule)
        }
    }
}