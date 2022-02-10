package com.brand.projectd.ui.screens.track

import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.brand.projectd.R
import com.brand.projectd.ui.theme.TopAppBarBackgroundColor
import com.brand.projectd.ui.theme.TopAppBarContentColor
import com.brand.projectd.util.Action

@Composable
fun TrackAppBar(
    onLikeClicked: (Action) -> Unit,
    onBackClicked: (Action) -> Unit
) {
    DetailsAppBar(
        onLikeClicked = onLikeClicked,
        onBackClicked = onBackClicked
    )
}

@Composable
fun DetailsAppBar(
    onLikeClicked: (Action) -> Unit,
    onBackClicked: (Action) -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "Details",
                color = MaterialTheme.colors.TopAppBarContentColor
            )
        },
        navigationIcon =  {
            Icon(
                modifier = Modifier.clickable { /*TODO*/ },
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Appbar Back Icon",
            )
        },
        actions = {
            ActionsTrackAppBar(
                onLikeClicked = { /*TODO*/ }
            )
        }
    )
}

@Composable
fun ActionsTrackAppBar(
    onLikeClicked: (Action) -> Unit
) {
    LikeAction(onLikeClicked = onLikeClicked)
}

@Composable
fun LikeAction(
    onLikeClicked: (Action) -> Unit
) {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            imageVector = Icons.Filled.Favorite,
            contentDescription = "Appbar Like Icon"
        )
    }
}

@Composable
@Preview
fun PreviewTrackAppBar() {
    DetailsAppBar(
        onLikeClicked = {},
        onBackClicked = {}
    )
}

