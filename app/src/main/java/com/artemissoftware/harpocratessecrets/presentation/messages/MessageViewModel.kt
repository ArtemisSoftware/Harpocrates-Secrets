package com.artemissoftware.harpocratessecrets.presentation.messages

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemissoftware.harpocratessecrets.domain.models.Message
import com.artemissoftware.harpocratessecrets.domain.repository.MessageRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MessageViewModel constructor(private val messageRepository: MessageRepository) : ViewModel() {

    private val _state = MutableStateFlow(MessageState())
    val state = _state.asStateFlow()

    init {
        getAll()
    }

    fun onTriggerEvent(events: MessageEvents) {
        when (events) {
            is MessageEvents.Delete -> {
                delete(events.message)
            }
            is MessageEvents.Insert -> {
                insert(events.message)
            }
            is MessageEvents.ShowDialog -> {
                showDialog(events.show)
            }
        }
    }

    private fun insert(message: String) {
        viewModelScope.launch {
            messageRepository.insert(message = message)
        }
    }

    private fun getAll() {
        viewModelScope.launch {
            messageRepository.getAll().collect { result ->
                _state.update {
                    it.copy(
                        messages = result.reversed(),
                    )
                }
            }
        }
    }

    private fun delete(message: Message) {
        viewModelScope.launch {
            messageRepository.delete(message)
        }
    }

    private fun showDialog(show: Boolean) = with(_state) {
        update {
            it.copy(showDialog = show)
        }
    }
}
