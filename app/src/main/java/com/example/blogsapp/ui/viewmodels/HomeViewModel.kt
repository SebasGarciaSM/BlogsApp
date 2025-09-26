package com.example.blogsapp.ui.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blogsapp.domain.interfaces.IBlogRepository
import com.example.blogsapp.domain.models.BlogModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: IBlogRepository
) : ViewModel() {

    private val _blogs = mutableStateListOf<BlogModel>()
    val blogs: List<BlogModel> get() = _blogs


    fun getBlogs() {
        try {
            viewModelScope.launch {
                val results = repository.getAllBlogs()
                _blogs.addAll(results)
            }

        } catch (e: Exception) {
            print(e.toString())
        }
    }


}