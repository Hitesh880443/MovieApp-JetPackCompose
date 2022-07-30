package com.hitesh.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.hitesh.movieapp.model.MovieDetails
import com.hitesh.movieapp.model.MovieListResponse
import com.hitesh.movieapp.model.TempDataHolder.movieDetails
import com.hitesh.movieapp.model.TempDataHolder.movieListResponse
import com.hitesh.movieapp.navigation.MovieNavigation
import com.hitesh.movieapp.ui.theme.MovieAppJetpackComposeTheme
import com.hitesh.movieapp.util.readRawJsonFile

const val TAG = "Movie App"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        readRawJsonFile<MovieListResponse>(R.raw.movie_list_mock, this)?.let {
            movieListResponse = it
        }

        readRawJsonFile<MovieDetails>(R.raw.movie_details_mock, this)?.let {
            movieDetails = it
        }

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

