package com.zzz.dialonative.feature_contact.domain.stopwatch

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.zzz.dialonative.core.presentation.util.LogTags
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Timer
import kotlin.concurrent.fixedRateTimer
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

class StopwatchManager {
    private var duration = Duration.ZERO
    private lateinit var timer: Timer

    //can be exposed to ui
    private val _time = MutableStateFlow(TimeItem())
    val time = _time.asStateFlow()

    //runnin or not
    private val _stopwatchState = mutableStateOf(StopwatchState.IDLE)
    val stopwatchState: State<StopwatchState> = _stopwatchState

    //u can trigger this once call initiated
    fun startStopwatch(onTick: (seconds: String , minutes: String) -> Unit) {
        Log.d(LogTags.STOPWATCH , "startStopwatch: Starting stopwatch")

        timer = fixedRateTimer(initialDelay = 10L, period = 10L){
            duration = duration.plus(10.milliseconds)
            updateTimeUnits()
            _stopwatchState.value = StopwatchState.RUNNING

            onTick(_time.value.seconds,_time.value.minutes)

        }
    }

    //stop
    fun stopStopwatch(){
        Log.d(LogTags.STOPWATCH , "stopStopwatch: Stopping stopwatch")
        if(this::timer.isInitialized){
            timer.cancel()
        }
        _stopwatchState.value = StopwatchState.IDLE
    }

    //UPDATE TIMER
    private fun updateTimeUnits(){
        duration.toComponents { _, minutes, seconds, _ ->
            _time.update {
                it.copy(seconds = seconds.pad(),minutes = minutes.pad())
            }
        }

    }

    //FORMAT TIME
    private fun Int.pad() : String{
        return if(this<10) "0$this" else this.toString()
    }
}