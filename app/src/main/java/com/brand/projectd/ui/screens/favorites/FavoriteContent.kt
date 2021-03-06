package com.brand.projectd.ui.screens.favorites

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import com.brand.projectd.R
import com.brand.projectd.data.models.Track
import com.brand.projectd.ui.screens.components.EmptyContent
import com.brand.projectd.ui.screens.components.LoadingContent
import com.brand.projectd.ui.theme.*
import com.brand.projectd.util.RequestState

@Composable
fun FavoriteContent(
    trackList: RequestState<List<Track>>,
    navigateToTrackScreen: (trackId: Int) -> Unit
) {

    if (trackList is RequestState.Success) {
        if (trackList.data.isEmpty()) {
            EmptyContent()
        } else {
            DisplayFavoriteList(
                trackList = trackList.data,
                navigateToTrackScreen = navigateToTrackScreen
            )
        }
    } else if (trackList is RequestState.Loading || trackList is RequestState.Idle){
        LoadingContent()
    }
}

@Composable
private fun DisplayFavoriteList(
    trackList: List<Track>,
    navigateToTrackScreen: (trackId: Int) -> Unit
) {

    LazyColumn {
        items(
            items = trackList,
            key = { track -> track.id}
        ) { track ->
            FavoriteItem(
                track = track,
                navigateToTrackScreen = navigateToTrackScreen
            )
        }
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun FavoriteItem(
    track: Track,
    navigateToTrackScreen: (trackId: Int) -> Unit
) {

    Surface(
        modifier = Modifier
            .padding(
                vertical = TRACK_ITEM_PADDING_MEDIUM,
                horizontal = TRACK_ITEM_PADDING_LARGE
            )
            .fillMaxWidth(),
        color = MaterialTheme.colors.background,
        shape = RoundedCornerShape(TRACK_ITEM_IMAGE_ROUND_CORNER),
        elevation = TRACK_ITEM_ELEVATION,
        onClick = { navigateToTrackScreen(track.id) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = TRACK_ITEM_PADDING_MEDIUM)
                .wrapContentHeight()
        ) {

            Image(
                modifier = Modifier
                    .size(TRACK_ITEM_SIZE_LARGE)
                    .clip(RoundedCornerShape(TRACK_ITEM_IMAGE_ROUND_CORNER)),
                painter = rememberImagePainter(
                    data = track.image,
                    builder = {
                        crossfade(true)
                        placeholder(R.drawable.ic_mage)
                    }
                ),
                contentDescription = stringResource(id = R.string.image_track_thumbnail),
            )

            Column(
                modifier = Modifier
                    .padding(start = TRACK_ITEM_PADDING_LARGE)
                    .height(TRACK_ITEM_SIZE_LARGE)
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
                        .weight(1f),
                    text = "$${track.price}",
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
    FavoriteItem(
        track = Track(
            643978126,
            "Star Trek Into Darkness",
            "",
            "",
            "$12.99",
            "Sci-Fi & Fantasy"

        ),
        navigateToTrackScreen = {}
    )
}