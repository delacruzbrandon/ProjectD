package com.brand.projectd.ui.screens.components

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.brand.projectd.R
import com.brand.projectd.ui.theme.*

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
@Preview
fun PreviewDefaultAppBar() {
    DefaultAppBar()
}

