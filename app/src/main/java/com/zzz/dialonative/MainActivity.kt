package com.zzz.dialonative

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zzz.dialonative.core.presentation.Navigation
import com.zzz.dialonative.feature_contact.domain.model.RecentCall
import com.zzz.dialonative.feature_contact.domain.model.RecentCallType
import com.zzz.dialonative.feature_contact.domain.model.RecentContact
import com.zzz.dialonative.feature_contact.presentation.create_contact.CreateContactRoot
import com.zzz.dialonative.feature_contact.presentation.recents.components.DateStickyHeader
import com.zzz.dialonative.feature_contact.presentation.recents.components.RecentListItem
import com.zzz.dialonative.ui.theme.DialoNativeTheme
import com.zzz.dialonative.ui.theme.darkBackground
import com.zzz.dialonative.ui.theme.darkButton
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit

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
//
//                }

            }
        }
    }
}

@Composable
fun Greeting(name: String , modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!" ,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DialoNativeTheme {
        Greeting("Android")
    }
}