package com.zzz.dialonative.feature_contact.presentation.dial.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zzz.dialonative.ui.theme.darkOnBackground
import com.zzz.dialonative.ui.theme.darkOnCreate

@Composable
fun DigitButton(
    digit: Int ,
    isSymbol: Boolean = false ,
    symbol : String? = null,
    onClick : (String)->Unit,
    fontSize : TextUnit = 30.sp,
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .clip(Shapes().large)
            .clickable{
                onClick(
                    if(isSymbol) symbol!! else digit.toString()
                )
            }
            .background(darkOnCreate)
            .height(50.dp)
            .padding(vertical = 4.dp, horizontal = 8.dp),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = if(isSymbol) symbol!! else "$digit",
            fontWeight = FontWeight.Bold,
            color = darkOnBackground,
            fontSize = fontSize
        )
    }
}