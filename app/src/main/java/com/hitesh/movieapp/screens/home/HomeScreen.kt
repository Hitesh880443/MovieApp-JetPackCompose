package com.hitesh.movieapp.screens.home

import android.util.Log
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hitesh.movieapp.TAG
import com.hitesh.movieapp.navigation.MovieScreens
import com.hitesh.movieapp.util.MOCK_MOVIE_LIST

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Gray,
                elevation = 4.dp,
            ) {
                Text(
                    text = "Movie App",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    ) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(navController: NavController, movieList: List<String> = MOCK_MOVIE_LIST) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(it) { movie ->
                    Log.d(TAG, "MainContent: $movie")
                    navController.navigate(route = MovieScreens.DetailsScreen.name)
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