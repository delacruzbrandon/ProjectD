package com.brand.projectd.ui.screens.list

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.brand.projectd.R
import com.brand.projectd.ui.theme.*
import com.brand.projectd.util.Action
import com.brand.projectd.util.Action.NO_ACTION

@Composable
fun ListAppBar(
    navigateToFavoritesScreen: (action: Action) -> Unit,
) {
    DefaultAppBar(
        onFavoritesClicked = navigateToFavoritesScreen
    )
}

@Composable
fun DefaultAppBar(
    onFavoritesClicked: (Action) -> Unit
) {
    TopAppBar (
        title = {
            Text(
                text = stringResource(id = R.string.text_default_appbar_title),
                color = MaterialTheme.colors.TopAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.TopAppBarBackgroundColor,
        actions = {
            GoToFavoritesAction(
                onFavoritesClicked = onFavoritesClicked
            )
        }
    )
}

@Composable
fun GoToFavoritesAction(
    onFavoritesClicked: (Action) -> Unit
) {
    IconButton(
        onClick = {
            onFavoritesClicked(NO_ACTION)
        }) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = "Appbar Favorites Icon"
        )
    }
}


@Composable
@Preview
fun PreviewDefaultAppBar() {
    DefaultAppBar(
        onFavoritesClicked = {}
    )
}

