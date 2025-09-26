package com.example.blogsapp.data.models

import com.google.gson.annotations.SerializedName

data class PostsResponse(
    @SerializedName("success") val success: String,
    @SerializedName("total_blogs") val totalBlogs: String,
    @SerializedName("message") val message: String,
    @SerializedName("offset") val offset: String,
    @SerializedName("limit") val limit: String,
    @SerializedName("blogs") val blogs: List<BlogResponse>
)
