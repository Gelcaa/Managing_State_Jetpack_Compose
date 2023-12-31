package com.example.littlelemonlogin

import android.os.Bundle
import androidx.compose.ui.platform.LocalContext
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemonlogin.ui.theme.LittleLemonLoginTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonLoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}
@Composable
fun LoginScreen(){
    val context = LocalContext.current
    var username by remember { mutableStateOf(TextFieldValue(""))}
    var password by remember { mutableStateOf(TextFieldValue(""))}
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            modifier = Modifier.padding(10.dp),
            painter = painterResource(
                id = R.drawable.littlelemonlogo),
            contentDescription = "Logo Image"
        )
        TextField(
            modifier = Modifier.padding(10.dp),
            value = username,
            onValueChange = {username = it},
            label = { Text(text = "Username") },
        )
        TextField(
            modifier = Modifier.padding(10.dp),
            value = password,
            onValueChange = {password = it},
            label = { Text(text = "Password") },
        )
        Button(

            onClick = {
                if(username.text == "darian"
                    && password.text=="littlelemon"
                ){
                    Toast.makeText(context,
                        "Welcome to Little Lemon!",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(context,
                        "Invalid credentials."
                                + "Please try again.",
                        Toast.LENGTH_LONG
                    ).show()
                }
            },
            modifier = Modifier.padding(10.dp),
            colors = ButtonDefaults.buttonColors(
                Color(0xFF495E57)
            )
        ) {
            Text(
                text = "Login",
                color = Color(0xFFEDEFEE)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}