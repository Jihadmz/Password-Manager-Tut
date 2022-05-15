package com.example.passwordmanager.feature_password.presentation.add_edit_password

import androidx.compose.ui.focus.FocusState

sealed class AddEditPasswordEvent{
    data class EnteringService(val value: String): AddEditPasswordEvent()
    data class ChangeServiceFocus(val value: FocusState): AddEditPasswordEvent()
    data class EnteringPassword(val value: String): AddEditPasswordEvent()
    data class ChangePasswordFocus(val value: FocusState): AddEditPasswordEvent()
    data class EnteringUserName(val value: String): AddEditPasswordEvent()
    data class ChangeUserNameFocus(val value: FocusState): AddEditPasswordEvent()
    data class EnteringNotes(val value: String): AddEditPasswordEvent()
    data class ChangeNotesFocus(val value: FocusState): AddEditPasswordEvent()
    object SavePassword: AddEditPasswordEvent()
}
