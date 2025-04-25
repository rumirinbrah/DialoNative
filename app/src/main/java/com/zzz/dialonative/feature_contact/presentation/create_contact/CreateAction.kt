package com.zzz.dialonative.feature_contact.presentation.create_contact

import android.net.Uri

sealed class CreateAction {

    data class OnNameChange(val value : String) : CreateAction()
    data class OnEmailChange(val value : String) : CreateAction()
    data class OnPhoneChange(val value : String) : CreateAction()

    data class OnAddImage(val uri :Uri) : CreateAction()

    data object CreateContact : CreateAction()
    data object UpdateContact : CreateAction()
    data class FetchContact(val id : Long) : CreateAction()

}