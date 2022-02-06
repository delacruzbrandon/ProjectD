package com.brand.projectd.navigation

import androidx.navigation.NavHostController
import com.brand.projectd.util.Action
import com.brand.projectd.util.Constants.LIST_SCREEN

class Screens(navController: NavHostController) {

    /** Go to TrackList composable and kill TrackItem composable */
    val trackList: (Action) -> Unit = { action ->
        navController.navigate(route = "trackList/$action") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    /** Only go to TrackItem Composable */
    val trackItem: (Int) -> Unit = { trackId ->
        navController.navigate(route = "trackItem/$trackId")
    }
}