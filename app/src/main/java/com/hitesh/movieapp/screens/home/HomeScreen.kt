package com.hitesh.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hitesh.movieapp.R
import com.hitesh.movieapp.TAG
import com.hitesh.movieapp.components.HeaderLabel
import com.hitesh.movieapp.components.MovieRow
import com.hitesh.movieapp.model.Movie
import com.hitesh.movieapp.model.TempDataHolder
import com.hitesh.movieapp.navigation.MovieScreens


@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                elevation = 4.dp,
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    ) {

        MainContent(navController = navController, TempDataHolder.movieListResponse?.results)

    }
}

@Composable
fun MainContent(navController: NavController, movieList: List<Movie>?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        HeaderLabel(stringResource(R.string.all_movie))

        movieList?.let {
            LazyColumn {
                items(items = it) {
                    MovieRow(it) { movie ->
                        Log.d(TAG, "MainContent: $movie")
                        navController.navigate(route = MovieScreens.DetailsScreen.name + "/${movie.id}")
                    }
                }
            }

        }
    }
}

