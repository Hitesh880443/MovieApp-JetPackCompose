package com.hitesh.movieapp.screens.details

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.hitesh.movieapp.R
import com.hitesh.movieapp.components.BasicLabel1
import com.hitesh.movieapp.components.ChipRow
import com.hitesh.movieapp.components.HeaderLabel
import com.hitesh.movieapp.model.MovieDetails
import com.hitesh.movieapp.model.TempDataHolder

@Composable
fun DetailsScreen(navController: NavController, movie: String?) {

    Scaffold(
        topBar = {
            TopAppBar(
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
        DetailsContent(movieDetails = TempDataHolder.movieDetails)
    }
}

@Composable
fun DetailsContent(movieDetails: MovieDetails?) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        movieDetails?.let { movie ->
            Column(
                modifier = Modifier
                    .padding(all = 16.dp)

            ) {
                HeaderLabel(
                    header = movie.title ?: stringResource(R.string.something_went_wrong)
                )
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(movie.image)
                        .crossfade(true)
                        .build(),
                    contentDescription = "${movie.title} thumbnail",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )

                movie.genre?.let { genreList ->
                    ChipRow(genreList)
                }

                BasicLabel1(
                    movie.plot.toString()
                )

                BasicLabel1(
                    "Rating : ${movie.rating?.star ?: 0}"
                )

                BasicLabel1(
                    "Director : ${movie.directors?.joinToString(separator = ", ") { it.toString() }}"
                )

                BasicLabel1(
                    "Top cast: ${movie.actors?.joinToString(separator = ", ") { it.toString() }}"
                )

                movie.imdb?.let {
                    val context = LocalContext.current
                    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(it)) }

                    Button(
                        onClick = { context.startActivity(intent) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)

                    ) {
                        Text(text = stringResource(R.string.go_to_imdb))
                    }
                }
            }

        }
    }
}

