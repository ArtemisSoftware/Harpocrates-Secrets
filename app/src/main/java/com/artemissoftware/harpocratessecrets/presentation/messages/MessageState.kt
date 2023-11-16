package com.artemissoftware.harpocratessecrets.presentation.messages

import com.artemissoftware.harpocratessecrets.domain.models.Message

data class MessageState(
    val showDialog: Boolean = false,
    val authorized: Boolean = false,
    val messages: List<Message> = emptyList()
)
