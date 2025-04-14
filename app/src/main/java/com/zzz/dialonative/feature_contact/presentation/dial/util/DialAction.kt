package com.zzz.dialonative.feature_contact.presentation.dial.util

sealed class DialAction {
    data class DialNumber(val num : String) : DialAction()

}