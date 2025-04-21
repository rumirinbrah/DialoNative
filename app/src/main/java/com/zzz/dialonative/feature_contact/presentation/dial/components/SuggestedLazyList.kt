package com.zzz.dialonative.feature_contact.presentation.dial.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zzz.dialonative.R
import com.zzz.dialonative.core.presentation.components.IconTextButton
import com.zzz.dialonative.core.presentation.components.VerticalSpace
import com.zzz.dialonative.feature_contact.presentation.dial.util.DialState
import com.zzz.dialonative.feature_contact.presentation.home.components.ContactListItem
import com.zzz.dialonative.ui.theme.darkSecondary
import com.zzz.dialonative.ui.theme.darkSurface

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuggestedLazyList(
    state: DialState ,
    onNavToCreate: () -> Unit ,
    modifier: Modifier = Modifier
) {
    val filteredContacts = remember(state.phNo) {
        state.suggestedContacts.filter {
            it.phone.startsWith(state.phNo)
        }
    }

    LazyColumn(
        modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        //CREATE NEW
        item {
            IconTextButton(
                icon = R.drawable.user_add_icon ,
                text = "Create new contact" ,
                onClick = {
                    onNavToCreate()
                } ,
                contentColor = darkSurface ,
                modifier = Modifier.fillMaxWidth(0.6f)
            )
        }
        //SUGGESTED
        item {
            Text(
                "Suggested Contacts" ,
                fontSize = 15.sp ,
                color = darkSecondary
            )
            VerticalSpace()
        }

        //SUGGESTED
        items(
            filteredContacts ,
            key = {
                it.contactId
            }
        ) { contact ->
            ContactListItem(
                contact ,
                showNumber = true ,
                modifier = Modifier.animateItem()
            )
        }
    }
}