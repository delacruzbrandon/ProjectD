package com.brand.projectd.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.brand.projectd.data.models.Track
import com.brand.projectd.ui.screens.track.TrackScreen
import com.brand.projectd.util.Constants.TRACK_ARGUMENT_KEY
import com.brand.projectd.util.Constants.TRACK_SCREEN

fun NavGraphBuilder.trackComposable(
    track: Track,
    listScreen: () -> Unit
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
            navigateTo = listScreen
        )

    }
}