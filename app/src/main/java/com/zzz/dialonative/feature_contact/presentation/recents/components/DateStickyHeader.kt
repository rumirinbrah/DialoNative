package com.zzz.dialonative.feature_contact.presentation.recents.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zzz.dialonative.feature_contact.presentation.recents.util.getRelativeDate
import com.zzz.dialonative.ui.theme.darkOnBackground
import java.time.LocalDateTime

@Composable
fun DateStickyHeader(
    date : LocalDateTime ,
    fontSize : TextUnit = 20.sp ,
    fontWeight : FontWeight = FontWeight.Bold ,
    modifier: Modifier = Modifier
) {
    val text = remember {  getRelativeDate(date) }
    Box(
        modifier
            .padding(vertical = 8.dp),
        contentAlignment = Alignment.Center
    ){
        Text(
            text ,
            fontSize = fontSize,
            fontWeight = fontWeight,
            color = darkOnBackground
        )
    }
}