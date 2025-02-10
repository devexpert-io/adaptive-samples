package io.devexpert.adaptivesamples.examples.listdetail

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.BackNavigationBehavior
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3AdaptiveApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ListDetailExample() {
    val scaffoldNavigator = rememberListDetailPaneScaffoldNavigator<Message>()
    val selectedMessage = scaffoldNavigator.currentDestination?.content

    BackHandler(enabled = scaffoldNavigator.canNavigateBack()) {
        scaffoldNavigator.navigateBack(BackNavigationBehavior.PopUntilContentChange)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(selectedMessage?.title ?: "List Detail Example") },
                navigationIcon = {
                    if (scaffoldNavigator.canNavigateBack()) {
                        IconButton(
                            onClick = {
                                scaffoldNavigator.navigateBack(BackNavigationBehavior.PopUntilContentChange)
                            }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                }
            )
        }
    ) {
        ListDetailPaneScaffold(
            directive = scaffoldNavigator.scaffoldDirective,
            value = scaffoldNavigator.scaffoldValue,
            listPane = {
                AnimatedPane(Modifier.preferredWidth(320.dp)) {
                    MessageList(
                        messages = sampleMessages,
                        selectedMessage = selectedMessage,
                        onMessageSelected = { message ->
                            scaffoldNavigator.navigateTo(
                                pane = ListDetailPaneScaffoldRole.Detail,
                                content = message
                            )
                        }
                    )
                }
            },
            detailPane = {
                AnimatedPane(Modifier.fillMaxSize()) {
                    MessageDetail(message = selectedMessage)
                }
            },
            modifier = Modifier.padding(it)
        )
    }
} 