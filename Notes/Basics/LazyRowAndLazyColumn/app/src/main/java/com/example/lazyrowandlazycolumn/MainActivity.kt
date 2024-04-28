package com.example.lazyrowandlazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lazyrowandlazycolumn.ui.theme.LazyRowAndLazyColumnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyRowAndLazyColumnTheme {
                val languages = listOf(
                    "Java",
                    "Kotlin",
                    "Python",
                    "Dart",
                    "PHP",
                    "XML",
                    "HTML",
                    "JavaScript",
                    "R",
                    "Go",
                    "C++",
                    "Swift",
                    "Verilog"
                )


                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App(list = languages)
                }
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier, list: List<String>) {
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        LazyRow() {
            items(items = list){item ->
                RowItem(itemText = item)
            }
        }

        LazyColumn() {
            items(items = list){item ->
                ColumnItem(itemText = item)
            }
        }
    }
}


@Composable
fun ColumnItem(itemText: String, modifier: Modifier = Modifier) {
    Card(
        modifier
            .padding(6.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio(3f),
        elevation = CardDefaults.cardElevation(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black
        )
    ) {
        Box(
            modifier
                .padding(10.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = itemText, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}


@Composable
fun RowItem(itemText: String, modifier: Modifier = Modifier) {
    Card(
        modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(100.dp)
            .aspectRatio(1.5f),
        elevation = CardDefaults.cardElevation(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black
        )
    ) {
        Text(
            text = itemText,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LazyRowAndLazyColumnTheme {
//        App()
    }
}