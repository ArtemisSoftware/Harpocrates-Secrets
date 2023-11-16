package com.artemissoftware.harpocratessecrets.presentation.messages.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MessageItem(
    message: String,
    authorized: Boolean,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val blurValue by animateDpAsState(
        targetValue = if (authorized) 0.dp else 15.dp,
        animationSpec = tween(500),
        label = "",
    )

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp)
            .blur(
                radius = blurValue,
                edgeTreatment = BlurredEdgeTreatment.Unbounded,
            ),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(text = message)
            AnimatedVisibility(visible = authorized) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        onDelete()
                    },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MessageItem_authorized_Preview() {
    MessageItem(
        message = "I am a message",
        authorized = true,
        onDelete = {},
        modifier = Modifier.fillMaxWidth(),
    )
}

@Preview(showBackground = true)
@Composable
private fun MessageItem_not_authorized_Preview() {
    MessageItem(
        message = "I am a message",
        authorized = false,
        onDelete = {},
        modifier = Modifier.fillMaxWidth(),
    )
}
