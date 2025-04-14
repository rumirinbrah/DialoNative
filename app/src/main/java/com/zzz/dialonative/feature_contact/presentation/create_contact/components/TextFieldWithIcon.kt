package com.zzz.dialonative.feature_contact.presentation.create_contact.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zzz.dialonative.ui.theme.darkOnBackground
import com.zzz.dialonative.ui.theme.darkOnCreate

@Composable
fun TextFieldWithIcon(
    value : String,
    icon : Int ,
    placeholder : String,
    imeAction: ImeAction,
    isPhoneField : Boolean = false,
    onValueChange : (String) ->Unit,
    onFocusChange :()->Unit
) {
    Row (
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            painter = painterResource(icon),
            contentDescription = placeholder,
            tint = darkOnBackground,
            modifier = Modifier.size(35.dp)
        )
        TextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(placeholder, fontSize = 17.sp)
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = darkOnCreate,
                focusedContainerColor = darkOnCreate,
                focusedIndicatorColor = darkOnBackground,
                cursorColor = darkOnBackground,
                focusedPlaceholderColor = darkOnBackground,
                unfocusedPlaceholderColor = darkOnBackground,
            ),
            modifier = Modifier.weight(1f),
            keyboardActions = KeyboardActions(
                onDone = {
                    onFocusChange()
                },
                onGo = {
                    onFocusChange()
                }
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = if(isPhoneField) KeyboardType.Phone else KeyboardType.Text,
                imeAction = imeAction
            ),
            textStyle = TextStyle(
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = darkOnBackground
            )
        )
    }
}