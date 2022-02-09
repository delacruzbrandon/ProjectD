package com.brand.projectd.ui.screens.components

import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.brand.projectd.R
import com.brand.projectd.ui.theme.*
import com.brand.projectd.util.Action

@Composable
fun TopAppBar() {
    DefaultAppBar()
}

@Composable
fun DefaultAppBar(
) {
    TopAppBar (
        title = {
            Text(
                text = stringResource(id = R.string.text_appbar_title),
                color = MaterialTheme.colors.TopAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.TopAppBarBackgroundColor
    )
}

@Composable
fun DetailsAppBar(
    onBackClicked: () -> Unit,
    onLikeClicked: (Action) -> Unit
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
                modifier = Modifier.clickable { onBackClicked },
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Appbar Back Icon",
            )
        },
        actions = {
            ActionsListAppBar(
                onLikeClicked = onLikeClicked
            )
        }
    )
}

@Composable
fun ActionsListAppBar(
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
fun PreviewDetailsAppBar() {
    DetailsAppBar(
        onBackClicked = {},
        onLikeClicked = {}
    )
}

@Composable
@Preview
fun PreviewDefaultAppBar() {
    DefaultAppBar()
}

