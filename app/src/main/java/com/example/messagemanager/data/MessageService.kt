package com.example.messagemanager.data

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT


interface MessageService {

    @GET("posts")
    suspend fun getData(): List<MessageDataItem>

    @POST("posts")
    suspend fun putData(@Body messages: List<MessageDataItem>)

}