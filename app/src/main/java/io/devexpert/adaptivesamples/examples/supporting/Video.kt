package io.devexpert.adaptivesamples.examples.supporting

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Video(
    val id: Int,
    val title: String,
    val description: String,
    val thumbnailUrl: String,
    val duration: String,
    val views: String,
    val uploadDate: String,
    val channel: String
) : Parcelable

val currentVideo = Video(
    id = 1,
    title = "Introduction to Jetpack Compose",
    description = """
        Learn the basics of Jetpack Compose, Android's modern toolkit for building native UI.
        
        In this comprehensive guide, we'll cover:
        - Composable functions
        - State management
        - Layouts and modifiers
        - Material Design components
        - Best practices and patterns
        
        Perfect for beginners and experienced developers alike!
    """.trimIndent(),
    thumbnailUrl = "https://example.com/thumb1.jpg",
    duration = "10:30",
    views = "1.2M views",
    uploadDate = "2 months ago",
    channel = "Android Developers"
)

val recommendedVideos = listOf(
    Video(
        id = 2,
        title = "Material Design 3 in Action",
        description = "Discover how to implement Material Design 3 components in your Android app.",
        thumbnailUrl = "https://example.com/thumb2.jpg",
        duration = "8:45",
        views = "856K views",
        uploadDate = "1 month ago",
        channel = "Material Design"
    ),
    Video(
        id = 3,
        title = "Adaptive UI Patterns",
        description = "Learn how to create UIs that adapt to different screen sizes and orientations.",
        thumbnailUrl = "https://example.com/thumb3.jpg",
        duration = "15:20",
        views = "543K views",
        uploadDate = "3 weeks ago",
        channel = "Android Developers"
    ),
    Video(
        id = 4,
        title = "State Management in Compose",
        description = "Deep dive into state management patterns in Jetpack Compose.",
        thumbnailUrl = "https://example.com/thumb4.jpg",
        duration = "12:15",
        views = "432K views",
        uploadDate = "5 days ago",
        channel = "Kotlin Official"
    ),
    Video(
        id = 5,
        title = "Custom Layouts in Compose",
        description = "Learn how to create custom layouts for complex UIs in Compose.",
        thumbnailUrl = "https://example.com/thumb5.jpg",
        duration = "18:30",
        views = "321K views",
        uploadDate = "1 week ago",
        channel = "Android Developers"
    )
)