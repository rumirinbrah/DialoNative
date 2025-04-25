package com.zzz.dialonative.feature_contact.presentation.home

import com.zzz.dialonative.feature_contact.domain.model.Contact

data class HomeState(
    val contacts : List<Contact> = emptyList(),
    val loading : Boolean = false,
)
