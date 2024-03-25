package com.example.messagemanager.data

import com.example.messagemanager.presentation.URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {


    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val messageApi: MessageService by lazy {
        retrofit.create(MessageService::class.java)
    }
}