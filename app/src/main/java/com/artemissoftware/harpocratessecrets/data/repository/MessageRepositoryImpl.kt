package com.artemissoftware.harpocratessecrets.data.repository

import com.artemissoftware.harpocratessecrets.data.database.dao.MessageDao
import com.artemissoftware.harpocratessecrets.data.database.entities.MessageEntity
import com.artemissoftware.harpocratessecrets.data.mappers.toEntity
import com.artemissoftware.harpocratessecrets.data.mappers.toMessage
import com.artemissoftware.harpocratessecrets.domain.models.Message
import com.artemissoftware.harpocratessecrets.domain.repository.MessageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MessageRepositoryImpl(private val messageDao: MessageDao) : MessageRepository {
    override suspend fun insert(message: String) {
        messageDao.insert(MessageEntity(message = message))
    }

    override suspend fun delete(message: Message) {
        messageDao.delete(message.toEntity())
    }

    override fun getAll(): Flow<List<Message>> {
        return messageDao.getMessages().map { messages -> messages.map { it.toMessage() } }
    }
}
