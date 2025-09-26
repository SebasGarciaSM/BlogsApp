package com.example.blogsapp.domain.interfaces

import com.example.blogsapp.domain.models.BlogModel

interface IBlogRepository {

    suspend fun getAllBlogs(): List<BlogModel>

}