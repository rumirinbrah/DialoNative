package com.zzz.dialonative.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(
    icon : Int,
    label : String,
    onClick : ()->Unit,
    size : Dp = 30.dp,
    tint : Color = Color.White,
    backgroundColor : Color = Color.DarkGray,
) {
    Box(
        Modifier.clip(CircleShape)
            .background(backgroundColor)
            .clickable{
                onClick()
            }
            .padding(8.dp)
    ){
        Icon(
            modifier = Modifier.size(size),
            tint = tint,
            painter = painterResource(icon),
            contentDescription = label
        )
    }
}