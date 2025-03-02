//package com.example.jetpackcompose
//
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.jetpackcompose.Pages.HomePage
//import com.example.jetpackcompose.Pages.LoginPage
//import com.example.jetpackcompose.Pages.SignUpPages
//
//@Composable
//fun MyAppNavigation(modifier: Modifier=Modifier, authViewModel: AuthViewModel){
//    val navController = rememberNavController()
//
//    NavHost(navController = navController , startDestination = "Login",builder = {
//         composable("Login"){
//             LoginPage(modifier,navController,authViewModel)
//         }
//        composable("signup"){
//            SignUpPages(modifier,navController,authViewModel)
//        }
//        composable("home"){
//            HomePage(modifier,navController,authViewModel)
//        }
//    })
//}


//
//package com.example.jetpackcompose
//
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.jetpackcompose.Pages.HomePage
//import com.example.jetpackcompose.Pages.LoginPage
//import com.example.jetpackcompose.Pages.SignUpPages
//
//@Composable
//fun MyAppNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
//    val navController = rememberNavController()
//
//    NavHost(navController = navController, startDestination = "Login", builder = {
//        composable("Login") {
//            LoginPage(modifier, navController, authViewModel)
//        }
//        composable("signup") {
//            SignUpPages(modifier, navController, authViewModel)
//        }
//        composable("home") {
//            HomePage(modifier, navController, authViewModel)
//        }
//    })
//}



package com.example.jetpackcompose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.Pages.DashboardPage
import com.example.jetpackcompose.Pages.HomePage
import com.example.jetpackcompose.Pages.LoginPage
import com.example.jetpackcompose.Pages.SignUpPages

@Composable
fun MyAppNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Login", builder = {
        composable("Login") {
            LoginPage(modifier, navController, authViewModel)
        }
        composable("signup") {
            SignUpPages(modifier, navController, authViewModel)
        }
        composable("home") {
            HomePage(modifier, navController, authViewModel)
        }
        composable("dashboard") {
            DashboardPage(modifier, navController)
        }
    })
}