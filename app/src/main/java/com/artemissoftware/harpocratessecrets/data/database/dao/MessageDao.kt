package com.artemissoftware.harpocratessecrets.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.artemissoftware.harpocratessecrets.data.database.entities.MessageEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MessageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(message: MessageEntity)

    @Query("SELECT * FROM messages")
    fun getMessages(): Flow<List<MessageEntity>>

    @Delete
    suspend fun delete(message: MessageEntity)
}
