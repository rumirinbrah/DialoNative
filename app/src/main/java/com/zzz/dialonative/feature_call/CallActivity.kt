package com.zzz.dialonative.feature_call

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.Modifier
import com.zzz.dialonative.feature_call.ui.theme.DialoNativeTheme
import com.zzz.dialonative.feature_contact.presentation.call.CallPageRoot
import com.zzz.dialonative.ui.theme.callingBackground

class CallActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
        SEE IF WE NEED THIS??
        window.addFlags(
            WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON or
                    WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
                    WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
        )
         */
        enableEdgeToEdge()
        setContent {
            DialoNativeTheme {
                Box(
                    Modifier.fillMaxSize()
                        .background(callingBackground)
                        .statusBarsPadding()
                        .navigationBarsPadding()
                ){
                    CallPageRoot()
                }
            }
        }
    }
}
