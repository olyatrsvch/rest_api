package com.example.messagemanager.domain

import com.example.messagemanager.data.MessageDataItem

interface MessageRepository {

    suspend fun getData(): List<MessageDataItem>

    suspend fun postData(messages: List<MessageDataItem>)

}