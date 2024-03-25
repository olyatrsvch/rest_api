package com.example.messagemanager.domain

import android.util.Log
import com.example.messagemanager.data.ApiFactory
import com.example.messagemanager.data.MessageService
import com.example.messagemanager.data.MessageDataItem
import com.example.messagemanager.presentation.URL
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MessageRepositoryImpl: MessageRepository {

    private val retrofit = ApiFactory.messageApi

    override suspend fun getData() =
        retrofit.getData()

    override suspend fun postData(messages: List<MessageDataItem>) {
        retrofit.putData(messages)
    }
}