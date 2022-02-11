package com.brand.projectd.ui.screens.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.brand.projectd.ui.viewmodels.SharedViewModel
import com.brand.projectd.util.Action

@Composable
fun ListScreen (
    taskScreen: (Int) -> Unit,
    favoritesScreen: (Action) -> Unit,
    sharedViewModel: SharedViewModel
) {
    LaunchedEffect(key1 = true) {
        sharedViewModel.setTrackList()
    }

    val allTracks by sharedViewModel.trackList.collectAsState()

    /** TODO
     * Pass shareViewModel
     * to TopAppBar's
     * and decide from there what to display
     */
    Scaffold(
        topBar = {
            ListAppBar(
                navigateToFavoritesScreen = favoritesScreen

            )
        },
        content = {
            ListContent(
                navigateToTrackScreen = taskScreen,
                trackList = allTracks
            )
        }
    )

}