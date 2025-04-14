package com.zzz.dialonative.feature_contact.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.zzz.dialonative.R
import com.zzz.dialonative.ui.theme.darkButton
import com.zzz.dialonative.ui.theme.darkOnBackground

@Composable
fun DialFab(
    onClick : ()->Unit,
    modifier: Modifier = Modifier,
    size : Dp = 40.dp,
    containerColor : Color = darkButton,
    iconColor : Color = darkOnBackground
) {
    Box(
        modifier.size(size)
            .clip(Shapes().medium)
            .background(containerColor)
            .clickable {
                onClick()
            }
            //.padding(8.dp)
        ,
        contentAlignment = Alignment.Center
    ){
        Icon(
            painter = painterResource(R.drawable.dial_icon) ,
            contentDescription = "Open dial",
            tint = iconColor
        )
    }
}