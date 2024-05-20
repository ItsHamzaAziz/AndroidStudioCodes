package com.example.navigationwitharguments

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Nav() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Home") {
        composable(route = "Home") {
            HomeScreen(navController)
        }
        composable(
//            route = "Details/{name}/{age}"
            route = "Details?name={name}&age={age}",    // In case if no or all inputs were not filled (otherwise app will crash)
            arguments = listOf(
                navArgument(name = "name") {
                    type = NavType.StringType
                    nullable = true
                },
                navArgument(name = "age") {
                    type = NavType.StringType
                    nullable = true
                    // If we had Int then we would've specified defaultValue= 0 and used below getInt("age")
                }
            )
        ) { backstackEntry ->
            DetailsScreen(
                name = backstackEntry.arguments?.getString("name"),
                age = backstackEntry.arguments?.getString("age"),
            )
        }
    }
}