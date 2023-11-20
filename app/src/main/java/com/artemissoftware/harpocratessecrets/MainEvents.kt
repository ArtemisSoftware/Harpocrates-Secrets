package com.artemissoftware.harpocratessecrets

import androidx.appcompat.app.AppCompatActivity

sealed class MainEvents {

    data class Authorize(val activity: AppCompatActivity) : MainEvents()
    data object RevokeAuthorization : MainEvents()
}
