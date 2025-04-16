package com.zzz.dialonative.feature_contact.presentation.call.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zzz.dialonative.core.presentation.components.VerticalSpace
import com.zzz.dialonative.ui.theme.darkOnBackground

@Composable
fun CallStatusIndicator(
    duration : String,
    title : String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        VerticalSpace(30.dp)

        Text(
            duration ,
            fontSize = 13.sp ,
            color = darkOnBackground
        )

        Text(
            title ,
            fontSize = 15.sp ,
            color = darkOnBackground
        )
    }
}