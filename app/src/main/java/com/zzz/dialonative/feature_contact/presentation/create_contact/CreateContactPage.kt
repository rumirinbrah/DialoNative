package com.zzz.dialonative.feature_contact.presentation.create_contact

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zzz.dialonative.R
import com.zzz.dialonative.core.presentation.components.VerticalSpace
import com.zzz.dialonative.feature_contact.presentation.create_contact.components.AddImageBox
import com.zzz.dialonative.feature_contact.presentation.create_contact.components.TextFieldWithIcon
import com.zzz.dialonative.ui.theme.darkButton
import com.zzz.dialonative.ui.theme.darkOnBackground
import com.zzz.dialonative.ui.theme.darkSurface

@Composable
fun CreateContactRoot(
    cancel : ()->Unit,
    viewModel : CreateContactViewModel = viewModel() ,
) {

    val state by viewModel.state.collectAsStateWithLifecycle()
    CreateContactPage(
        state ,
        cancel = cancel,
        onAction = {action->
            viewModel.onAction(action)
        }
    )

}


@Composable
private fun CreateContactPage(
    state: CreateContactState,
    cancel : () ->Unit,
    onAction : (CreateAction)->Unit
) {
    val focusManager = LocalFocusManager.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) {uri->
        uri?.let {
            onAction(CreateAction.OnAddImage(uri))
        }
    }

    Column(
        Modifier.fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        VerticalSpace()
        Box(
            Modifier
                .clip(CircleShape)
                .background(Color.DarkGray) ,
            contentAlignment = Alignment.Center
        ){
            IconButton(
                onClick = cancel
            ) {
                Icon(
                    imageVector = Icons.Default.Close ,
                    contentDescription = "Cancel" ,
                    tint = darkOnBackground
                )
            }
        }

        VerticalSpace(30.dp)
        Text(
            "Create Contact" ,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = darkOnBackground
        )
        VerticalSpace()

        //image
        AddImageBox(
            addedImage = state.image,
            onClick = {
                launcher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            }
        )

        VerticalSpace(30.dp)

        Column(
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            //name
            TextFieldWithIcon(
                value = state.name,
                icon = R.drawable.user_icon,
                placeholder = "Contact Name",
                imeAction = ImeAction.Next,
                onValueChange = {
                    onAction(CreateAction.OnNameChange(it))
                },
                onFocusChange = {
                    //no need to do this manually, compose takes care of it...not sure how though
                    focusManager.moveFocus(FocusDirection.Down)
                }
            )

            //phone
            TextFieldWithIcon(
                value = state.mobile,
                icon = R.drawable.phone_icon,
                placeholder = "Mobile No",
                imeAction = ImeAction.Next,
                onValueChange = {
                    onAction(CreateAction.OnPhoneChange(it))
                },
                onFocusChange = {
                    focusManager.moveFocus(FocusDirection.Down)
                },
                isPhoneField = true
            )

            //email
            TextFieldWithIcon(
                value = state.email,
                icon = R.drawable.email_icon,
                placeholder = "Email",
                imeAction = ImeAction.Done,
                onValueChange = {
                    onAction(CreateAction.OnEmailChange(it))
                },
                onFocusChange = {
                    focusManager.clearFocus()
                }
            )

        }

        VerticalSpace(40.dp)
        Button(
            onClick = {},
            shape = Shapes().medium,
            colors = ButtonDefaults.buttonColors(
                containerColor = darkButton
            ),
            modifier = Modifier.width(200.dp)
                .height(40.dp)
                .align(Alignment.CenterHorizontally)
        ){
            Text(
                "Done" ,
                color = Color.White ,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }


    }
}

