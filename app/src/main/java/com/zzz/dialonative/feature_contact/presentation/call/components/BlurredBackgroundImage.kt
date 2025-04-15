package com.zzz.dialonative.feature_contact.presentation.call.components

import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.zzz.dialonative.core.presentation.components.VerticalSpace

@Composable
fun BlurredBackgroundImage(
    uri : Uri? = null,
    icon : Int,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val config = LocalConfiguration.current

    Box(
        modifier.fillMaxWidth()
    ){
        AsyncImage(
            model = ImageRequest.Builder(context)
                .crossfade(true)
                .data(icon)
                .build(),
            contentDescription = "User image",
            modifier = Modifier.aspectRatio(1f)
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .blur(10.dp)
                .alpha(0.5f)
                .align(Alignment.Center),
            contentScale = ContentScale.Crop
        )
        Column(
            Modifier.fillMaxWidth().align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            VerticalSpace(40.dp)
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .crossfade(true)
                    .data(icon)
                    .build(),
                contentDescription = "User image",
                modifier = Modifier.size(config.screenWidthDp.dp/2)
                    .clip(RoundedCornerShape(35)),
                contentScale = ContentScale.Crop,
            )
        }

    }
}