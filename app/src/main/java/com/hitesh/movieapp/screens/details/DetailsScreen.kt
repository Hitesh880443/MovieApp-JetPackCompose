package com.hitesh.movieapp.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hitesh.movieapp.R
import com.hitesh.movieapp.components.HeaderLabel
import com.hitesh.movieapp.model.MovieDetails

@Composable
fun DetailsScreen(navController: NavController, movie: String?) {

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                elevation = 4.dp,
            ) {
                Row(horizontalArrangement = Arrangement.Start) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(R.string.back_button),
                        modifier = Modifier
                            .padding(4.dp)
                            .clickable {
                                navController.popBackStack()
                            },
                    )
                    Text(
                        text = stringResource(R.string.movie_details),
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )

                }
            }
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                HeaderLabel(header = movie ?: "Something Went Wrong")
            }
        }

    }
}

@Composable
fun DetailsContent(navController: NavController, movieDetails: MovieDetails) {

}