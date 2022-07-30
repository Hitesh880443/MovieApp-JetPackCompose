package com.hitesh.movieapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.hitesh.movieapp.model.Movie
import com.hitesh.movieapp.util.MOCK_MOVIE_LIST

@Composable
fun HeaderLabel(header: String) {
    Text(
        text = header,
        style = MaterialTheme.typography.h6,
        modifier = Modifier.padding(vertical = 4.dp)
    )
}


@Composable
fun MovieRow(movie: Movie = MOCK_MOVIE_LIST[0], onItemClick: (Movie) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(top = 8.dp)
            .clickable {
                onItemClick.invoke(movie)
            },
        shape = RoundedCornerShape(12.dp),
        elevation = 4.dp

    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(8.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(movie.image)
                    .crossfade(true)
                    .build(),
                contentDescription = "${movie.title} thumbnail",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = movie.title ?: "NA",
                maxLines = 1,
                modifier = Modifier.padding(start = 8.dp),
                style = MaterialTheme.typography.h6
            )
        }
    }
}