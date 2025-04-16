package com.zzz.dialonative.feature_contact.platform.call_service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.zzz.dialonative.core.presentation.util.LogTags

class NotificationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context? , intent: Intent?) {
        Log.d(LogTags.STOPWATCH , "onReceive: Notification action received")

        when(intent?.getStringExtra("action")){
            "a1"->{
                val stopIntent = Intent(context, CallService::class.java).apply {
                    action = CallServiceActions.STOP.name
                }
                context?.startService(stopIntent)
            }
        }
    }
}