package com.zzz.dialonative.feature_contact.data.local.contact_db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.zzz.dialonative.feature_contact.data.local.contact_db.converters.RecentConverters
import com.zzz.dialonative.feature_contact.data.local.contact_db.converters.UriTypeConverter
import com.zzz.dialonative.feature_contact.domain.model.Contact
import com.zzz.dialonative.feature_contact.domain.model.RecentContact

@Database(
    entities = [Contact::class , RecentContact::class],
    version =1,
)
@TypeConverters(value = [UriTypeConverter::class, RecentConverters::class])
abstract class ContactDatabase :RoomDatabase(){



}