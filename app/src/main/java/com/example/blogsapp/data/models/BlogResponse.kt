package com.example.blogsapp.data.models

import com.google.gson.annotations.SerializedName

data class BlogResponse(
    @SerializedName("user_id") val userId: String,
    @SerializedName("title") val title: String,
    @SerializedName("content_text") val contentText: String,
    @SerializedName("photo_url") val photoUrl: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("id") val id: String,
    @SerializedName("description") val description: String,
    @SerializedName("category") val category: String,
)
