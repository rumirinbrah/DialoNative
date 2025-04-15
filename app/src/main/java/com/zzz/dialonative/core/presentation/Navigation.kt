package com.zzz.dialonative.core.presentation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.zzz.dialonative.core.presentation.components.BottomNavBar
import com.zzz.dialonative.core.presentation.util.Screen
import com.zzz.dialonative.feature_contact.presentation.create_contact.CreateContactRoot
import com.zzz.dialonative.feature_contact.presentation.dial.DialPageRoot
import com.zzz.dialonative.feature_contact.presentation.home.HomePageRoot
import com.zzz.dialonative.feature_contact.presentation.recents.RecentCallsRoot
import com.zzz.dialonative.ui.theme.darkBackground

@Composable
fun Navigation(

) {
    val navController = rememberNavController()
    val navEntry = navController.currentBackStackEntryAsState()
    val navBarVisible = remember(navEntry) {
        println("State changed")
        derivedStateOf {
            navEntry.value?.destination?.hierarchy?.any {
                it.hasRoute(Screen.DialScreen::class)
            } == false
        }
    }


    Scaffold(
        containerColor = darkBackground,
        bottomBar = {
            AnimatedVisibility(
                navBarVisible.value,
                enter = slideInVertically(), //fadeIn(tween(300)) ,
                exit = slideOutVertically()//fadeOut(tween(300))
            ) {

                BottomNavBar(navController)
            }
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
            },

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

                HomePageRoot(
                    onDialFab = {
                        navController.navigate(Screen.DialScreen)
                    }
                )
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

            //dial
            composable<Screen.DialScreen>(
                enterTransition = {
                    slideIntoContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.Up,
                        animationSpec = tween(400)
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.Down,
                        animationSpec = tween(400)
                    )
                },
            ) {
                DialPageRoot()
            }
        }
    }
}