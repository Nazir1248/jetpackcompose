package com.example.jetpackcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme


////
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        val authViewModel : AuthViewModel by viewModels()
//        setContent {
////                LoginScreen()
//                JetpackComposeTheme {
//                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                        MyAppNavigation(modifier =Modifier.padding(innerPadding), authViewModel = authViewModel)
//                    }
//                }
//        }
//    }
//}



class MainActivity : ComponentActivity() {
    private val authViewModel: AuthViewModel by viewModels {
        AuthViewModelFactory(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize Google Sign-In
        authViewModel.initializeGoogleSignIn(getString(R.string.default_web_client_id))

        setContent {
            JetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyAppNavigation(modifier = Modifier.padding(innerPadding), authViewModel = authViewModel)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            authViewModel.handleGoogleSignInResult(data)
        }
    }

    companion object {
        const val RC_SIGN_IN = 9001
    }
}
