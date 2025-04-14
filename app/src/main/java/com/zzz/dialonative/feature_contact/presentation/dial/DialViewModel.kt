package com.zzz.dialonative.feature_contact.presentation.dial

import androidx.lifecycle.ViewModel
import com.zzz.dialonative.feature_contact.presentation.dial.util.DialAction
import com.zzz.dialonative.feature_contact.presentation.dial.util.DialState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DialViewModel : ViewModel() {

    private val _state = MutableStateFlow(DialState())
    val state = _state.asStateFlow()


    init {
        println("DialVM init")
    }
    fun onAction(action: DialAction){
        when(action){
            is DialAction.DialNumber -> TODO()
            is DialAction.OnNumChange -> {
                onNumChange(action.value)
            }
        }
    }

    private fun onNumChange(value : String){
        _state.update {
            it.copy(phNo = value)
        }
    }

}