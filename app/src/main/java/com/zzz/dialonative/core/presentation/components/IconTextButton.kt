package com.zzz.dialonative.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zzz.dialonative.ui.theme.darkOnBackground
import com.zzz.dialonative.ui.theme.darkOnCreate

@Composable
fun IconTextButton(
    icon : Int,
    text : String,
    onClick :()->Unit,
    iconSize : Dp = 30.dp,
    fontSize : TextUnit = 18.sp,
    backgroundColor : Color = darkOnCreate,
    contentColor : Color= darkOnBackground,
    modifier: Modifier = Modifier
) {
    Row (
        modifier
            .clip(RoundedCornerShape(35))
            .clickable {
                onClick()
            }
            .background(backgroundColor.copy(alpha = 0.4f))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Icon(
            modifier = Modifier.size(iconSize),
            painter = painterResource(icon) ,
            contentDescription = text,
            tint = contentColor
        )
        Text(
            text ,
            color = contentColor,
            fontSize = fontSize
        )
    }
}