package com.brand.projectd.ui.screens.track

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.brand.projectd.R
import com.brand.projectd.data.models.Track
import com.brand.projectd.ui.theme.TRACK_DETAILS_PADDING_LARGE
import com.brand.projectd.util.Action

@Composable
fun TrackContent(
    track: Track,
    navigateTo: (Action) -> Unit
) {
    DisplayTrackContent(
        track = track,
        navigateTo = navigateTo
    )
}


@Composable
fun DisplayTrackContent(
    track: Track,
    navigateTo: (Action) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = TRACK_DETAILS_PADDING_LARGE)
            .background(MaterialTheme.colors.background)
    ) {
        Image(
            painter = rememberImagePainter(data = track.image),
            contentDescription = stringResource(id = R.string.track_image)
        )
    }
}