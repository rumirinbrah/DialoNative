package com.zzz.dialonative.feature_contact.presentation.create_contact

import android.net.Uri
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CreateContactViewModel : ViewModel() {

    private val _state = MutableStateFlow(CreateContactState())
    val state= _state.asStateFlow()

    fun onAction(action : CreateAction){
        when(action){
            is CreateAction.OnEmailChange -> {
                onEmailChange(action.value)
            }
            is CreateAction.OnNameChange -> {
                onNameChange(action.value)
            }
            is CreateAction.OnPhoneChange -> {
                onPhoneChange(action.value)
            }

            is CreateAction.OnAddImage -> {
                onImageAdd(action.uri)
            }
        }
    }

    private fun onImageAdd(uri: Uri) {
        _state.update {
            it.copy(image = uri)
        }
    }

    private fun onEmailChange(value : String){
        _state.update {
            it.copy(email = value)
        }
    }

    private fun onNameChange(value : String){
        _state.update {
            it.copy(name = value)
        }
    }

    private fun onPhoneChange(value : String){
        _state.update {
            val filteredText = value.filter { char->
                !char.toString().matches(Regex("[a-zA-Z]"))
            }
            it.copy(mobile = filteredText)
        }
    }



}