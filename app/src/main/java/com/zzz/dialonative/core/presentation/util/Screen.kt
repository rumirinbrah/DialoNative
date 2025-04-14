package com.zzz.dialonative.core.presentation.util

import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    data object CreateContactScreen : Screen()

    @Serializable
    data object HomeScreen : Screen()

    @Serializable
    data object RecentScreen : Screen()
}