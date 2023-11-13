package com.artemissoftware.harpocratessecrets.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.artemissoftware.harpocratessecrets.data.database.dao.MessageDao
import com.artemissoftware.harpocratessecrets.data.database.entities.MessageEntity

@Database(
    entities = [
        MessageEntity::class,
    ],
    version = 1,
)
abstract class HarpocratesSecretsDataBase : RoomDatabase() {
    abstract fun messageDao(): MessageDao
}
