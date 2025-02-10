package io.devexpert.adaptivesamples.examples.feed

data class FeedItem(
    val id: Int,
    val title: String,
    val subtitle: String,
    val type: FeedItemType = FeedItemType.NORMAL
)

enum class FeedItemType {
    FEATURED, // Featured item that spans the full width
    NORMAL    // Regular item that fits into the grid
} 