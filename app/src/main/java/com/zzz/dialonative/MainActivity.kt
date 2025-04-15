package com.zzz.dialonative

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zzz.dialonative.core.presentation.Navigation
import com.zzz.dialonative.feature_contact.presentation.call.components.DotsLoadingAnimation
import com.zzz.dialonative.ui.theme.DialoNativeTheme
import com.zzz.dialonative.ui.theme.darkBackground

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DialoNativeTheme {
                //Navigation()
                Box(
                    Modifier.fillMaxSize()
                        .background(darkBackground)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ){
                    DotsLoadingAnimation()
                }

            }
        }
    }
}
