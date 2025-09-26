package com.example.blogsapp.data.repositories

import com.example.blogsapp.data.services.BlogApiService
import com.example.blogsapp.domain.interfaces.IBlogRepository
import com.example.blogsapp.domain.models.BlogModel

class BlogRepository(
    private val api: BlogApiService
) : IBlogRepository {

    override suspend fun getAllBogs(): List<BlogModel> {
        return try {
            val listOfBlogs = mutableListOf<BlogModel>()
            val response = api.getPosts()

            if (response.isSuccessful) {
                val blogs = response.body()?.blogs

                if (blogs != null) {
                    for (blog in blogs) {
                        listOfBlogs.add(
                            BlogModel(
                                userId = blog.userId,
                                title = blog.title,
                                contentText = blog.contentText,
                                photoUrl = blog.photoUrl,
                                createdAt = blog.createdAt,
                                id = blog.id,
                                description = blog.description,
                                category = blog.category
                            )
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