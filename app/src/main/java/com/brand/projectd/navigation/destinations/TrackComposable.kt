package com.brand.projectd.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.brand.projectd.ui.screens.track.TrackScreen
import com.brand.projectd.ui.viewmodels.SharedViewModel
import com.brand.projectd.util.Action
import com.brand.projectd.util.Constants.TRACK_ARGUMENT_KEY
import com.brand.projectd.util.Constants.TRACK_SCREEN

fun NavGraphBuilder.trackComposable(
    listScreen: (Action) -> Unit,
    sharedViewModel: SharedViewModel
    ) {
    composable(
        route = TRACK_SCREEN,
        arguments = listOf(navArgument(TRACK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) { backStackEntry ->
        val trackId = backStackEntry.arguments!!.getInt(TRACK_ARGUMENT_KEY)

        TrackScreen(
            trackId = trackId,
            sharedViewModel = sharedViewModel,
            listScreen = listScreen
        )

    }
}