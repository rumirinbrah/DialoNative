package com.zzz.dialonative.feature_contact.presentation.create_contact

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zzz.dialonative.core.presentation.util.LogTags
import com.zzz.dialonative.feature_contact.domain.model.Contact
import com.zzz.dialonative.feature_contact.domain.source.ContactsSource
import com.zzz.dialonative.ui.theme.contactColors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CreateContactViewModel(
    private val context: Context ,
    private val contactSource: ContactsSource
) : ViewModel() {

    private val _state = MutableStateFlow(CreateContactState())
    val state = _state.asStateFlow()

    fun onAction(action: CreateAction) {
        when (action) {
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

            //create
            CreateAction.CreateContact -> {
                createContact()
            }
            //update
            CreateAction.UpdateContact -> {
                updateContact()
            }
            //fetch details
            is CreateAction.FetchContact -> {
                fetchContact(action.id)
            }
        }
    }

    private fun onImageAdd(uri: Uri) {
        Log.d(LogTags.CREATE_CONTACT , "onImageAdd: Image added")
        _state.update {
            it.copy(image = uri)
        }
    }

    //textfield
    private fun onEmailChange(value: String) {
        _state.update {
            it.copy(email = value)
        }
    }

    //textfield
    private fun onNameChange(value: String) {
        _state.update {
            it.copy(name = value)
        }
    }

    //textfield
    private fun onPhoneChange(value: String) {
        _state.update {
            val filteredText = value.filter { char ->
                !char.toString().matches(Regex("[a-zA-Z]"))
            }
            it.copy(mobile = filteredText)
        }
    }

    //db
    private fun createContact() {
        viewModelScope.launch {
            Log.d(LogTags.CREATE_VM , "createContact: Creating... ")
            withContext(Dispatchers.IO) {

//                _state.value.image?.let {uri->
//                    //make the URI persistable
//                    context.contentResolver.takePersistableUriPermission(
//                        uri ,
//                        Intent.FLAG_GRANT_READ_URI_PERMISSION
//                    )
//                }

                val contact = Contact(
                    name = _state.value.name ,
                    phone = _state.value.mobile ,
                    email = _state.value.email ,
                    userImage = _state.value.image ,
                    color = contactColors.random()
                )
                contactSource.addContact(contact)
            }
        }
    }

    //db
    private fun updateContact() {
        viewModelScope.launch {
            Log.d(LogTags.CREATE_VM , "updateContact: Updating... ")

            withContext(Dispatchers.IO) {
                val contact = Contact(
                    name = _state.value.name ,
                    phone = _state.value.mobile ,
                    email = _state.value.email ,
                    userImage = _state.value.image ,
                    color = _state.value.color ?: contactColors.random()
                )
                contactSource.updateContact(contact)
            }
        }
    }

    //update state on nav
    private fun fetchContact(id: Long) {
        viewModelScope.launch {
            Log.d(LogTags.CREATE_VM , "fetchContact: Fetching...")
            val result = withContext(Dispatchers.IO) {
                contactSource.getContactById(id)
            }
            result?.let { contact ->
                Log.d(
                    LogTags.CREATE_VM ,
                    "fetchContact: Name ${contact.name} and uri ${contact.userImage} "
                )

                _state.update {
                    it.copy(
                        name = contact.name ,
                        mobile = contact.phone ,
                        email = contact.email ?: "" ,
                        image = contact.userImage ,
                        color = contact.color
                    )
                }
            }
        }
    }

}