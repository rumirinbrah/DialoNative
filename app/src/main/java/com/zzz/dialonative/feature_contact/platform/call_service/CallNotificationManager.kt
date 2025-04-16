package com.zzz.dialonative.feature_contact.platform.call_service

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_IMMUTABLE
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.content.getSystemService
import com.zzz.dialonative.R
import com.zzz.dialonative.core.presentation.util.LogTags
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.Locale

class CallNotificationManager(
    private val context: Context
) {

    private val scope = CoroutineScope(Dispatchers.Default + Job())

    private val notificationManager = context.getSystemService<NotificationManager>()
    //create a state for holding the contact name and the bitmap

    private lateinit var notificationBuilder: NotificationCompat.Builder


    fun createNotification(name: String): Notification {
        Log.d(LogTags.STOPWATCH , "createNotification: Notification created")

        return initializeBuilder(name)
    }

    /*
    fun updateNotification(elapsedTime: Long) {
        println("UPDATE CALLED")
        val notification = NotificationCompat.Builder(context , "my_channel")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentText("Call in progress - ${formatMillisToHHMM(elapsedTime)}")
            .addAction(R.drawable.phone_icon , "Button" , null)
            .setSilent(true)
            .build()
        notificationManager?.notify(101 , notification)
    }

     */

    fun cancelNotification() {
        Log.d(LogTags.STOPWATCH , "cancelNotification: Notification cancelled")

        notificationManager?.cancel(101)
    }

    fun updateNotification(minutes: String , seconds: String) {
        scope.launch {
            notificationBuilder.setContentText("Call in progress - $minutes:$seconds")

            notificationManager?.notify(101 , notificationBuilder.build())
        }
    }

    private fun callEndIntentProvider(): PendingIntent {
        val intent = Intent(context , NotificationReceiver::class.java).apply {
            putExtra("action" , "a1")
        }
        return PendingIntent.getBroadcast(
            context ,
            102 ,
            intent ,
            FLAG_IMMUTABLE
        )

    }

    private fun initializeBuilder(title: String): Notification {
        Log.d(LogTags.STOPWATCH , "initializeBuilder: Notification builder")

        val buttonPI = callEndIntentProvider()
        notificationBuilder = NotificationCompat.Builder(context , "my_channel")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setOngoing(true)
            .setContentText("Call in progress - 00:00")
            .setContentTitle(title)
            .addAction(R.drawable.phone_icon , "End call" , buttonPI)
            .setSilent(true)

        return notificationBuilder.build()
    }

    private fun formatMillisToHHMM(timeMillis: Long): String {
        val totalSeconds = java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds(timeMillis)
        val minutes = totalSeconds / 60
        val seconds = totalSeconds % 60
        return String.format(Locale.getDefault() , "%02d:%02d" , minutes , seconds)
    }

}