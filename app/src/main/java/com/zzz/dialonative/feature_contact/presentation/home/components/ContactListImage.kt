package com.zzz.dialonative.feature_contact.presentation.home.components

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.zzz.dialonative.ui.theme.darkOnBackground

@Composable
fun ContactListImage(
    uri : Uri? = null,
    color : Int,
    firstLetter : String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    if(uri==null){
        Box(
            modifier = modifier.aspectRatio(1f)
            .fillMaxHeight()
            .clip(CircleShape)
            .background(Color(color)),
            contentAlignment = Alignment.Center
        ){
            Text(
                firstLetter ,
                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                fontWeight = FontWeight.ExtraBold,
                color = darkOnBackground
            )
        }
    }else{
        AsyncImage(
            model = ImageRequest.Builder(context)
                .crossfade(true)
                .data(uri)
                .build(),
            contentDescription ="User image",
            modifier = modifier.aspectRatio(1f)
                .fillMaxHeight()
                .clip(CircleShape)
                .background(Color.DarkGray),
            contentScale = ContentScale.Crop
        )
    }

}