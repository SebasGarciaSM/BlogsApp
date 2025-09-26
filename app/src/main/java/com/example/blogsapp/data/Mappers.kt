package com.example.blogsapp.data

import com.example.blogsapp.data.models.BlogResponse
import com.example.blogsapp.domain.models.BlogModel

fun BlogResponse.toDomain(): BlogModel = BlogModel(
    userId = userId,
    title = title,
    contentText = contentText,
    photoUrl = photoUrl,
    createdAt = createdAt,
    id = id,
    description = description,
    category = category,
)