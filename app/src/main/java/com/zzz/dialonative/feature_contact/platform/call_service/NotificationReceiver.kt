package com.zzz.dialonative.feature_contact.platform.call_service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.zzz.dialonative.core.presentation.util.LogTags
import com.zzz.dialonative.feature_contact.platform.call_service.util.CallConstants

class NotificationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context? , intent: Intent?) {
        Log.d(LogTags.STOPWATCH , "onReceive: Notification action received")

        val receivedAction = intent?.getStringExtra(CallConstants.CALL_END_ACTION)
        Log.d(LogTags.STOPWATCH , "onReceive: Notification action is $receivedAction")
        when(receivedAction){
            NotificationActions.END_CALL.name->{
                Log.d(LogTags.STOPWATCH , "onReceive: CALL END ACTION")

                val stopIntent = Intent(context, CallService::class.java).apply {
                    action = CallServiceActions.STOP.name
                }
                context?.startService(stopIntent)
            }
        }
    }
}