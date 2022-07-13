package com.hitesh.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.hitesh.movieapp.navigation.MovieNavigation
import com.hitesh.movieapp.ui.theme.MovieAppJetpackComposeTheme

const val TAG = "Movie App"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MovieNavigation()
            }
        }
    }
}


@Composable
fun MyApp(content: @Composable () -> Unit) {
    MovieAppJetpackComposeTheme {
        content()
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MovieNavigation()
    }
}