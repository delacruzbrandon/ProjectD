package com.brand.projectd.ui.screens.list

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import com.brand.projectd.R
import com.brand.projectd.data.models.Track
import com.brand.projectd.ui.theme.*
import com.brand.projectd.util.RequestState

@Composable
fun ListContent (
    trackList: RequestState<List<Track>>
) {
    if (trackList is RequestState.Success) {
        if (trackList.data.isEmpty()) {
            Log.d("TAG", "ListContent: ${trackList.data}")
        } else {
            DisplayTrackList(trackList = trackList.data)
            Log.d("TAG", "ListContent: ${trackList.data}")
        }
    }
}

@Composable
private fun DisplayTrackList(
    trackList: List<Track>
) {
    LazyColumn {
        items(
            items = trackList,
            key = { track -> track.id}
        ) { track ->
            TrackItem(track = track)
        }
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun TrackItem(
    track: Track
) {

    Log.d("TAG", "TrackItem: $track")
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = MaterialTheme.colors.TrackItemBackgroundColor,
        shape = RoundedCornerShape(IMAGE_ROUND_CORNER),
        elevation = TRACK_ELEVATION,
        onClick = { }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(MaterialTheme.colors.background)
                .padding(all = TRACK_PADDING)
        ) {
            Image(
                modifier = Modifier
                    .size(TRACK_SIZE_LARGE)
                    .clip(RoundedCornerShape(IMAGE_ROUND_CORNER)),
                painter = rememberImagePainter(data = track.image),
                contentDescription = stringResource(id = R.string.track_image),
            )
            Column(
                modifier = Modifier
                    .padding(start = TRACK_PADDING)
                    .height(TRACK_SIZE_LARGE)
            ) {
                Text(
                    text = track.name,
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.TrackItemTextColor,
                    maxLines = 1,
                )
                Text(
                    modifier = Modifier
                        .weight(4f)
                        .alpha(.4f)
                        .fillMaxWidth(),
                    text = track.genre,
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.TrackItemTextColor,
                    maxLines = 1,
                )
                Text(
                    modifier = Modifier
                        .wrapContentSize()
                        .weight(1f)
                        .align(Alignment.End),
                    text = track.price,
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.TrackItemPriceColor,
                )
                Box(

                ) {

                }

            }
        }
    }


}


@Composable
@Preview
private fun PreviewTrackItem() {
    TrackItem(
        track = Track(
            643978126,
            "Star Trek Into Darkness",
            "",
            "$12.99",
            "Sci-Fi & Fantasy"

        )
    )
}