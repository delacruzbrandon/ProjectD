package com.brand.projectd.ui.screens.favorites

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.brand.projectd.R
import com.brand.projectd.ui.theme.TopAppBarContentColor
import com.brand.projectd.util.Action

@Composable
fun FavoriteAppBar(
    onDeleteAllClicked: (Action) -> Unit,
    onBackClicked: (Action) -> Unit
) {
    StorageAppBar(
        onDeleteAllClicked = onDeleteAllClicked,
        onBackClicked = onBackClicked
    )
}


@Composable
fun StorageAppBar(
    onDeleteAllClicked: (Action) -> Unit,
    onBackClicked: (Action) -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.text_favorites_appbar_title),
                color = MaterialTheme.colors.TopAppBarContentColor
            )
        },
        navigationIcon =  {
            IconButton (
                onClick = { onBackClicked(Action.NO_ACTION) },
                modifier = Modifier
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.icon_back_button)
                )
            }
        },
        actions = {
            DeleteAllAction(
                onDeleteAllClicked = {}
            )
        }
    )
}

@Composable
fun DeleteAllAction(
    onDeleteAllClicked: (Action) -> Unit
) {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = "Appbar Delete Icon"
        )
    }
}

@Composable
@Preview
fun PreviewFavoriteAppBar() {
    FavoriteAppBar(
        {},
        {}
    )
}
