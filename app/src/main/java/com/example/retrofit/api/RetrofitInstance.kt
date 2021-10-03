package com.example.retrofit.api

import com.example.retrofit.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    //let call our intercept to intercept our retrofit calls
    val client = OkHttpClient.Builder().apply {
        addInterceptor(MyIntercepter())
    }.build()

    //build the retrofit
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
                //let call out client fun at this point
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    //create the api through the retrofit
     val api:SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }


}