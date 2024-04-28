package com.example.lazygrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lazygrid.ui.theme.LazyGridTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyGridTheme {
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
fun App(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
//        columns = GridCells.Adaptive(75.dp),    // Each item will be no less than 75.dp
        contentPadding = PaddingValues(10.dp)
    ) {
        items(200) {
            MyCard(it = it)
        }
    }
}

@Composable
fun MyCard(it: Int, modifier: Modifier = Modifier) {
    Card(
        modifier
            .padding(10.dp)
            .size(100.dp),
        elevation = CardDefaults.cardElevation(20.dp),
        colors = CardDefaults.cardColors(
//            containerColor = Color.LightGray,
            containerColor = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
            ),
            contentColor = Color.Black,
        )
    ) {
        Box(
            modifier
               .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = it.toString(),
                fontSize = 20.sp
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LazyGridTheme {
        App()
    }
}