package com.example.passwordmanager.feature_password.presentation.passwords

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.passwordmanager.feature_password.presentation.passwords.components.PasswordItem
import com.example.passwordmanager.feature_password.presentation.util.Screens

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PasswordsScreen(
    navController: NavController,
    viewModel: PasswordsViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Screens.AddEditPasswordScreen.route)
            }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Password")
            }
        }
    ) {

        val passwords = viewModel.passwordsState.value

        LazyColumn{
            itemsIndexed(
                passwords.passwords,
                key = { _, password -> password.hashCode() }
            ){ _, password ->

                PasswordItem(
                    modifier = Modifier.animateItemPlacement(),
                    password = password,
                    onDeleteClick = {
                        viewModel.onEvent(PasswordsEvents.DeletePassword(password))
                    },
                    onItemClick = {
                        navController.navigate(Screens.AddEditPasswordScreen.route + "?passwordId=${password.id}")
                    }
                )

                Spacer(modifier = Modifier.height(20.dp))
            }
        }

    }
}