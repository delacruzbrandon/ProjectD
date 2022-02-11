package com.brand.projectd.navigation

import androidx.navigation.NavHostController
import com.brand.projectd.util.Action
import com.brand.projectd.util.Constants.LIST_SCREEN

class Screens(navController: NavHostController) {

    /** Go to TrackList composable and kill TrackItem composable */
    val trackList: (Action) -> Unit = { action ->
        navController.popBackStack()
    }
    /** Only go to TrackItem Composable */
    val favoritesList: (Action) -> Unit = { action ->
        navController.navigate(route = "favoritesList/$action")
    }

    /** Only go to TrackItem Composable */
    val trackItem: (Int) -> Unit = { trackId ->
        navController.navigate(route = "trackItem/$trackId")
    }
}