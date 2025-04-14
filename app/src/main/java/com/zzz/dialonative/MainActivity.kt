package com.zzz.dialonative

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zzz.dialonative.core.presentation.Navigation
import com.zzz.dialonative.ui.theme.DialoNativeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DialoNativeTheme {
                Navigation()
//                Box(
//                    Modifier.fillMaxSize()
//                        .background(darkBackground)
//                        .padding(16.dp),
//                    contentAlignment = Alignment.Center
//                ){
//                    PhoneTextField()
//                }

            }
        }
    }
}
