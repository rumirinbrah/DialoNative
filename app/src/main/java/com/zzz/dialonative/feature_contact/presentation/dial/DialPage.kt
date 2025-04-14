package com.zzz.dialonative.feature_contact.presentation.dial

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zzz.dialonative.feature_contact.presentation.dial.components.PhoneTextField

@Composable
fun DialPageRoot(

) {
    DialPage()
}

@Composable
private fun DialPage(
    modifier: Modifier = Modifier
) {

    Box(
        Modifier.fillMaxSize()
            .padding(16.dp)
    ){
        PhoneTextField(
            onDial = {

            },
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}