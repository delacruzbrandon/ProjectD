package com.brand.projectd.ui.screens.track

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.brand.projectd.ui.theme.TopAppBarContentColor
import com.brand.projectd.util.Action
import com.brand.projectd.util.Action.NO_ACTION

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
            IconButton (
                onClick = { onBackClicked(NO_ACTION) },
                modifier = Modifier
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back IconButton"
                )
            }
        },
        actions = {
            LikeAction(
                onLikeClicked = onLikeClicked
            )

        }
    )
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

