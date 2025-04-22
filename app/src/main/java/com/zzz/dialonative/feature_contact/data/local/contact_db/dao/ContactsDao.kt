package com.zzz.dialonative.feature_contact.data.local.contact_db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.zzz.dialonative.feature_contact.domain.model.Contact
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ContactsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun addContact(contact: Contact)

    @Query("delete from contacts_table where contactId = :id")
    abstract suspend fun deleteContactById(id : Long)

    @Update
    abstract suspend fun updateContact(contact: Contact)

    @Query("select * from contacts_table where contactId = :id")
    abstract suspend fun getContactById(id : Long) : Contact?

    @Query("select * from contacts_table")
    abstract fun getContacts() : Flow<List<Contact>>

}