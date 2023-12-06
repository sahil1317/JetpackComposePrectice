package com.sahil.jetpackcomposeprectice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting("Android")
        }
    }
}

@Composable
fun Greeting(name: String) {
    val emailState = remember { mutableStateOf<String>("") }
    val password = remember { mutableStateOf<String>("") }

    Surface(modifier = Modifier.fillMaxSize(), color = Color.LightGray) {
        Column(Modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {

            TextField(
                value = emailState.value,
                onValueChange = { text -> emailState.value = text },
                placeholder = { Text("Enter email") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = password.value,
                onValueChange = { text -> password.value = text },
                placeholder = { Text("Enter password") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            )
            Button(
                onClick = { },
                modifier = Modifier.padding(top = 20.dp)
            ) {
                Text(text = "Submit")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Greeting("Android")
}