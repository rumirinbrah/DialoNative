package com.zzz.dialonative.feature_contact.domain.source

import com.zzz.dialonative.feature_contact.domain.model.Contact
import kotlinx.coroutines.flow.Flow

interface ContactsSource {

    suspend fun addContact(contact: Contact)

    suspend fun updateContact(contact: Contact)

    suspend fun deleteContactById(id : Long)

    suspend fun getContactById(id: Long) : Contact?

    fun getContacts() : Flow<List<Contact>>

}