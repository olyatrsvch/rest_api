package com.example.messagemanager.presentation

import android.app.Application
import com.example.messagemanager.domain.MessageRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MessageManagerApp: Application() {

    private val applicationScope = CoroutineScope(SupervisorJob())
}