package com.zzz.dialonative.feature_contact.data.local.repository

import com.zzz.dialonative.feature_contact.data.local.contact_db.dao.RecentContactsDao
import com.zzz.dialonative.feature_contact.domain.model.ContactWithRecentCalls
import com.zzz.dialonative.feature_contact.domain.model.RecentContact
import com.zzz.dialonative.feature_contact.domain.source.RecentContactsSource
import kotlinx.coroutines.flow.Flow

class RoomRecentContactsSrc(
    private val dao: RecentContactsDao
) : RecentContactsSource {

    override suspend fun addRecentContact(recentContact: RecentContact) {
        dao.addRecentContact(recentContact)
    }

    override suspend fun updateRecentContact(recentContact: RecentContact) {
        dao.updateRecentContactData(recentContact)
    }

    override suspend fun deleteContactById(id: Long) {
        dao.deleteRecentContactById(id)
    }

    override suspend fun getContactById(id: Long): ContactWithRecentCalls? {
        return dao.getRecentContactById(id)
    }

    override fun getRecentContacts(): Flow<List<ContactWithRecentCalls>> {
        return dao.getRecentContacts()
    }
}