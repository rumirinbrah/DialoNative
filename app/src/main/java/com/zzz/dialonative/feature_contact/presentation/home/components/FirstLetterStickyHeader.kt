package com.zzz.dialonative.feature_contact.presentation.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zzz.dialonative.ui.theme.darkOnBackground

@Composable
fun FirstLetterStickyHeader(
    letter : String,
    fontSize : TextUnit = 23.sp,
    fontWeight : FontWeight = FontWeight.Bold,
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .padding(vertical = 8.dp),
        contentAlignment = Alignment.Center
    ){
        Text(
            letter ,
            fontSize = fontSize,
            fontWeight = fontWeight,
            color = darkOnBackground
        )
    }
}