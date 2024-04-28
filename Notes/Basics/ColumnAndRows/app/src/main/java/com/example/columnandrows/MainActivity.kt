package com.example.columnandrows

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.columnandrows.ui.theme.ColumnAndRowsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColumnAndRowsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun MyApp() {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
////        verticalArrangement = Arrangement.SpaceBetween,
////        verticalArrangement = Arrangement.SpaceBetween,
////        verticalArrangement = Arrangement.SpaceAround,
//        verticalArrangement = Arrangement.Center,
//
//    ) {
//        Text(text = "Visca")
//        Text(text = "El")
//        Text(text = "Barca")
//    }

    Row (
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly,
//        horizontalArrangement = Arrangement.SpaceAround,
//        horizontalArrangement = Arrangement.SpaceBetween,
//        horizontalArrangement = Arrangement.Center,

//        verticalAlignment = Alignment.CenterVertically,
//        verticalAlignment = Alignment.Bottom,
        verticalAlignment = Alignment.Top,
    ) {
        Text(text = "Visca")
        Text(text = "El")
        Text(text = "Barca")
    }
}

@Preview(showBackground = true, name = "MyApp")
@Composable
fun AppPreview() {
    MyApp()
}
