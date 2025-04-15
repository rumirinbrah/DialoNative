package com.zzz.dialonative.feature_contact.presentation.dial.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zzz.dialonative.R
import com.zzz.dialonative.core.presentation.components.CustomButton
import com.zzz.dialonative.ui.theme.darkBackground
import com.zzz.dialonative.ui.theme.darkOnBackground
import com.zzz.dialonative.ui.theme.dialButton

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PhoneTextField(
    value : String,
    onValueChange : (String)->Unit,
    onDial : (String)->Unit,
    modifier: Modifier = Modifier
) {

    //max ph no digits can be 16 & min 4
    Column(
        modifier
            .wrapContentHeight()
            .fillMaxWidth() ,
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            Modifier.fillMaxWidth() ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomButton(
                icon = R.drawable.close_icon ,
                label = "backspace" ,
                onClick = {
                    //number = ""
                    onValueChange("")
                }
            )
            TextField(
                value = value ,
                onValueChange = {

                } ,
                modifier = Modifier
                    .weight(1f) ,
                readOnly = true ,
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = darkBackground ,
                    focusedContainerColor = darkBackground,
                    focusedIndicatorColor = darkOnBackground
                ) ,
                textStyle = TextStyle(
                    fontSize = 35.sp ,
                    fontWeight = FontWeight.Bold ,
                    color = darkOnBackground ,
                    textAlign = TextAlign.Center
                ) ,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                )
            )
            CustomButton(
                icon = R.drawable.backspace_icon ,
                label = "backspace" ,
                onClick = {
                     onValueChange(value.dropLast(1))
                }
            )

        }
        FlowRow(
            modifier = Modifier.wrapContentHeight() ,
            maxItemsInEachRow = 3 ,
            verticalArrangement = Arrangement.spacedBy(4.dp) ,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            repeat(9) {
                DigitButton(
                    modifier = Modifier.weight(1f) ,
                    digit = it + 1 ,
                    onClick = { num ->
                        //number += num
                        onValueChange(value+num)
                        /*number = number.copy(
                            text = number.text.addDigit(
                                number.selection.start ,
                                number.selection.end ,
                                num
                            )
                        )*/
                    } ,
                    fontSize = 35.sp
                )
            }
            DigitButton(
                modifier = Modifier.weight(1f) ,
                digit = 0 ,
                isSymbol = true ,
                symbol = "*" ,
                onClick = { num ->
                    onValueChange(value+num)
                }
            )
            DigitButton(
                modifier = Modifier.weight(1f) ,
                digit = 0 ,
                onClick = { num ->
                    //number += num
                    onValueChange(value+num)
                }
            )
            DigitButton(
                modifier = Modifier.weight(1f) ,
                digit = 0 ,
                isSymbol = true ,
                symbol = "#" ,
                onClick = { num ->
                    //number += num
                    onValueChange(value+num)
                }
            )
        }
        Button(
            enabled = value.isNotBlank(),
            onClick = {
                onDial(value.trim())
            } ,
            colors = ButtonDefaults.buttonColors(
                containerColor = dialButton
            )
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp) ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.phone_icon) ,
                    contentDescription = "DIAL" ,
                    tint = darkOnBackground
                )
                Text(
                    "Call" ,
                    fontSize = 18.sp ,
                    color = darkOnBackground
                )
            }
        }
    }
}
