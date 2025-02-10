package io.devexpert.adaptivesamples.examples.supporting

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.PaneAdaptedValue
import androidx.compose.material3.adaptive.layout.SupportingPaneScaffold
import androidx.compose.material3.adaptive.layout.SupportingPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.rememberSupportingPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3AdaptiveApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SupportingPaneExample() {
    val scaffoldNavigator = rememberSupportingPaneScaffoldNavigator()

    BackHandler(scaffoldNavigator.canNavigateBack()) {
        scaffoldNavigator.navigateBack()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Video Detail") }
            )
        }
    ) { padding ->
        SupportingPaneScaffold(
            directive = scaffoldNavigator.scaffoldDirective,
            value = scaffoldNavigator.scaffoldValue,
            mainPane = {
                AnimatedPane(Modifier.fillMaxSize()) {
                    Column {
                        if (scaffoldNavigator.scaffoldValue[SupportingPaneScaffoldRole.Supporting] == PaneAdaptedValue.Hidden) {
                            Button(
                                modifier = Modifier.wrapContentSize(),
                                onClick = {
                                    scaffoldNavigator.navigateTo(SupportingPaneScaffoldRole.Supporting)
                                }
                            ) {
                                Text("Show Recommended Videos")
                            }
                        }
                        VideoPlayer(video = currentVideo)
                    }
                }
            },
            supportingPane = {
                AnimatedPane(Modifier.fillMaxSize()) {
                    RecommendedVideos(videos = recommendedVideos)
                }
            },
            modifier = Modifier.padding(padding)
        )
    }
} 