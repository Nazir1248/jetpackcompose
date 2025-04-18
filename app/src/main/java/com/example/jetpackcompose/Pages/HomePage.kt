package com.example.jetpackcompose.Pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetpackcompose.AuthState
import com.example.jetpackcompose.AuthViewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.MutableLiveData
import androidx.navigation.compose.rememberNavController

//@Composable
//fun HomePage(modifier: Modifier=Modifier, navController: NavHostController, authViewModel: AuthViewModel){
//
//    val authState = authViewModel.authState.observeAsState()
//
//    LaunchedEffect(authState.value) {
//        when(authState.value){
//            is AuthState.Unauthenticated -> {navController.navigate("Login")}
//            else -> Unit
//        }
//    }
//    Column (modifier = modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    )
//    {
//        Text(text = "Home Page",fontSize =32.sp)
//        TextButton(onClick = {
//            authViewModel.signout()
//        }) {
//            Text(text = "Sign Out")
//        }
//    }
//}

@Composable
fun HomePage(modifier: Modifier = Modifier, navController: NavHostController, authViewModel: AuthViewModel) {

    val authState = authViewModel.authState.observeAsState()

    LaunchedEffect(authState.value) {
        when(authState.value) {
            is AuthState.Unauthenticated -> { navController.navigate("Login") }
            is AuthState.Authenticated -> { navController.navigate("dashboard") }
            else -> Unit
        }
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Home Page", fontSize = 32.sp)
        TextButton(onClick = {
            authViewModel.signout()
        }) {
            Text(text = "Sign Out")
        }
    }
}