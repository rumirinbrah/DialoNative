package com.zzz.dialonative.feature_contact.domain.model

import android.net.Uri
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.zzz.dialonative.feature_contact.data.local.util.DBConstants
import kotlinx.serialization.Serializable

/**
 * @param recentId - DB id
 */
@Entity(
    tableName = DBConstants.RECENT_CONTACTS_TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = Contact::class ,
            parentColumns = ["contactId"] ,
            childColumns = ["contactId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index("contactId")
    ]
)
data class RecentContact(
    @PrimaryKey(autoGenerate = true) val recentId: Long ,
    val mostRecentCall : RecentCall ,
    val recentCalls : List<RecentCall> = emptyList(),
    val contactId : Long //@FOREIGN KEY
)
@Serializable
data class RecentCall(
    val duration: Long? = null,
    val callType: RecentCallType,
    val timestamp : Long = System.currentTimeMillis()
)
enum class RecentCallType(val msg : String){
    INCOMING("Incoming Call"),
    OUTGOING("Outgoing Call"),
    MISSED_CALL("Missed Call")
}

