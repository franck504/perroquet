package com.techcare.perroquet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.techcare.perroquet.ui.theme.PerroquetTheme
import androidx.compose.foundation.layout.Arrangement

enum class AuthScreen {
    LOGIN,
    SIGNUP
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PerroquetTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AuthenticationScreen(modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}
@Composable
fun AuthenticationScreen() {
    var currentScreen by remember { mutableStateOf(AuthScreen.LOGIN) }

    when (currentScreen) {
        AuthScreen.LOGIN -> LoginScreen(onNavigateToSignup = { currentScreen = AuthScreen.SIGNUP })
        AuthScreen.SIGNUP -> SignupScreen(onNavigateToLogin = { currentScreen = AuthScreen.LOGIN })
    }
}

@Composable
fun LoginScreen(onNavigateToSignup: () -> Unit, modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
 modifier = modifier
 .fillMaxSize()
 .padding(16.dp)
    ) {
 Card(
 modifier = Modifier
 .size(100.dp)
 .fillMaxWidth(),
 elevation = CardDefaults.cardElevation(4.dp)
 ) {
 // Placeholder for logo
 }
 Text("Login", fontSize = 24.sp)
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )
        Button(
            onClick = { /* Handle login */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Login")
        }
        Button(
            onClick = onNavigateToSignup,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Text("Don't have an account? Sign Up")
        }
    }
 Button(
 onClick = { /* Handle Google Sign-In */ },
 modifier = Modifier
 .fillMaxWidth()
 .padding(top = 8.dp)
 ) {
 Text("Connect with Google")
 }
}

@Composable
fun SignupScreen(onNavigateToLogin: () -> Unit, modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )
        Button(
            onClick = { /* Handle signup */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Sign Up")
        }
 Card(
 modifier = Modifier
 .size(100.dp)
 .fillMaxWidth(),
 elevation = CardDefaults.cardElevation(4.dp)
 ) {
 // Placeholder for logo
 }
 Text("Signup", fontSize = 24.sp)
 OutlinedTextField(
 value = email,
 onValueChange = { email = it },
 label = { Text("Email") },
 modifier = Modifier.fillMaxWidth()
 )
 OutlinedTextField(
 value = password,
 onValueChange = { password = it },
 label = { Text("Password") },
 modifier = Modifier
 .fillMaxWidth()
 .padding(top = 8.dp)
 )
 OutlinedTextField(
 value = confirmPassword,
 onValueChange = { confirmPassword = it },
 label = { Text("Confirm Password") },
 modifier = Modifier
 .fillMaxWidth()
 .padding(top = 8.dp)
 )
 Button(
 onClick = { /* Handle signup */ },
 modifier = Modifier
 .fillMaxWidth()
 .padding(top = 16.dp)
 ) {
 Text("Sign Up")
 }
        Button(
            onClick = onNavigateToLogin,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Text("Already have an account? Login")
        }
 Button(
 onClick = { /* Handle Google Sign-Up */ },
 modifier = Modifier
 .fillMaxWidth()
 .padding(top = 8.dp)
 ) {
 Text("Sign up with Google")
 }
    }
}

@Preview(showBackground = true)
@Composable
fun AuthenticationScreenPreview() {
    PerroquetTheme {
        AuthenticationScreen()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
 Text(
 text = "Hello $name!",
 modifier = modifier
 )
}