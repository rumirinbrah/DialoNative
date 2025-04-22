package com.zzz.dialonative.feature_contact.data.local.repository

import com.zzz.dialonative.feature_contact.data.local.contact_db.dao.ContactsDao
import com.zzz.dialonative.feature_contact.domain.model.Contact
import com.zzz.dialonative.feature_contact.domain.source.ContactsSource
import kotlinx.coroutines.flow.Flow

class RoomContactsSource(
    private val contactsDao: ContactsDao
) : ContactsSource {

    override suspend fun addContact(contact: Contact) {
        contactsDao.addContact(contact)
    }

    override suspend fun updateContact(contact: Contact) {
        contactsDao.updateContact(contact)
    }

    override suspend fun deleteContactById(id: Long) {
        contactsDao.deleteContactById(id)
    }

    override suspend fun getContactById(id: Long): Contact? {
        return contactsDao.getContactById(id)
    }

    override fun getContacts(): Flow<List<Contact>> {
        return contactsDao.getContacts()
    }
}