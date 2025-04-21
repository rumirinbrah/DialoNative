package com.zzz.dialonative.feature_contact.domain.model

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zzz.dialonative.feature_contact.data.local.util.DBConstants

@Entity(tableName = DBConstants.CONTACTS_TABLE_NAME)
data class Contact(
    @PrimaryKey(autoGenerate = true) val contactId : Long ,
    val phone : String="8976569210" ,
    val name : String = "" ,
    val userImage : Uri? = null ,
    val email : String? = null ,
    val countryCode : Int = 91 ,
    val color : Int
)
