package com.zzz.dialonative.feature_contact.presentation.recents.util

import com.zzz.dialonative.R
import com.zzz.dialonative.feature_contact.domain.model.RecentCallType
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Date

/**
 * @return - Converts a Long value to LocalDateTime and returns it
 */
fun Long.toLocalDateTime() : LocalDateTime{
    return LocalDateTime.ofInstant(
        Instant.ofEpochMilli(this),
        ZoneId.systemDefault()
    )
}

/**
 * @param current - LocalDateTime object
 * @return - A string representing whether the date is relative to "Today", "Yesterday" or a "dd MMM" format date
 */
fun getRelativeDate(current : LocalDateTime) : String{
    val today = LocalDateTime.now()

    return when(ChronoUnit.DAYS.between(current,today)){
        0L->{
            "Today"
        }
        1L->{
            "Yesterday"
        }
        else->{
            val formatter = DateTimeFormatter.ofPattern("dd MMM")
            return current.format(formatter)
        }
    }
}
fun getFormattedStringForRecentCall(time : Long) : String{
    val today = LocalDateTime.now()
    val recent = time.toLocalDateTime()
    return when(ChronoUnit.DAYS.between(recent,today)){
        0L->{
            val formatter = DateTimeFormatter.ofPattern("h:mm")
            recent.format(formatter)
        }
        1L->{
            "Yesterday"
        }
        else-> {
            val formatter = DateTimeFormatter.ofPattern("dd MMM")
            recent.format(formatter)
        }
    }

}
fun RecentCallType.getIcon() : Int{
    return when(this){
        RecentCallType.INCOMING -> R.drawable.incoming_call_icon
        RecentCallType.OUTGOING -> R.drawable.outgoing_call_icon
        RecentCallType.MISSED_CALL -> R.drawable.missed_call_icon
    }
}

