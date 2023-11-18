package com.artemissoftware.harpocratessecrets.presentation.messages.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.artemissoftware.harpocratessecrets.R

@Composable
fun MessageDialog(
    secretMessage: String,
    onValueChange: (String) -> Unit,
    onAddMessage: () -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Dialog(
        onDismissRequest = onDismiss,
        content = {
            Box(
                modifier = modifier,
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(16.dp),
                ) {
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = secretMessage,
                        onValueChange = onValueChange,
                        label = {
                            Text(text = stringResource(R.string.secret_message))
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = null,
                            )
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.White,
                            focusedLeadingIconColor = Color.White,
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color(0xffcccccc),
                            unfocusedLeadingIconColor = Color(0xffcccccc),
                            unfocusedBorderColor = Color(0xffcccccc),
                            focusedTextColor = Color.White,
                        ),
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = onAddMessage,
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.secondary,
                        ),
                        shape = RoundedCornerShape(12.dp),
                        content = {
                            Text(text = stringResource(R.string.add), color = Color.White)
                        },
                    )
                }
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun MessageDialogPreview() {
    MessageDialog(
        modifier = Modifier.fillMaxSize(),
        secretMessage = "My secret message",
        onDismiss = {},
        onAddMessage = {},
        onValueChange = { _ -> },
    )
}
