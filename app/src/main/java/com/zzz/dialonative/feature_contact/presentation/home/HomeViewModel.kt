package com.zzz.dialonative.feature_contact.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zzz.dialonative.feature_contact.domain.source.ContactsSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val contactsSource: ContactsSource
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000)
            getContacts()
        }
    }

    private suspend fun getContacts() {
        Log.d("idk" , "getContacts: Fetching contacts ")

        _state.update {
            it.copy(loading = true)
        }
        contactsSource.getContacts().collect { contacts ->
            Log.d("idk" , "getContacts: DONE ")
            _state.update {
                it.copy(loading = false , contacts = contacts)
            }
        }

    }


}