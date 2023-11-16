package com.artemissoftware.harpocratessecrets.presentation.messages

import android.widget.Toast
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.harpocratessecrets.R
import com.artemissoftware.harpocratessecrets.domain.models.Message
import com.artemissoftware.harpocratessecrets.presentation.messages.composables.FloatingButton
import com.artemissoftware.harpocratessecrets.presentation.messages.composables.MessageItem

@Composable
fun MessageScreen() {
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun MessageScreenContent(
    state: MessageState,
    events: (MessageEvents) -> Unit,
) {
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingButton(
                authorized = state.authorized,
                onAuthorize = {
                },
                onOpenDialog = {
                    if (state.authorized) {
                        events.invoke(MessageEvents.ShowDialog(show = true))
                    } else {
                        Toast.makeText(
                            context,
                            R.string.unlock_app,
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                },
            )
        },
    ) { paddings ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddings),
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(
                    items = state.messages,
                    key = { it.id },
                ) { message ->
                    MessageItem(
                        modifier = Modifier
                            .animateItemPlacement(animationSpec = tween(500))
                            .fillMaxWidth(),
                        message = message.text,
                        authorized = state.authorized,
                        onDelete = {
                            events.invoke(MessageEvents.Delete(message = message))
                        },
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MessageScreenContent_authorized_Preview() {
    MessageScreenContent(
        state = MessageState(
            authorized = true,
            messages = listOf(Message(id = 1, text = "I am text one"), Message(id = 2, text = "I am text two")),
        ),
        events = {},
    )
}

@Preview(showBackground = true)
@Composable
private fun MessageScreenContent_not_authorized_Preview() {
    MessageScreenContent(
        state = MessageState(
            authorized = false,
            messages = listOf(Message(id = 1, text = "I am text one"), Message(id = 2, text = "I am text two")),
        ),
        events = {},
    )
}
