package com.zzz.dialonative.feature_contact.presentation.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.zzz.dialonative.ui.theme.darkOnBackground
import com.zzz.dialonative.ui.theme.darkOnCreate
import com.zzz.dialonative.ui.theme.darkSecondary
import com.zzz.dialonative.ui.theme.darkSurface

@Composable
fun SearchBar(
    value : String,
    onValueChange : (String)->Unit,
    shape : RoundedCornerShape = RoundedCornerShape(45)
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(0.95f),
        value = value ,
        onValueChange = onValueChange,
        placeholder = {
            Text("Search for contacts...", color = darkSurface)
        },
        shape = shape,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = darkOnCreate.copy(alpha = 0.5f),
            focusedContainerColor = darkOnCreate.copy(alpha = 0.5f),
            unfocusedIndicatorColor = darkOnCreate.copy(alpha = 0.5f),
            focusedIndicatorColor = darkOnCreate.copy(alpha = 0.5f)
        ),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search ,
                contentDescription = "Search",
                tint = darkOnBackground,
                //modifier = Modifier.size(35.dp)
            )
        },
        textStyle = TextStyle(
            color = darkSurface
        )
    )

}