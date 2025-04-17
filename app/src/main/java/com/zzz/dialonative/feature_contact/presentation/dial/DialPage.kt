package com.zzz.dialonative.feature_contact.presentation.dial

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zzz.dialonative.feature_contact.presentation.dial.components.PhoneTextField
import com.zzz.dialonative.feature_contact.presentation.dial.components.SuggestedLazyList
import com.zzz.dialonative.feature_contact.presentation.dial.util.DialAction
import com.zzz.dialonative.feature_contact.presentation.dial.util.DialState
import org.koin.androidx.compose.koinViewModel

@Composable
fun DialPageRoot(
    dialViewModel: DialViewModel = koinViewModel(),
    onNavToCreate : (String)->Unit,
) {
    val state by dialViewModel.state.collectAsStateWithLifecycle()

    DialPage(
        state = state,
        onNavToCreate = {
            onNavToCreate(state.phNo)
        },
        onAction = {action->
            dialViewModel.onAction(action)
        }
    )
}

@Composable
private fun DialPage(
    state : DialState,
    onAction : (DialAction) -> Unit,
    onNavToCreate : ()->Unit,
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current

    Box(
        Modifier.fillMaxSize()
            //.padding(16.dp)
    ){
        SuggestedLazyList(
            state ,
            onNavToCreate = onNavToCreate,
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .padding(16.dp)
                .align(Alignment.TopCenter)
        )
        PhoneTextField(
            value = state.phNo,
            onValueChange = {newNumber->
                onAction(DialAction.OnNumChange(newNumber))
            },
            onDial = {
                val intent = Intent(Intent.ACTION_CALL).apply {
                    data = Uri.parse("tel:$it")
                }
                context.startActivity(intent)
            },
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}