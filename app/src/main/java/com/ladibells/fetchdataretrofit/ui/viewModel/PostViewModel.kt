package com.ladibells.fetchdataretrofit.ui.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ladibells.fetchdataretrofit.data.api.RetrofitInstance
import com.ladibells.fetchdataretrofit.data.models.Post
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {
    private val _posts = mutableStateOf<List<Post>>(emptyList())
    val posts: State<List<Post>> = _posts

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            try {
                val posts = RetrofitInstance.api.getPosts()
                _posts.value = posts
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}