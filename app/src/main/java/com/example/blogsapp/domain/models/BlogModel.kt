package com.example.blogsapp.domain.models

import com.google.gson.annotations.SerializedName

data class BlogModel(
    val userId: String,
    val title: String,
    val contentText: String,
    val photoUrl: String,
    val createdAt: String,
    val id: String,
    val description: String,
    val category: String,
)
