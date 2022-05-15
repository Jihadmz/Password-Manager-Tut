package com.example.passwordmanager.feature_password.presentation.add_edit_password.components

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.TextStyle

@Composable
fun CustomTextField(
    text: String,
    hint: String,
    isHintVisible: Boolean,
    textStyle: TextStyle = TextStyle(),
    onFocusChange: (FocusState) -> Unit,
    onTextChange: (String) -> Unit,
    leadingIcon: @Composable () -> Unit,
) {

    TextField(
        value = text,
        onValueChange = onTextChange,
        textStyle = textStyle,
        leadingIcon = leadingIcon,
        modifier = Modifier.onFocusChanged {
            onFocusChange(it)
        },
        label = {
//            if (isHintVisible) Text(text = hint) else
//                Text(text = "")
            Text(text = hint)
        },
    )
}