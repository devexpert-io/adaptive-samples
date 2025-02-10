package io.devexpert.adaptivesamples.examples.listdetail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Message(
    val id: Int,
    val title: String,
    val preview: String,
    val content: String
) : Parcelable

val sampleMessages = listOf(
    Message(
        id = 1,
        title = "Welcome to Adaptive UI",
        preview = "Learn how to create adaptive layouts...",
        content = """
            Welcome to Adaptive UI in Jetpack Compose!
            
            This example demonstrates how to implement a list-detail pattern that adapts to different screen sizes:
            
            - Compact: Shows either list or detail
            - Medium: Can show both list and detail side by side
            - Expanded: Shows both list and detail side by side
            
            Try rotating your device or resizing the window to see how the layout adapts.
        """.trimIndent()
    ),
    Message(
        id = 2,
        title = "Material Design 3",
        preview = "Discover the latest Material Design guidelines...",
        content = """
            Material Design 3 is the latest version of Google's design system.
            
            It introduces new components and patterns that help create more expressive and adaptable user interfaces.
            
            Key features include:
            - Dynamic color
            - Updated typography
            - New component states
            - Improved accessibility
        """.trimIndent()
    ),
    Message(
        id = 3,
        title = "Jetpack Compose Tips",
        preview = "Best practices for Compose development...",
        content = """
            Here are some tips for developing with Jetpack Compose:
            
            1. Use remember and rememberSaveable wisely
            2. Leverage Compose's state hoisting pattern
            3. Keep composables focused and reusable
            4. Use proper layout modifiers
            5. Implement proper navigation patterns
            
            Following these practices will help you create maintainable and performant apps.
        """.trimIndent()
    )
) 