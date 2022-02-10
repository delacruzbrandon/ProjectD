package com.brand.projectd.ui.screens.track

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import com.brand.projectd.R
import com.brand.projectd.data.models.Track
import com.brand.projectd.ui.screens.components.EmptyContent
import com.brand.projectd.ui.screens.components.LoadingContent
import com.brand.projectd.ui.theme.TRACK_DETAILS_PADDING_LARGE
import com.brand.projectd.ui.theme.TrackItemPriceColor
import com.brand.projectd.ui.theme.TrackItemTextColor
import com.brand.projectd.ui.theme.TrackItemTextSubtitleColor
import com.brand.projectd.util.Action
import com.brand.projectd.util.RequestState

@Composable
fun TrackContent(
    track: RequestState<Track>
) {
    if (track is RequestState.Success) {
        DisplayTrackContent(
            track = track.data
        )
    } else if (track is RequestState.Loading || track is RequestState.Idle){
        LoadingContent()
    } else {
        EmptyContent()
    }

}

@Composable
fun DisplayTrackContent(
    track: Track
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .verticalScroll(rememberScrollState())
    ) {

        Log.d("TAG", "DisplayTrackContent: $track")

        /** Track Details Cover Photo */
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            painter = rememberImagePainter(data = track.image),
            contentDescription = stringResource(id = R.string.image_track_thumbnail)
        )

        Column(
            modifier = Modifier
                .padding(all = TRACK_DETAILS_PADDING_LARGE)
        ) {

            /** Track Details Title */
            Text(
                text = track.name,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.TrackItemTextColor,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                /** Track Details Genre */
                Text(
                    modifier = Modifier
                        .weight(1f),
                    text = track.genre,
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.TrackItemTextSubtitleColor,

                    )

                /** Track Details Price */
                Text(
                    modifier = Modifier
                        .weight(1f),
                    text = "$${track.price}",
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.TrackItemPriceColor,
                    textAlign = TextAlign.End
                )
            }

            /** Track Details Body */
            Text(
                modifier = Modifier.padding(top = TRACK_DETAILS_PADDING_LARGE),
                text = if (track.description.isNullOrBlank()) "No Description." else track.description,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.TrackItemTextColor,
            )
        }
    }
}

@Composable
@Preview
fun PreviewDisplayTrackContent() {
    DisplayTrackContent(
        track = Track(
            0,
            "Title",
            "Title",
            "",
            "$12.99" ,
            "Rock and Roll"
        )
    )
}