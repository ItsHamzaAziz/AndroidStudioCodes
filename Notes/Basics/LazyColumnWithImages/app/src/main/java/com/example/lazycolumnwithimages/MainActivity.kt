package com.example.lazycolumnwithimages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lazycolumnwithimages.ui.theme.LazyColumnWithImagesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnWithImagesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val imageIds = arrayOf(
                        R.drawable.p1,
                        R.drawable.p2,
                        R.drawable.p3,
                        R.drawable.p4,
                        R.drawable.p5,
                        R.drawable.p6
                    )

                    val names = arrayOf(
                        "Peperoni",
                        "Vegan",
                        "FourCheese",
                        "Margaritta",
                        "American",
                        "Mexican"
                    )

                    val ingredients = arrayOf(
                        "Tomato sos, cheese, oregano, peperoni",
                        "Tomato sos, cheese, oregano, spinach, green paprika, rukola",
                        "Tomato sos, oregano, mozzarella, goda, parmesan, cheddar",
                        "Tomato sos, cheese, oregano, bazillion",
                        "Tomato sos, cheese, oregano, green paprika, red beans",
                        "Tomato sos, cheese, oregano, corn, jalapeno, chicken"
                    )

                    App(imageIds = imageIds, ingredients = ingredients, names = names)
                }
            }
        }
    }
}

@Composable
fun App(imageIds: Array<Int>, names: Array<String>, ingredients: Array<String>, modifier: Modifier = Modifier) {
    LazyColumn(
        contentPadding = PaddingValues(15.dp)
    ) {
        val totalItems = imageIds.size

        items(totalItems) {item ->
            ColumnItem(
                itemIndex = item,
                painter = imageIds,
                title = names,
                ingredients = ingredients
            )
        }
    }
}

@Composable
fun ColumnItem(itemIndex: Int, painter: Array<Int>, title: Array<String>, ingredients: Array<String>, modifier: Modifier = Modifier){
    Card(
        modifier
            .padding(15.dp)
            .wrapContentSize()
            .height(200.dp),
        elevation = CardDefaults.cardElevation(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        )
    ) {
        Row(
            modifier
               .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Image(
                painter = painterResource(id = painter[itemIndex]),
                contentDescription = title[itemIndex],
                modifier
                    .width(140.dp),
                contentScale = ContentScale.FillHeight
            )

            Column(
                modifier.padding(10.dp)
            ) {
                Text(
                    text = title[itemIndex],
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = ingredients[itemIndex],
                    fontSize = 18.sp,
                    color = Color.Black
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LazyColumnWithImagesTheme {

    }
}