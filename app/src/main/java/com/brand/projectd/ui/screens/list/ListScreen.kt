package com.brand.projectd.ui.screens.list

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.brand.projectd.ui.viewmodels.SharedViewModel
import com.brand.projectd.util.RequestState

@Composable
fun ListScreen (
    sharedViewModel: SharedViewModel
) {
    LaunchedEffect(key1 = true) {
        sharedViewModel.getApis()
    }

    val allTracks by sharedViewModel.trackList.collectAsState()
    Log.d("TAG", "ListScreen: $allTracks")


    Scaffold(
        topBar = {

        },
        content = {
            ListContent(
                allTracks
            )
        }
    )

}