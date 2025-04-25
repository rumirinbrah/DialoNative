package com.zzz.dialonative.feature_contact.presentation.create_contact

import android.net.Uri

data class CreateContactState(
    val name : String = "",
    val mobile : String = "",
    val email : String = "",
    val image : Uri? = null,
    val color : Int? = null
)
