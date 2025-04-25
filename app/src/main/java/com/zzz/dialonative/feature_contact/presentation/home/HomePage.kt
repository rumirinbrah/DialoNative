package com.zzz.dialonative.feature_contact.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zzz.dialonative.core.presentation.components.VerticalSpace
import com.zzz.dialonative.feature_contact.domain.model.Contact
import com.zzz.dialonative.feature_contact.presentation.home.components.ContactListItem
import com.zzz.dialonative.feature_contact.presentation.home.components.FirstLetterStickyHeader
import com.zzz.dialonative.feature_contact.presentation.home.components.SearchBar
import org.koin.androidx.compose.koinViewModel


@Composable
fun HomePageRoot(
    onContactClick: (id : Long) -> Unit,
    homeViewModel: HomeViewModel = koinViewModel()
) {
    val state by homeViewModel.state.collectAsStateWithLifecycle()

    HomePage(
        state,
        onContactClick = onContactClick
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomePage(
    state : HomeState,
    onContactClick : (id : Long)->Unit
) {

    val grouped = remember(state.contacts) {  state.contacts.groupBy { it.name.first().uppercaseChar() } }

    Box(
        Modifier.fillMaxSize()
    ){
        if(state.loading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        else{
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
                                contact = contact,
                                onClick = onContactClick,
                                onDial = {}
                            )
                        }
                    }
                }
            }
        }


    }
}

@Preview
@Composable
private fun HomePrev() {
    HomePageRoot(onContactClick = {})
}




