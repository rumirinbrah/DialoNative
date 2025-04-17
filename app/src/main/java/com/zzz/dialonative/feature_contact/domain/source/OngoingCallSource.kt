package com.zzz.dialonative.feature_contact.domain.source

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.zzz.dialonative.feature_contact.domain.model.Contact
import kotlinx.coroutines.flow.MutableStateFlow

interface OngoingCallSource {

    fun updateOngoingContact(contact: Contact)

    fun getCurrentContact() : Contact?

}