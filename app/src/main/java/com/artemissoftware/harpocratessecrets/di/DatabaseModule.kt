package com.artemissoftware.harpocratessecrets.di

import androidx.room.Room
import com.artemissoftware.harpocratessecrets.data.database.HarpocratesSecretsDataBase
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room
            .databaseBuilder(
                get(),
                HarpocratesSecretsDataBase::class.java,
                "secret",
            )
            .build()
    }

    single { get<HarpocratesSecretsDataBase>().messageDao() }
}
