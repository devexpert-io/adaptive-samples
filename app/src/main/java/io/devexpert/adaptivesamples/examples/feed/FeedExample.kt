package io.devexpert.adaptivesamples.examples.feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowWidthSizeClass
import io.devexpert.adaptivesamples.ui.theme.AdaptiveSamplesTheme

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun FeedExample() {
    val windowInfo = currentWindowAdaptiveInfo()
    val columns = when (windowInfo.windowSizeClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> 1
        WindowWidthSizeClass.MEDIUM -> 2
        WindowWidthSizeClass.EXPANDED -> 3
        else -> 1
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(
            items = sampleFeedItems,
            span = { item ->
                GridItemSpan(
                    if (item.type == FeedItemType.FEATURED) maxLineSpan else 1
                )
            }
        ) { item ->
            FeedCard(
                item = item,
                modifier = Modifier.height(
                    if (item.type == FeedItemType.FEATURED) 200.dp else 150.dp
                )
            )
        }
    }
}

@Composable
private fun FeedCard(
    item: FeedItem,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = item.title,
                style = if (item.type == FeedItemType.FEATURED) {
                    MaterialTheme.typography.headlineMedium
                } else {
                    MaterialTheme.typography.titleMedium
                }
            )
            Text(
                text = item.subtitle,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

private val sampleFeedItems = listOf(
    FeedItem(
        id = 1,
        title = "Featured Article",
        subtitle = "This is a featured article that spans across all columns. It contains important information that should be highlighted.",
        type = FeedItemType.FEATURED
    ),
    FeedItem(
        id = 2,
        title = "Regular Post 1",
        subtitle = "This is a regular post that adapts to the grid layout."
    ),
    FeedItem(
        id = 3,
        title = "Regular Post 2",
        subtitle = "Another regular post showing different content in the feed."
    ),
    FeedItem(
        id = 4,
        title = "Regular Post 3",
        subtitle = "More content to demonstrate the grid layout adaptation."
    ),
    FeedItem(
        id = 5,
        title = "Featured Update",
        subtitle = "Another featured item that spans all columns to highlight important information or updates.",
        type = FeedItemType.FEATURED
    ),
    FeedItem(
        id = 6,
        title = "Regular Post 4",
        subtitle = "Continuing with regular content in the feed."
    ),
    FeedItem(
        id = 7,
        title = "Regular Post 5",
        subtitle = "More items to show how the grid adjusts to different screen sizes."
    ),
    FeedItem(
        id = 8,
        title = "Regular Post 6",
        subtitle = "Additional content to demonstrate scrolling behavior."
    )
)

@Preview(showBackground = true)
@Composable
private fun FeedExamplePreview() {
    AdaptiveSamplesTheme {
        FeedExample()
    }
} 