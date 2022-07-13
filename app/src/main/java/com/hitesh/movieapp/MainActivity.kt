package com.hitesh.movieapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hitesh.movieapp.ui.theme.MovieAppJetpackComposeTheme
import com.hitesh.movieapp.util.MOCK_MOVIE_LIST

const val TAG = "Movie App"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainContent()
            }
        }
    }
}


@Composable
fun MyApp(content: @Composable () -> Unit) {
    MovieAppJetpackComposeTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = Color.Gray,
                    elevation = 4.dp
                ) {
                    Text(text = "Movie App")
                }
            }
        ) {
            content()
        }
    }

}

@Composable
fun MainContent(movieList: List<String> = MOCK_MOVIE_LIST) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(it) { movie ->
                    Log.d(TAG, "MainContent: $movie")
                }
            }
        }
    }
}

@Composable
fun MovieRow(movie: String, onItemClick: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(top = 8.dp)
            .clickable {
                onItemClick.invoke(movie)
            },
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp),
                imageVector = Icons.Default.Person,
                contentDescription = "Movie Icon"
            )
            Text(text = movie)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MainContent()
    }
}