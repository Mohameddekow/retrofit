package com.example.retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.model.Post
import com.example.retrofit.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {


    var myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    var myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
    var myCustomPost: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    var myCustomPost2: MutableLiveData<Response<List<Post>>> = MutableLiveData()


/*** to know more of this functions refer to SimpleApi.kt file  ****/
    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response

        }
    }

    fun getPost2(number: Int) {
        viewModelScope.launch {
            val response = Repository().getPost2(number)
            myResponse2.value = response

        }
    }

    fun getCustomPost(
        number: Int,
        sort: String,
        order: String
    ) {
        viewModelScope.launch {
            val response = Repository().getCustomPost(number, sort, order)
          myCustomPost.value = response
        }
    }

    fun getCustomPost2(
        number: Int,
        option: Map<String, String>
    ) {
        viewModelScope.launch {
            val response = Repository().getCustomPost2(number, option)
            myCustomPost2.value = response
        }
    }

    //creating a POST request //// with POST annotation retrofit will send data in form of JSON format to the server by default


    fun pushPost(
        post: Post
    ){
        viewModelScope.launch {
            val response = repository.pushPost(post)
            myResponse.value = response
        }
    }


    //this fun still create a post request by with @FormUrlEncoded annotation the retrofit will send data in form `key and value separated by &` of to the server

    fun pushPost2(
        userId: Int,
        id: Int,
        title: String,
        body: String
        ){
        viewModelScope.launch {
            val response = repository.pushPost2(userId, id, title, body)
            myResponse.value = response
        }
    }
}