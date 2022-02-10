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
import com.brand.projectd.ui.viewmodels.SharedViewModel
import com.brand.projectd.util.Action
import com.brand.projectd.util.Constants.LIST_SCREEN
import com.brand.projectd.util.Constants.TRACK_SCREEN

@Composable
fun ListAppBar() {
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
fun ActionsTrackAppBar() {}


@Composable
@Preview
fun PreviewDefaultAppBar() {
    DefaultAppBar()
}

