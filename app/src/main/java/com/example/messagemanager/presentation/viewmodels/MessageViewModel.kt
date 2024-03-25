package com.example.messagemanager.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.messagemanager.data.MessageDataItem
import com.example.messagemanager.domain.MessageRepository
import com.example.messagemanager.domain.MessageRepositoryImpl
import kotlinx.coroutines.launch

class MessageViewModel(private val repository: MessageRepositoryImpl): ViewModel() {


    private val _messageList = MutableLiveData<List<MessageDataItem>>()
    val messageList: LiveData<List<MessageDataItem>> get() = _messageList

    private fun getData() {
        viewModelScope.launch {
            _messageList.postValue(repository.getData())
        }
    }

    fun postData(messages: List<MessageDataItem>) {
        viewModelScope.launch {
            repository.postData(messages)
            getData()
        }
    }

    init {
        getData()
    }

}


class MessageViewModelFactory(private val repository: MessageRepositoryImpl) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MessageViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MessageViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}