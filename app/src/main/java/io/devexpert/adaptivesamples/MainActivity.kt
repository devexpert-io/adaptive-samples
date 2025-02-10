package io.devexpert.adaptivesamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import io.devexpert.adaptivesamples.examples.windowsize.WindowSizeClassesExample
import io.devexpert.adaptivesamples.ui.theme.AdaptiveSamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdaptiveSamplesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WindowSizeClassesExample(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}