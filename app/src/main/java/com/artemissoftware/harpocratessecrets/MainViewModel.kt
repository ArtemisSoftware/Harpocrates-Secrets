package com.artemissoftware.harpocratessecrets

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.artemissoftware.harpocratessecrets.presentation.utils.BiometricHelper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {

    private val _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    fun onTriggerEvent(events: MainEvents) {
        when (events) {
            is MainEvents.Authorize -> {
                authorize(events.activity)
            }
            MainEvents.RevokeAuthorization -> {
                updateAuthorization(false)
            }
        }
    }

    private fun authorize(activity: AppCompatActivity) {
        BiometricHelper.showPrompt(activity) {
            updateAuthorization(true)
        }
    }

    private fun updateAuthorization(authorized: Boolean) = with(_state) {
        update {
            it.copy(authorized = authorized)
        }
    }
}
