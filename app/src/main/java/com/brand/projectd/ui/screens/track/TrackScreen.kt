package com.brand.projectd.ui.screens.track

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.brand.projectd.data.models.Track
import com.brand.projectd.ui.screens.components.TopAppBar
import com.brand.projectd.ui.viewmodels.SharedViewModel
import com.brand.projectd.util.Action
import com.brand.projectd.util.RequestState

@Composable
fun TrackScreen(
    trackId: Int,
    sharedViewModel: SharedViewModel,
    listScreen: (Action) -> Unit
) {
    LaunchedEffect(key1 = true) {
        /** TODO
         * Pass ID to track screen
         * Use ID to query selected track
         * Find a way if you can use [Flow]
         */
//        sharedViewModel.getTrack(trackId = trackId)
        sharedViewModel.getTest()
    }

    val selectedTrack by sharedViewModel.selectedTrack.collectAsState()

    val test by sharedViewModel.selectedTrack.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar()
        },
        content = {
            TrackContent(
                test,
                navigateTo = listScreen
            )
        }
    )
}