package com.example.blogsapp.data.services

import com.example.blogsapp.data.models.PostsResponse
import retrofit2.Response
import retrofit2.http.GET

interface BlogApiService {

    @GET("sample-data/blog-posts")
    suspend fun getPosts(): Response<PostsResponse>

}