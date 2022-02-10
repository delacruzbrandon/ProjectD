package com.brand.projectd.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.brand.projectd.navigation.destinations.listComposable
import com.brand.projectd.navigation.destinations.trackComposable
import com.brand.projectd.ui.viewmodels.SharedViewModel
import com.brand.projectd.util.Constants.LIST_SCREEN

@Composable
fun SetNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {


    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route.toString()

    sharedViewModel.passCurrentScreen(currentDestination)

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