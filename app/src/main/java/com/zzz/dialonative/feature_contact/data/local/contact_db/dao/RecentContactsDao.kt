package com.zzz.dialonative.feature_contact.data.local.contact_db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.zzz.dialonative.feature_contact.domain.model.ContactWithRecentCalls
import com.zzz.dialonative.feature_contact.domain.model.RecentContact
import kotlinx.coroutines.flow.Flow


@Dao
abstract class RecentContactsDao {

    @Insert
    abstract suspend fun addRecentContact(recentContact: RecentContact)

    @Query("delete from recent_contacts_table where recentId = :id")
    abstract suspend fun deleteRecentContactById(id : Long)

    @Update
    abstract suspend fun updateRecentContactData(recentContact: RecentContact)

    @Query("select * from recent_contacts_table where recentId = :id")
    abstract suspend fun getRecentContactById(id: Long) : ContactWithRecentCalls

    //ensures consistency uhh...something like that
    @Transaction
    @Query("select * from recent_contacts_table")
    abstract fun getRecentContacts() : Flow<List<ContactWithRecentCalls>>



}