package com.example.blogsapp.data.repositories

import com.example.blogsapp.data.models.BlogResponse
import com.example.blogsapp.data.services.BlogApiService
import com.example.blogsapp.data.toDomain
import com.example.blogsapp.domain.interfaces.IBlogRepository
import com.example.blogsapp.domain.models.BlogModel
import javax.inject.Inject

class BlogRepository @Inject constructor(
    private val api: BlogApiService
) : IBlogRepository {

    override suspend fun getAllBlogs(): List<BlogModel> {
        return try {
            val listOfBlogs = mutableListOf<BlogModel>()
            val response = api.getPosts()

            if (response.isSuccessful) {
                val blogs = response.body()?.blogs

                if (blogs != null) {
                    for (blog in blogs) {
                        listOfBlogs.add(
                            blog.toDomain()
                        )
                    }
                }
            }

            listOfBlogs
        } catch (e: Exception) {
            println(e.toString())
            emptyList<BlogModel>()
        }
    }

}