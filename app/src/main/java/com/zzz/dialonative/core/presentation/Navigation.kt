package com.zzz.dialonative.core.presentation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zzz.dialonative.core.presentation.components.BottomNavBar
import com.zzz.dialonative.core.presentation.util.Screen
import com.zzz.dialonative.feature_contact.presentation.create_contact.CreateContactRoot
import com.zzz.dialonative.feature_contact.presentation.home.HomePage
import com.zzz.dialonative.feature_contact.presentation.recents.RecentCallsRoot
import com.zzz.dialonative.ui.theme.darkBackground

@Composable
fun Navigation(

) {
    val navController = rememberNavController()

    Scaffold(
        containerColor = darkBackground,
        bottomBar = {
            BottomNavBar(navController)
        }
    ) {paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.RecentScreen,
            modifier = Modifier.padding(paddingValues),
            enterTransition = {
                EnterTransition.None
            },
            exitTransition ={
                ExitTransition.None
            }
        ) {
            composable<Screen.CreateContactScreen> {
                CreateContactRoot(
                    cancel = {
                        println("CLOSE")
                        navController.navigateUp()
                    }
                )
            }
            composable<Screen.HomeScreen>(
                enterTransition = {
                    slideIntoContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(300)
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.Right,
                        animationSpec = tween(300)
                    )
                }
            ) {

                HomePage()
            }
            composable<Screen.RecentScreen>(
                enterTransition = {
                    slideIntoContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.Right,
                        animationSpec = tween(300)
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(300)
                    )
                }
            ) {
                RecentCallsRoot()
            }
        }
    }
}