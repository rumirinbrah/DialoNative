package com.zzz.dialonative.feature_contact.presentation.recents.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zzz.dialonative.R
import com.zzz.dialonative.feature_contact.domain.model.ContactWithRecentCalls
import com.zzz.dialonative.feature_contact.domain.model.RecentCall
import com.zzz.dialonative.feature_contact.domain.model.RecentCallType
import com.zzz.dialonative.feature_contact.domain.model.RecentContact
import com.zzz.dialonative.feature_contact.presentation.home.components.ContactListImage
import com.zzz.dialonative.feature_contact.presentation.recents.util.getFormattedStringForRecentCall
import com.zzz.dialonative.feature_contact.presentation.recents.util.getIcon
import com.zzz.dialonative.ui.theme.DialoNativeTheme
import com.zzz.dialonative.ui.theme.darkBackground
import com.zzz.dialonative.ui.theme.darkOnBackground
import com.zzz.dialonative.ui.theme.darkOnCreate
import com.zzz.dialonative.ui.theme.darkSecondary
import com.zzz.dialonative.ui.theme.darkSurface
import com.zzz.dialonative.ui.theme.dullRed
import java.util.concurrent.TimeUnit

@Composable
fun RecentListItem(
    contactWithRecentCalls: ContactWithRecentCalls ,
    onClick: (id: Long) -> Unit ,
    onDial: (num: String) -> Unit ,
    shape: RoundedCornerShape = RoundedCornerShape(
        topEnd = 25.dp ,
        bottomStart = 25.dp ,
        bottomEnd = 25.dp
    ) ,
    modifier: Modifier = Modifier
) {
    val contact = remember { contactWithRecentCalls.contact }
    val recentsData = remember { contactWithRecentCalls.recentsData }

    val iconTint = remember {
        if (recentsData.mostRecentCall.callType == RecentCallType.MISSED_CALL) {
            dullRed
        } else {
            darkSecondary
        }
    }
    val formattedStringForRecent = remember {
        getFormattedStringForRecentCall(recentsData.mostRecentCall.timestamp)
    }


    Row(
        modifier
            .fillMaxWidth()
            .height(75.dp)
            .background(darkBackground)
    ) {
        //vertical line
        Box(
            Modifier
                .fillMaxHeight()
                .width(3.dp)
                .background(darkSurface)
        )
        Spacer(Modifier.width(20.dp))
        //holder
        Row(
            Modifier
                .fillMaxWidth()
                .height(65.dp)
                .clip(shape)
                .background(darkOnCreate)
                .padding(8.dp) ,
            verticalAlignment = Alignment.CenterVertically ,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            //img and name
            Row(
                verticalAlignment = Alignment.CenterVertically ,
                horizontalArrangement = Arrangement.spacedBy(8.dp) ,
                modifier = Modifier.clickable(
                    onClick = {
                        onClick(contact.contactId)
                    } ,
                    interactionSource = remember { MutableInteractionSource() } ,
                    indication = null
                )
            ) {
                ContactListImage(
                    uri = contact.userImage ,
                    color = Color.Red.toArgb() ,
                    firstLetter = contact.name.first().toString()
                )
                //name and time
                Column(
                    Modifier.fillMaxHeight() ,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        contact.name ,
                        fontSize = 17.sp ,
                        fontWeight = FontWeight.Medium ,
                        color = darkSurface
                    )
                    Row(
                        modifier = Modifier ,
                        verticalAlignment = Alignment.CenterVertically ,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            painter = painterResource(
                                recentsData.mostRecentCall.callType.getIcon()
                            ) ,
                            contentDescription = recentsData.mostRecentCall.callType.msg ,
                            tint = iconTint ,
                            modifier = Modifier.size(18.dp)
                        )

                        Text(
                            formattedStringForRecent ,
                            fontSize = 12.sp ,
                            color = iconTint ,
                            fontWeight = if (recentsData.mostRecentCall.callType == RecentCallType.MISSED_CALL) {
                                FontWeight.Bold
                            } else {
                                null
                            }
                        )
                    }

                }
            }
            //dial icon
            Box(
                Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.DarkGray)
                    .clickable {
                        onDial(contact.phone)
                    }
                    .padding(4.dp) ,
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.phone_icon) ,
                    contentDescription = "Call ${contact.name}" ,
                    modifier = Modifier.fillMaxSize() ,
                    tint = darkOnBackground.copy(alpha = 0.7f)
                )
            }
        }
    }
}

@Preview(showBackground = true , uiMode = 32)
@Composable
private fun RecentItemPrev() {
    DialoNativeTheme {

//        RecentListItem(
//            contactWithRecentCalls = RecentContact(
//                recentId = 4 ,
//                name = "Atharva" ,
//                color = Color.Red.toArgb() ,
//                mostRecentCall = RecentCall(
//                    callType = RecentCallType.MISSED_CALL ,
//                    timestamp = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1)
//                )
//            ) ,
//            onClick = {} ,
//            onDial = {}
//        )
    }

}