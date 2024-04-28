package com.example.firstprojectpreview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstprojectpreview.ui.theme.FirstProjectPreviewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstProjectPreviewTheme {
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
    // With this surface now we will have same preview result as we had with emulator
    Surface(
        modifier = Modifier.fillMaxSize(),
//        modifier = Modifier.height(150.dp).width(300.dp)
        color = Color.DarkGray,
        contentColor = Color.White,
//        shape = RoundedCornerShape(10.dp, 50.dp, 50.dp, 20.dp),
//        shape = CutCornerShape(50.dp, 50.dp, 50.dp, 20.dp),
//        border = BorderStroke(2.dp, color = Color.Red)
//        shadowElevation = 16.dp
    ) {
        Text(
            text = "Hi",
            fontSize = 32.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "App Preview")
@Composable
fun MyAppPreview() {
    MyApp()
}
