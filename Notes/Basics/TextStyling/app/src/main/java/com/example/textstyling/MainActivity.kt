package com.example.textstyling

import android.graphics.Paint.Style
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.textstyling.ui.theme.TextStylingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextStylingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    Text(
//        text = "Hi Mom",
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 50.sp
                )
            ) {
                append("H")
            }
            append("i ")

            withStyle(
                style = SpanStyle(
                    fontSize = 50.sp
                )
            ) {
                append("M")
            }
            append("om")
        },
        modifier = Modifier
            .background(color = Color.Yellow)
            .padding(10.dp)
            .width(250.dp),
        color = Color.Blue,
        fontSize = 25.sp,
        fontStyle = FontStyle.Italic,
//        fontWeight = FontWeight.ExtraLight,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = FontFamily.Monospace,
        letterSpacing = 3.sp,
//        textDecoration = TextDecoration.LineThrough,
//        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Center,
//        lineHeight = 20.dp,
//        maxLines = 3,

    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TextStylingTheme {
        MyApp()
    }
}