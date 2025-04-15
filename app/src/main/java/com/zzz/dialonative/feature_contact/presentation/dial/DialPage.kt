package com.zzz.dialonative.feature_contact.presentation.dial

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zzz.dialonative.feature_contact.presentation.dial.components.PhoneTextField
import com.zzz.dialonative.feature_contact.presentation.dial.components.SuggestedLazyList
import com.zzz.dialonative.feature_contact.presentation.dial.util.DialAction
import com.zzz.dialonative.feature_contact.presentation.dial.util.DialState
import org.koin.androidx.compose.koinViewModel

@Composable
fun DialPageRoot(
    dialViewModel: DialViewModel = koinViewModel()
) {
    val state by dialViewModel.state.collectAsStateWithLifecycle()

    DialPage(
        state = state,
        onAction = {action->
            dialViewModel.onAction(action)
        }
    )
}

@Composable
private fun DialPage(
    state : DialState,
    onAction : (DialAction) -> Unit,
    modifier: Modifier = Modifier
) {

    Box(
        Modifier.fillMaxSize()
            .padding(16.dp)
    ){
        SuggestedLazyList(
            state ,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter)
        )
        PhoneTextField(
            value = state.phNo,
            onValueChange = {newNumber->
                onAction(DialAction.OnNumChange(newNumber))
            },
            onDial = {

            },
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}