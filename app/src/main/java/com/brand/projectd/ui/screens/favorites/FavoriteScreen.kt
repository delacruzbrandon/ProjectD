package com.brand.projectd.ui.screens.favorites

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.brand.projectd.data.models.Track
import com.brand.projectd.util.RequestState

@Composable
fun FavoriteScreen(
) {

    val trackListTest: RequestState<List<Track>> =  RequestState.Success(listOf(
        Track(
            643978126,
            "Star Trek Into Darkness",
            "",
            "",
            "12.99",
            "Sci-Fi & Fantasy"

        ),Track(
            643978123,
            "Star Trek Into Darkness",
            "",
            "",
            "12.99",
            "Sci-Fi & Fantasy"

        ),Track(
            643978124,
            "Star Trek Into Darkness",
            "",
            "",
            "12.99",
            "Sci-Fi & Fantasy"

        )
    ))

    Scaffold(
        topBar = {
            FavoriteAppBar(
                onDeleteAllClicked = {},
                onBackClicked = {}
            )
        },
        content = {
            FavoriteContent(
                trackList = trackListTest,
                navigateToTrackScreen = {}
            )
        }
    )
}

@Composable
@Preview
fun PreviewFavoriteScreen() {
    FavoriteScreen()
}