package com.zzz.dialonative.feature_contact.presentation.recents

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zzz.dialonative.core.presentation.components.VerticalSpace
import com.zzz.dialonative.feature_contact.domain.model.RecentCall
import com.zzz.dialonative.feature_contact.domain.model.RecentCallType
import com.zzz.dialonative.feature_contact.domain.model.RecentContact
import com.zzz.dialonative.feature_contact.presentation.home.components.SearchBar
import com.zzz.dialonative.feature_contact.presentation.recents.components.DateStickyHeader
import com.zzz.dialonative.feature_contact.presentation.recents.components.RecentListItem
import com.zzz.dialonative.feature_contact.presentation.recents.util.toLocalDateTime
import java.util.concurrent.TimeUnit

@Composable
fun RecentCallsRoot(

) {
    RecentCallsPage()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun RecentCallsPage(
    modifier: Modifier = Modifier
) {
    val recents = listOf(
        RecentContact(
            recentId = 4,
            name = "Atharva",
            color = Color.Red.toArgb(),
            mostRecentCall = RecentCall(callType = RecentCallType.INCOMING)
        ),
        RecentContact(
            recentId = 2,
            name = "Parth",
            color = Color.Red.toArgb(),
            mostRecentCall = RecentCall(callType = RecentCallType.OUTGOING)
        ),
        RecentContact(
            recentId = 14,
            name = "Gojo",
            color = Color.Red.toArgb(),
            mostRecentCall = RecentCall(
                callType = RecentCallType.MISSED_CALL,
                timestamp = System.currentTimeMillis()- TimeUnit.DAYS.toMillis(1)
            )
        ),
        RecentContact(
            recentId = 1,
            name = "Sangle",
            color = Color.Red.toArgb(),
            mostRecentCall = RecentCall(
                callType = RecentCallType.INCOMING,
                timestamp = System.currentTimeMillis()- TimeUnit.DAYS.toMillis(3)
            )
        ),
    )

    val groupedRecents = remember {
        recents.groupBy {
            it.mostRecentCall.timestamp.toLocalDateTime()
        }
    }

    Box(

    ){
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            VerticalSpace(10.dp)
            SearchBar(
                value = "",
                onValueChange = {}
            )
            VerticalSpace()
            LazyColumn (
                Modifier.fillMaxSize()
            ){
                groupedRecents.forEach { (header , recentContacts) ->
                    stickyHeader {
                        DateStickyHeader(
                            header,
                            fontSize = 17.sp
                        )
                    }
                    items(recentContacts) {contact->
                        RecentListItem(
                            contact = contact,
                            onDial = {},
                            onClick = {}
                        )
                    }
                }
            }

        }
    }
}
