package com.ladibells.fetchdataretrofit.data.api

import com.ladibells.fetchdataretrofit.data.models.Post
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): List<Post>

}