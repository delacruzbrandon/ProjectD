package com.brand.projectd.ui.screens.track

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.brand.projectd.ui.viewmodels.SharedViewModel
import com.brand.projectd.util.Action

@Composable
fun TrackScreen(
    trackId: Int,
    sharedViewModel: SharedViewModel,
    listScreen: (Action) -> Unit
) {
    LaunchedEffect(key1 = true) {
        /** TODO
         * Find a way if you can use [Flow]
         */
        sharedViewModel.setSelectedTrack(trackId)
    }

    val test by sharedViewModel.selectedTrack.collectAsState()

    Scaffold(
        topBar = {
            TrackAppBar(
                onLikeClicked = {},
                onBackClicked = listScreen
            )
        },
        content = {
            TrackContent(test)
        }
    )
}