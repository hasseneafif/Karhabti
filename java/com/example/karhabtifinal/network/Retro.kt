package com.example.karhabtifinal.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retro {
    fun getRetroClientInstance(): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl("http://192.168.43.19:3000/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}