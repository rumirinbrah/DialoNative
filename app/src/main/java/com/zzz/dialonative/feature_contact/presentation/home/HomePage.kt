package com.zzz.dialonative.feature_contact.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zzz.dialonative.core.presentation.components.VerticalSpace
import com.zzz.dialonative.feature_contact.domain.model.Contact
import com.zzz.dialonative.feature_contact.presentation.home.components.ContactListItem
import com.zzz.dialonative.feature_contact.presentation.home.components.DialFab
import com.zzz.dialonative.feature_contact.presentation.home.components.FirstLetterStickyHeader
import com.zzz.dialonative.feature_contact.presentation.home.components.SearchBar


@Composable
fun HomePageRoot(
    onDialFab : ()->Unit
) {
    HomePage(
        onDialFab = onDialFab
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomePage(
    onDialFab: () -> Unit
) {
    val contacts = listOf(
        Contact(id = 2, color = Color.Red.toArgb(), name = "Atharva P"),
        Contact(id = 2, color = Color.Green.toArgb(), name = "Ankush A"),
        Contact(id = 2, color = Color.Red.toArgb(), name = "Bhupesh M"),
        Contact(id = 2, color = Color.Green.toArgb(), name = "Chotu M"),
        Contact(id = 2, color = Color.Green.toArgb(), name = "Srushti Patale"),
    )
    val grouped = remember {  contacts.groupBy { it.name.first().uppercaseChar() } }

    Box(

    ){
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            //verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            VerticalSpace(10.dp)
            SearchBar(
                value = "",
                onValueChange = {}
            )
            VerticalSpace()

            LazyColumn(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                grouped.forEach { (letter , contacts) ->
                    stickyHeader {
                        FirstLetterStickyHeader(letter.toString())
                    }
                    items(contacts){contact->

                        ContactListItem(
                            contact = contact
                        )
                    }
                }
            }
        }
        DialFab(
            onClick = onDialFab,
            size = 50.dp,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        )

    }
}

@Preview
@Composable
private fun HomePrev() {
    HomePage({})
}




