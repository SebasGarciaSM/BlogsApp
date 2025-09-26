package com.example.blogsapp.ui.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.blogsapp.ui.viewmodels.HomeViewModel

@Composable
fun HomeView(
    viewModel: HomeViewModel
) {
    val blogs = remember { viewModel.blogs }
    LaunchedEffect(Unit) {
        viewModel.getBlogs()
    }

    Scaffold { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            items(blogs) { blog ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ) {
                    Text(blog.title, fontSize = 24.sp)
                    AsyncImage(
                        modifier = Modifier.fillMaxWidth(),
                        model = blog.photoUrl,
                        contentScale = ContentScale.Crop,
                        contentDescription = null
                    )
                }
            }
        }
    }
}