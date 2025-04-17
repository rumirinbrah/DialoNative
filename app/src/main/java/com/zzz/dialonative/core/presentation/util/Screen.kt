package com.zzz.dialonative.core.presentation.util

import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    data class CreateContactScreen(val phone : String) : Screen()

    @Serializable
    data object HomeScreen : Screen()

    @Serializable
    data object RecentScreen : Screen()

    @Serializable
    data object DialScreen : Screen()
}