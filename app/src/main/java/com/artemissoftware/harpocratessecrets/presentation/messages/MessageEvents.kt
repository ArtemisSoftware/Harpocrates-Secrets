package com.artemissoftware.harpocratessecrets.presentation.messages

import com.artemissoftware.harpocratessecrets.domain.models.Message

sealed class MessageEvents {

    data class Insert(val message: String) : MessageEvents()

    data class Delete(val message: Message) : MessageEvents()

    data class ShowDialog(val show: Boolean) : MessageEvents()
}
