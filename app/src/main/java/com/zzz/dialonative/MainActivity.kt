package com.zzz.dialonative

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.zzz.dialonative.core.presentation.Navigation
import com.zzz.dialonative.feature_call.CallActivity
import com.zzz.dialonative.feature_contact.domain.system.PhoneAccountHandler
import com.zzz.dialonative.feature_contact.platform.call_service.CallService
import com.zzz.dialonative.feature_contact.platform.call_service.CallServiceActions
import com.zzz.dialonative.feature_contact.presentation.call.CallPageRoot
import com.zzz.dialonative.feature_contact.presentation.call.components.BlurredBackgroundImage
import com.zzz.dialonative.feature_contact.presentation.call.components.DotsLoadingAnimation
import com.zzz.dialonative.feature_contact.presentation.dial.DialPageRoot
import com.zzz.dialonative.feature_contact.presentation.dial.components.SuggestedLazyList
import com.zzz.dialonative.feature_contact.presentation.dial.util.DialState
import com.zzz.dialonative.ui.theme.DialoNativeTheme
import com.zzz.dialonative.ui.theme.callingBackground
import com.zzz.dialonative.ui.theme.darkBackground
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //val accountHandler by inject<PhoneAccountHandler>()
            //accountHandler.registerPhoneAccount()

            requestPermission(this)
            DialoNativeTheme {
                //!!!!!!!!!!!!!!!  TRY THIS rememberRipple()
                //Navigation()
                Test()

            }
        }
    }
}

@Composable
fun Test(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Box(
        Modifier.fillMaxSize()
            .background(callingBackground),
        //.padding(16.dp),
        //contentAlignment = Alignment.Center
    ){
        Column (
            Modifier.statusBarsPadding()
        ){
            Button(
                onClick = {
                    val intent = Intent(context,CallActivity::class.java)
                    context.startActivity(intent)
                    //Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                }
            ) {
                Text("Start")
            }
        }
    }
}
private fun requestPermission(context: Context){
    if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.TIRAMISU) {
        val hasPerm = ContextCompat.checkSelfPermission(context , Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED
        if(!hasPerm){
            ActivityCompat.requestPermissions(
                context as ComponentActivity ,
                arrayOf(Manifest.permission.CALL_PHONE , Manifest.permission.POST_NOTIFICATIONS) ,
                101
            )
        }
    }else{
        return
    }
}


