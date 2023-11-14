package com.artemissoftware.harpocratessecrets.data.mappers

import com.artemissoftware.harpocratessecrets.data.database.entities.MessageEntity
import com.artemissoftware.harpocratessecrets.domain.models.Message

fun MessageEntity.toMessage(): Message{
    return Message(
        id = id,
        message = message,
    )
}