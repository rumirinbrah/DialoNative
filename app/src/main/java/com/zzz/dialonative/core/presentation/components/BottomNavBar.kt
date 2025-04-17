package com.zzz.dialonative.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.zzz.dialonative.core.presentation.util.bottomItems
import com.zzz.dialonative.ui.theme.darkButton
import com.zzz.dialonative.ui.theme.darkOnCreate

@Composable
fun BottomNavBar(
    navController : NavHostController,
    onHeightCalculated : (Int)->Unit
) {
    val entry = navController.currentBackStackEntryAsState()

    Row (
        Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 25f, topEnd = 25f))
            .background(darkOnCreate.copy(alpha = 0.5f))
            .navigationBarsPadding()
            .onGloballyPositioned {coordinates ->
                onHeightCalculated(coordinates.size.height)
            },
            //.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ){

        bottomItems.onEach { item->
            val selected = entry.value?.destination?.hierarchy?.any{
                it.hasRoute(item.route::class)
            } == true
            NavigationBarItem(
                selected = selected,
                onClick = {
                    if(!selected){
                        navController.navigate(item.route){
                            navController.popBackStack()
                        }
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(item.icon) ,
                        contentDescription = item.title,
                        tint = Color.White
                    )
                },
                label = {
                    Text(item.title)
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = darkButton
                )
            )
        }


    }
}