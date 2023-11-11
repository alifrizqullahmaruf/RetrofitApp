package com.example.retrofitapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Object for API configuration
object ApiConfig {
    // Base URL of the API
    const val baseURL = "https://rickandmortyapi.com/api/"

    // Function to get Retrofit instance
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)  // Set the base URL
            .addConverterFactory(GsonConverterFactory.create())  // Use GsonConverterFactory to convert JSON
            .build()
    }

    // Function to get an instance of ApiService
    fun getService(): ApiService {
        return getRetrofit().create(ApiService::class.java)  // Create an instance of ApiService from Retrofit
    }
}

