package com.zzz.dialonative.feature_contact.presentation.call

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zzz.dialonative.R
import com.zzz.dialonative.core.presentation.components.CustomButton
import com.zzz.dialonative.core.presentation.components.VerticalSpace
import com.zzz.dialonative.feature_contact.presentation.call.components.BlurredBackgroundImage
import com.zzz.dialonative.feature_contact.presentation.call.components.CallingIndicator
import com.zzz.dialonative.ui.theme.buttonRed
import com.zzz.dialonative.ui.theme.darkOnBackground
import com.zzz.dialonative.ui.theme.darkOnCreate
import com.zzz.dialonative.ui.theme.darkSurface

@Composable
fun CallPageRoot(

) {
    CallPage()
}

@Composable
private fun CallPage(

) {

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .statusBarsPadding()
            .navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BlurredBackgroundImage(icon = R.drawable.pafecto)
        VerticalSpace()

        Text(
            "Parfect gril" ,
            color = darkOnBackground,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        CallingIndicator(modifier = Modifier.weight(1f))

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(56.dp)
        ){
            //MUTE
            CustomButton(
                icon = R.drawable.mute_icon,
                label = "niga",
                onClick = {},
                size = 40.dp,
                tint = darkSurface,
                backgroundColor = darkOnCreate
            )

            //END
            CustomButton(
                icon = R.drawable.phone_icon,
                label = "niga",
                onClick = {},
                size = 45.dp,
                tint = darkOnBackground,
                backgroundColor = buttonRed
            )

            //SPEAKER
            CustomButton(
                icon = R.drawable.speaker_icon,
                label = "niga",
                onClick = {},
                size = 40.dp,
                tint = darkSurface,
                backgroundColor = darkOnCreate
            )
        }

        VerticalSpace(40.dp)

    }

}