package com.brand.projectd.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.brand.projectd.ui.screens.list.ListScreen
import com.brand.projectd.ui.viewmodels.SharedViewModel
import com.brand.projectd.util.Constants.LIST_ARGUMENT_KEY
import com.brand.projectd.util.Constants.LIST_SCREEN

fun NavGraphBuilder.listComposable(
    trackScreen: (Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) {
        ListScreen(
            sharedViewModel = sharedViewModel,
            taskScreen = trackScreen
        )

    }

}