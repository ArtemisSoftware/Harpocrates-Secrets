package com.artemissoftware.harpocratessecrets.di

import com.artemissoftware.harpocratessecrets.data.repository.MessageRepositoryImpl
import com.artemissoftware.harpocratessecrets.domain.repository.MessageRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<MessageRepository> { MessageRepositoryImpl(get()) }
}
