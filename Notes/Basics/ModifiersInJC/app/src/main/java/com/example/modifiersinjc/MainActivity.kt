package com.example.modifiersinjc

import android.os.Bundle
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.modifiersinjc.ui.theme.ModifiersInJCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModifiersInJCTheme {
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
fun MyApp(){
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Text(
            text = "Hello, World!",
            modifier = Modifier
                .padding(10.dp)     // Padding before background color gives outside space while after it gives inside space
                .background(color = Color.Green)
                .padding(10.dp)
//                .width(250.dp)
//                .height(75.dp)
//                .size(250.dp)       // Covers both height and width
                .fillMaxWidth(fraction = 0.75f)     // 1 means full
//                .fillMaxWidth()
//                .fillMaxHeight()    // Can also have fraction parameter where 1 is full or 100%
//                .fillMaxSize()      // Covers both height and width (also has fraction parameter
        )

        Box(
            modifier = Modifier
                .padding(50.dp)
                .size(200.dp)
                .rotate(degrees = 45f)
                .alpha(0.55f)
                .clip(RoundedCornerShape(20.dp))    // Outward clopping while shape in border clips inward (color will overflow outside)
                .background(color = Color.Red)  // Should be in end (with border)
//                .border(3.dp, Color.Black, shape = RoundedCornerShape(20.dp))
                .border(3.dp, Color.Black)
        ) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApp()
}