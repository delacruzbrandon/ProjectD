package com.brand.projectd.ui.screens.track

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import coil.compose.rememberImagePainter
import com.brand.projectd.data.models.Track
import com.brand.projectd.ui.screens.list.ListContent
import com.brand.projectd.ui.viewmodels.SharedViewModel
import com.brand.projectd.util.Action

// TODO
@Composable
fun TrackScreen(
    sharedViewModel: SharedViewModel,
    listScreen: (Action) -> Unit
) {
//    LaunchedEffect(keys1 = true) {
//
//    }

    Scaffold(
        topBar = {

        },
        content = {
            TrackContent(
                track = Track(208510932, "", "", "", ""),
                navigateTo = listScreen
            )
        }
    )

}