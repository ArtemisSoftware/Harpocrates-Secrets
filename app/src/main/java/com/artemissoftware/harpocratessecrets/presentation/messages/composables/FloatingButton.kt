package com.artemissoftware.harpocratessecrets.presentation.messages.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FloatingButton(
    authorized: Boolean,
    onAuthorize: () -> Unit,
    onOpenDialog: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        AnimatedVisibility(visible = !authorized) {
            FloatingActionButton(
                onClick = onAuthorize,
                containerColor = MaterialTheme.colorScheme.primary,
                content = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null,
                        tint = Color.White,
                    )
                },
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        FloatingActionButton(
            onClick = onOpenDialog,
            containerColor = MaterialTheme.colorScheme.primary,
            content = {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = Color.White,
                )
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FloatingButton_authorized_Preview() {
    FloatingButton(
        authorized = true,
        onAuthorize = {},
        onOpenDialog = {},
    )
}

@Preview(showBackground = true)
@Composable
private fun FloatingButton_not_authorized_Preview() {
    FloatingButton(
        authorized = false,
        onAuthorize = {},
        onOpenDialog = {},
    )
}
