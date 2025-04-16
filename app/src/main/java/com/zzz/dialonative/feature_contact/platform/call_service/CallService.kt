package com.zzz.dialonative.feature_contact.platform.call_service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.zzz.dialonative.core.presentation.util.LogTags
import com.zzz.dialonative.feature_contact.domain.stopwatch.StopwatchManager
import com.zzz.dialonative.feature_contact.platform.call_service.util.CallConstants
import org.koin.android.ext.android.inject



class CallService : Service() {

    private val notificationHelper by inject<CallNotificationManager>()
    private val stopwatchManager = StopwatchManager()


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent? , flags: Int , startId: Int): Int {

        when(intent?.action){
            CallServiceActions.START.name->{
                Log.d(LogTags.STOPWATCH , "onStartCmd: Start service")

                startService()
            }
            CallServiceActions.STOP.name->{
                Log.d(LogTags.STOPWATCH , "onStartCmd: Stop MF")

                stopServiceAndReleaseResources()
            }
        }
        return START_STICKY
    //super.onStartCommand(intent , flags , startId)

    }

    override fun onDestroy() {
        super.onDestroy()
        stopServiceAndReleaseResources()
        Log.d(LogTags.STOPWATCH , "onDestroy: DESTROY service")
    }


    private fun startService(){
        val notification = notificationHelper.createNotification("Atharva")
        stopwatchManager.startStopwatch { seconds, minutes ->
            notificationHelper.updateNotification(minutes,seconds)
        }
        startForeground(CallConstants.NOTIFICATION_ID,notification)
    }

    private fun stopServiceAndReleaseResources(){
        notificationHelper.cancelNotification()
        stopwatchManager.stopStopwatch()
        stopSelf()
    }

}


