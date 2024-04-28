package com.example.imagesinjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.imagesinjc.ui.theme.ImagesInJCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImagesInJCTheme {
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
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.bird_thumbnail),
            contentDescription = "bird thumbnail",
            modifier = Modifier
                .size(250.dp)
                .padding(bottom = 10.dp)
                .clip(RoundedCornerShape(20.dp))
                .border(2.dp, Color.Green, RoundedCornerShape(20.dp)),
//            contentScale = ContentScale.Crop    // Cropping image to cover or take whole size
            contentScale = ContentScale.FillWidth,    // Cropping image to cover or take whole width
//            alpha = 0.7f
        )

        Image(
            painter = painterResource(id = R.drawable.bird_thumbnail),
            contentDescription = "bird thumbnail",
            modifier = Modifier
                .size(250.dp)
                .padding(bottom = 10.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Red, CircleShape),
//            contentScale = ContentScale.Crop    // Cropping image to cover or take whole size
            contentScale = ContentScale.FillWidth,    // Cropping image to cover or take whole width
//            alpha = 0.7f
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ImagesInJCTheme {
        App()
    }
}