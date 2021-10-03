package com.example.retrofit.api

import com.example.retrofit.model.Post
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {

    //create all the function of the api. GET, PUT, POST, PITCH,DELETE
    @GET("posts/1")
    suspend fun getPost(): Response<Post>

    //using path
    @GET("posts/{postNumber}")
    suspend fun getPost2(@Path("postNumber") number: Int): Response<Post>

    //using multiple query
    @GET("posts")
    suspend fun getCustomPost(
        @Query("userId" ) number: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<Post>>

    //using HashMap to make multiple queries
    @GET("posts")
    suspend fun getCustomPost2(
        @Query("userId") number: Int,
        @QueryMap options: Map<String, String>

    ):Response<List<Post>>

    //creating a POST request //// with POST annotation retrofit will send data in form of JSON format to the server by default
    @POST("posts")
    suspend fun pushPost(
        @Body post: Post
    ):Response<Post>

    //this fun still create a post request by with @FormUrlEncoded annotation the retrofit will send data in form `key and value separated by &` of to the server
    @FormUrlEncoded
    @POST("posts")
    suspend fun pushPost2(
        @Field("userId") userId: Int,
        @Field("id") id: Int,
        @Field("title") title: String,
        @Field("body") body: String,
    ):Response<Post>


}