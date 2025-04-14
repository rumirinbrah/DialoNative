package com.zzz.dialonative.feature_contact.domain.model

import android.net.Uri

data class Contact(
    val id : Long,
    val phone : String="8976569210",
    val name : String = "",
    val userImage : Uri? = null,
    val email : String? = null,
    val countryCode : Int = 91,
    val color : Int
)
