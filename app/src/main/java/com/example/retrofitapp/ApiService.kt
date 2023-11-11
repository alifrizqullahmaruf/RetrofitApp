package com.example.retrofitapp

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

// Interface to define API service endpoints
interface ApiService {
    @GET("character")
    fun getRick(): Call<ResponseRick>
}

