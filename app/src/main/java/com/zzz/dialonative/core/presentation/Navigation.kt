package com.zzz.dialonative.core.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.zzz.dialonative.core.presentation.components.BottomNavBar
import com.zzz.dialonative.core.presentation.util.Screen
import com.zzz.dialonative.feature_contact.presentation.create_contact.CreateContactRoot
import com.zzz.dialonative.feature_contact.presentation.dial.DialPageRoot
import com.zzz.dialonative.feature_contact.presentation.home.HomePageRoot
import com.zzz.dialonative.feature_contact.presentation.home.components.DialFab
import com.zzz.dialonative.feature_contact.presentation.recents.RecentCallsRoot
import com.zzz.dialonative.ui.theme.darkBackground

@Composable
fun Navigation(

) {
    val navController = rememberNavController()

    var navBarVisible by remember() {
        mutableStateOf(true)
    }
    var navBarHeight by remember { mutableStateOf(0.dp) }
    val density = LocalDensity.current


    /*
    Scaffold(
        containerColor = darkBackground,
        bottomBar = {
            AnimatedVisibility(
                navBarVisible,
            ) {

                BottomNavBar(navController)
            }
        }
    )
     */
    Box(
        modifier  = Modifier.fillMaxSize()
            .background(darkBackground)
            .statusBarsPadding()
            .navigationBarsPadding(),
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.RecentScreen,
            modifier = Modifier,
//            enterTransition = {
//                EnterTransition.None
//            },
//            exitTransition ={
//                ExitTransition.None
//            },

        ) {
            //CREATE
            composable<Screen.CreateContactScreen>(
            ) {
                val data = it.toRoute<Screen.CreateContactScreen>()
                navBarVisible = false
                CreateContactRoot(
                    phone = data.phone,
                    cancel = {
                        println("CLOSE")
                        navController.navigateUp()
                    }
                )
            }
            //HOME
            composable<Screen.HomeScreen>(

            ) {

                navBarVisible = true
                HomePageRoot()
            }
            //RECENT SCREEN
            composable<Screen.RecentScreen>(

            ) {
                navBarVisible = true
                RecentCallsRoot()
            }

            //DIAL
            composable<Screen.DialScreen>(
/*                enterTransition = {
//                    slideIntoContainer(
//                        towards = AnimatedContentTransitionScope.SlideDirection.Up,
//                        animationSpec = tween(400)
//                    )
//                },
//                exitTransition = {
//                    slideOutOfContainer(
//                        towards = AnimatedContentTransitionScope.SlideDirection.Down,
//                        animationSpec = tween(400)
//                    )
//                },

 */
            ) {
                navBarVisible = false
                DialPageRoot(
                    onNavToCreate = {phone->
                        navController.navigate(Screen.CreateContactScreen(phone))
                    }
                )
            }
        }
        AnimatedVisibility(
            navBarVisible,
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {

            BottomNavBar(
                navController ,
                onHeightCalculated = {height->
                    navBarHeight = with(density){
                        height.toDp()
                    }
                }
            )
        }
        if(navBarVisible){
            DialFab(
                onClick = {
                    navController.navigate(Screen.DialScreen)
                },
                size = 50.dp,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(start = 16.dp,end = 16.dp, bottom = navBarHeight + 16.dp)
            )
        }
    }
}