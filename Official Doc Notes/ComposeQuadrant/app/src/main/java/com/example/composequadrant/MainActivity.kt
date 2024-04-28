package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Layout()
                }
            }
        }
    }
}


@Composable
fun Layout(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(Modifier.weight(1f)) {
            // For modifier = Modifier.weight(1f)
            // Size the element's width proportional to its weight relative to other weighted sibling
            // elements in the Row. The parent will divide the horizontal space remaining after measuring
            // unweighted child elements and distribute it according to this weight.

            CardInfo(title = stringResource(R.string.text_composable), description = stringResource(R.string.text_description), bgColor = Color(0xFFEADDFF), modifier = Modifier.weight(1f))
            CardInfo(title = stringResource(R.string.image_composable), description = stringResource(R.string.image_description), bgColor = Color(0xFFD0BCFF), modifier = Modifier.weight(1f))
        }

        Row(Modifier.weight(1f)) {
            CardInfo(title = stringResource(R.string.row_composable), description = stringResource(R.string.row_description), bgColor = Color(0xFFB69DF8), modifier = Modifier.weight(1f))
            CardInfo(title = stringResource(R.string.column_composable), description = stringResource(R.string.column_description), bgColor = Color(0xFFF6EDFF), modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun CardInfo(title: String, description: String, bgColor: Color, modifier: Modifier=Modifier) {
    Column (
        modifier = modifier
            .background(bgColor)
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text (
            text = title,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text (
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        Greeting("Android")
    }
}