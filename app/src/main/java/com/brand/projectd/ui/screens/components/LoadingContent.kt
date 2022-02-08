package com.brand.projectd.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.brand.projectd.R
import com.brand.projectd.ui.theme.LOADING_CONTENT_ICON_SIZE

@Composable
fun LoadingContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            modifier = Modifier.size(LOADING_CONTENT_ICON_SIZE),
            painter = painterResource(id = R.drawable.ic_hourglass),
            contentDescription = stringResource(id = R.string.image_loading_icon),
            tint = Color.LightGray
        )
        Text(
            text = stringResource(id = R.string.text_loading_content),
            color = Color.LightGray,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h6.fontSize
        )
    }
}

@Composable
@Preview
fun PreviewLoadingContent() {
    LoadingContent()
}