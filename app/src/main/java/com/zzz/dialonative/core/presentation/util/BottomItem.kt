package com.zzz.dialonative.core.presentation.util

import androidx.annotation.DrawableRes
import com.zzz.dialonative.R

data class BottomItem(
    val title : String,
    val route : Screen,
    @DrawableRes val icon : Int
)
val bottomItems = listOf(
    BottomItem(title = "Recents", route = Screen.RecentScreen, icon = R.drawable.recents_icon),
    BottomItem(title = "Contacts", route = Screen.HomeScreen,icon = R.drawable.phone_icon),
)
