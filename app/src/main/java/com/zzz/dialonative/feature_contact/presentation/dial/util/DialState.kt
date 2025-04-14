package com.zzz.dialonative.feature_contact.presentation.dial.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.zzz.dialonative.feature_contact.domain.model.Contact

data class DialState(
    val suggestedContacts : List<Contact> = tempContacts,//emptyList(),
    val phNo : String = ""
)
val tempContacts = listOf(
    Contact(id = 2, color = Color.Red.toArgb(), name = "Atharva P", phone = "9767290913"),
    Contact(id = 3, color = Color.Green.toArgb(), name = "Ankush A"),
    Contact(id = 4, color = Color.Red.toArgb(), name = "Bhupesh M"),
    Contact(id = 5, color = Color.Green.toArgb(), name = "Mrinal P" , phone = "8378834813"),
    Contact(id = 6, color = Color.Green.toArgb(), name = "Srushti Patale"),
)


