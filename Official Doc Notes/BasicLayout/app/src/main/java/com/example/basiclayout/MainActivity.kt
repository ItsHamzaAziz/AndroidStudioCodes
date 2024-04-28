package com.example.basiclayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.basiclayout.ui.theme.BasicLayoutTheme

// More imports
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Hamzee")

//                    GreetingImage(message = "Happy Birthday", from = "From Hamza")
                    // Now Happy Birthday string is saved in res/values/strings.xml file
                    GreetingImage(message = stringResource(R.string.happy_birthday), from = "Hamza")
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

@Composable
fun GreetingText(message: String, modifier: Modifier = Modifier,from: String="From Hamzee"){
    Column(
        verticalArrangement = Arrangement.Center,
//        modifier = Modifier.padding(8.dp),
        modifier = modifier
    ) {
        Text(
            text = message,
            modifier = modifier,
            // In order to use sp we imported separately
            fontSize = 80.sp,
            lineHeight = 110.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
//                .align(alignment = Alignment.End)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.androidparty)
    Box(
        modifier = modifier,
        // To place content in center (vertical alignment does not apply here)
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = image,
            contentDescription = null,
            // Using the ContentScale.Crop parameter scaling,
            // which scales the image uniformly to maintain the aspect ratio
            // so that the width and height of the image are equal to, or larger
            // than, the corresponding dimension of the screen.
            contentScale = ContentScale.Crop,
            alpha = 0.5F,   // For opacity of the image
        )
        GreetingText(
            message = message,
            from = "From $from",
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    end = 15.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
            )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasicLayoutTheme {
//        Greeting("Android")
        GreetingText(message = "Happy Birthday", from = "Us")
    }
}