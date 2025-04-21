package com.zzz.dialonative.feature_contact.data.local.contact_db.converters

import android.net.Uri
import androidx.room.TypeConverter

class UriTypeConverter {

    @TypeConverter
    fun uriToString(uri: Uri?) : String?{
        return uri?.toString()
    }

    @TypeConverter
    fun stringToUri(uriString : String?) : Uri?{
        return uriString?.let{ Uri.parse(uriString)}
    }

}