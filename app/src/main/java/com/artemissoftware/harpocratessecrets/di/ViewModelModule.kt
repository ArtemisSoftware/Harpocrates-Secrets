package com.artemissoftware.harpocratessecrets.di

import com.artemissoftware.harpocratessecrets.presentation.messages.MessageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MessageViewModel(get()) }
}
