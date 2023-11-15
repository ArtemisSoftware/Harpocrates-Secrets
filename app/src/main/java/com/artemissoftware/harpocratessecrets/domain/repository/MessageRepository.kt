package com.artemissoftware.harpocratessecrets.domain.repository

import com.artemissoftware.harpocratessecrets.domain.models.Message
import kotlinx.coroutines.flow.Flow

interface MessageRepository {

    suspend fun insert(message: String)

    suspend fun delete(message: Message)

    fun getAll(): Flow<List<Message>>
}
