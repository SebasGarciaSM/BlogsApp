package com.example.blogsapp.di.modules

import com.example.blogsapp.data.repositories.BlogRepository
import com.example.blogsapp.domain.interfaces.IBlogRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindBlogRepository(impl: BlogRepository): IBlogRepository

}