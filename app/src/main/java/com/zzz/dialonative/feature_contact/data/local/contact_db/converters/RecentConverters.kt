package com.zzz.dialonative.feature_contact.data.local.contact_db.converters

import androidx.room.TypeConverter
import com.zzz.dialonative.feature_contact.domain.model.RecentCall
import com.zzz.dialonative.feature_contact.domain.model.RecentCallType
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class RecentConverters {

    private val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    }

    //CALLTYPE
    @TypeConverter
    fun callTypeToString(type: RecentCallType): String {
        return type.name
    }

    @TypeConverter
    fun stringToCallType(type: String): RecentCallType {
        return try {
            RecentCallType.valueOf(type)
        } catch (e: Exception) {
            RecentCallType.MISSED_CALL
        }
    }

    //RECENT CALL
    @TypeConverter
    fun recentCallToString(call : RecentCall) : String{
        return json.encodeToString(call)
    }
    @TypeConverter
    fun stringToRecentCall(callJson : String) : RecentCall{
        return json.decodeFromString(callJson)
    }

    //RECENT CALL LIST
    @TypeConverter
    fun recentCallListToString(calls : List<RecentCall>) : String{
        return json.encodeToString(calls)
    }
    @TypeConverter
    fun stringToRecentCallList(listJson : String) : List<RecentCall>{
        return json.decodeFromString(listJson)
    }

}