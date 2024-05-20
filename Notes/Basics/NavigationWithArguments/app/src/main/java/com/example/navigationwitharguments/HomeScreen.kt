package com.example.navigationwitharguments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
    val modifier = Modifier

    var nameValue by remember {
        mutableStateOf("")
    }
    var ageValue by remember {
        mutableStateOf("")
    }

    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Home Screen",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(value = nameValue,
            onValueChange = { nameValue = it },
            placeholder = {
                Text(text = "Enter Name")
            },
            modifier = Modifier.padding(10.dp)
        )
        TextField(value = ageValue,
            onValueChange = { ageValue = it },
            placeholder = {
                Text(text = "Enter Age")
            },
            modifier = Modifier.padding(10.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
//            navController.navigate("Details/$nameValue/$ageValue")
            navController.navigate("Details?name=$nameValue&age=$ageValue")
        }) {
            Text(
                text = "Pass Data",
                fontSize = 20.sp
            )
        }
    }
}