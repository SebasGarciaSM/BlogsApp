package com.example.blogsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.blogsapp.data.repositories.BlogRepository
import com.example.blogsapp.data.services.BlogApiService
import com.example.blogsapp.domain.interfaces.IBlogRepository
import com.example.blogsapp.ui.theme.BlogsAppTheme
import com.example.blogsapp.ui.viewmodels.HomeViewModel
import com.example.blogsapp.ui.views.HomeView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.slingacademy.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(BlogApiService::class.java)

        setContent {
            BlogsAppTheme {
                HomeView(
                    viewModel = HomeViewModel(
                        repository = BlogRepository(
                            apiService
                        )
                    )
                )
            }
        }
    }
}