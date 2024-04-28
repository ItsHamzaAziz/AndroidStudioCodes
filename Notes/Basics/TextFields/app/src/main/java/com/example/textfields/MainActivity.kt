package com.example.textfields

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.textfields.ui.theme.TextFieldsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    var newText by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)

    ) {
//        TextField(value = "Text Field", onValueChange = {})

        TextField(
            value = newText,
            label = {
             Text(text = "Enter Email")
            },
            onValueChange = { newText = it },
            singleLine = true,
//            modifier = Modifier.width(200.dp),
            placeholder = {
                Text(text = "e.g abc@xyz.com")
            },
//            visualTransformation = PasswordVisualTransformation()   // For password

            leadingIcon = {
                Icon(imageVector = Icons.Outlined.Email, contentDescription = null)
            },

            trailingIcon = {
                IconButton(onClick = {
                    Toast.makeText(context, "Your email is $newText", Toast.LENGTH_SHORT).show()
                }) {
                    Icon(imageVector = Icons.Outlined.Send, contentDescription = null)
                }
            },

            keyboardOptions = KeyboardOptions(
//                capitalization = KeyboardCapitalization.Characters,
//                capitalization = KeyboardCapitalization.Words,
//                capitalization = KeyboardCapitalization.Sentences,

//                keyboardType = KeyboardType.Phone,
//                keyboardType = KeyboardType.Number,
//                keyboardType = KeyboardType.Text,
                keyboardType = KeyboardType.Email,
            ),

//            keyboardActions = KeyboardActions(
//                onDone = {
////                    Toast.makeText(context, "Your email is $newText", Toast.LENGTH_SHORT).show()
//                },
//                onSend = {
//
//                },
//                onNext = {
//
//                }
//            )
        )

        Text(text = "Your email is")
        Text(text = newText)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App()
}