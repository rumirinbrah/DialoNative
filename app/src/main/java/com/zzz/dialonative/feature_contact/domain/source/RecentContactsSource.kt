package com.zzz.dialonative.feature_contact.domain.source

import com.zzz.dialonative.feature_contact.domain.model.ContactWithRecentCalls
import com.zzz.dialonative.feature_contact.domain.model.RecentContact
import kotlinx.coroutines.flow.Flow

interface RecentContactsSource {

    suspend fun addRecentContact(recentContact: RecentContact)

    suspend fun updateRecentContact(recentContact: RecentContact)

    suspend fun deleteContactById(id : Long)

    suspend fun getContactById(id: Long) : ContactWithRecentCalls?

    fun getRecentContacts() : Flow<List<ContactWithRecentCalls>>

}