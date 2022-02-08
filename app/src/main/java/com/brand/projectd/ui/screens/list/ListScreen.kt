package com.brand.projectd.ui.screens.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.brand.projectd.ui.screens.components.TopAppBar
import com.brand.projectd.ui.viewmodels.SharedViewModel

@Composable
fun ListScreen (
    sharedViewModel: SharedViewModel,
    taskScreen: (Int) -> Unit
) {
    LaunchedEffect(key1 = true) {
        sharedViewModel.getTrackList()
    }

    val allTracks by sharedViewModel.trackList.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar()
        },
        content = {
            ListContent(
                allTracks,
                navigateToTrackScreen = taskScreen
            )
        }
    )

}