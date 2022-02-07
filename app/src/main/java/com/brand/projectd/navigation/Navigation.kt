package com.brand.projectd.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.brand.projectd.navigation.destinations.listComposable
import com.brand.projectd.navigation.destinations.trackComposable
import com.brand.projectd.ui.viewmodels.SharedViewModel
import com.brand.projectd.util.Constants.LIST_SCREEN

@Composable
fun SetNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(
            trackScreen = screen.trackItem,
            sharedViewModel = sharedViewModel
        )
        trackComposable(
            listScreen = screen.trackList,
            sharedViewModel = sharedViewModel
        )
    }
}