package com.zzz.dialonative.feature_contact.presentation.create_contact.components

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.zzz.dialonative.R
import com.zzz.dialonative.core.presentation.util.LogTags
import com.zzz.dialonative.ui.theme.darkCreate
import com.zzz.dialonative.ui.theme.darkSurface

@Composable
fun AddImageBox(
    addedImage: Uri? = null ,
    onClick: () -> Unit
) {
    val context = LocalContext.current


    Box(
        Modifier
            .size(150.dp)
            .clip(CircleShape)
            .background(darkSurface)
            .clickable {
                onClick()
            } ,
        contentAlignment = Alignment.Center
    ) {
        if (addedImage == null) {
            Icon(
                painter = painterResource(R.drawable.add_photo_icon) ,
                contentDescription = "add image" ,
                tint = darkCreate ,
                modifier = Modifier.size(45.dp)
            )
        } else {
            //val uri = Uri.Builder().path(addedImage.path).build()
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .crossfade(true)
                    .data(addedImage)
                    .build() ,
                contentDescription = "uploaded image" ,
                contentScale = ContentScale.Crop ,
                modifier = Modifier.fillMaxSize()
            )
        }

    }
}