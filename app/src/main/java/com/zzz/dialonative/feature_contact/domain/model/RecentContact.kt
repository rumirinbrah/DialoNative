package com.zzz.dialonative.feature_contact.domain.model

import android.net.Uri
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.Date

/**
 * @param id - DB id
 * @param name - Contact name
 * @param userImage - Uri of the uploaded contact pic
 * @param countryCode - Code
 * @param color - A bg color if no image was uploaded
 */
data class RecentContact(
    val id: Long ,
    val phone : String="9878980435",
    val name: String = "" ,
    val userImage: Uri? = null ,
    val countryCode: Int = 91 ,
    val duration : Long? = null,
    val color: Int ,
    val mostRecentCall : RecentCall,
    val recentCalls : List<RecentCall> = emptyList()
)

data class RecentCall(
    val callType: RecentCallType,
    val timestamp : Long = System.currentTimeMillis()
)
enum class RecentCallType(val msg : String){
    INCOMING("Incoming Call"),
    OUTGOING("Outgoing Call"),
    MISSED_CALL("Missed Call")
}
fun a(){
    val date = Date(System.currentTimeMillis())
    date.day
}
//enum outgoing , incoming
//draw res -> <-
