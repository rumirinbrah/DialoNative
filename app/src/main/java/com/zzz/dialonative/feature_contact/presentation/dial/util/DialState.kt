package com.zzz.dialonative.feature_contact.presentation.dial.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.zzz.dialonative.feature_contact.domain.model.Contact

data class DialState(
    val suggestedContacts : List<Contact> = tempContacts,//emptyList(),
    val phNo : String = ""
)
val tempContacts = listOf(
    Contact(contactId = 2, color = Color.Red.toArgb(), name = "Atharva P", phone = "9767290913"),
    Contact(contactId = 3, color = Color.Green.toArgb(), name = "Ankush A"),
    Contact(contactId = 4, color = Color.Red.toArgb(), name = "Bhupesh M"),
    Contact(contactId = 5, color = Color.Green.toArgb(), name = "Mrinal P" , phone = "8378834813"),
    Contact(contactId = 6, color = Color.Green.toArgb(), name = "Srushti Patale"),
    Contact(contactId = 7, color = Color.Red.toArgb(), name = "Akshay P", phone = "9767297913"),
    Contact(contactId = 8, color = Color.Green.toArgb(), name = "Anuradha S"),
    Contact(contactId = 9, color = Color.Red.toArgb(), name = "Niga M"),
    Contact(contactId = 11, color = Color.Green.toArgb(), name = "Gojo P" , phone = "7478834813"),
    Contact(contactId = 12, color = Color.Green.toArgb(), name = "Yee boi"),
)


