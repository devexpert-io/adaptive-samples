package io.devexpert.adaptivesamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import io.devexpert.adaptivesamples.examples.listdetail.ListDetailExample
import io.devexpert.adaptivesamples.ui.theme.AdaptiveSamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdaptiveSamplesTheme {
                ListDetailExample()
            }
        }
    }
}