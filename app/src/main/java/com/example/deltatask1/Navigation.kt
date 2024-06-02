package com.example.deltatask1

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "homepage") {
        composable("homepage"){
            Mainpage {
                navController.navigate("playerdatapage")
            }
        }
        composable("playerdatapage"){
            Playerinfo {
                navController.navigate("gamepage")
            }
        }
        composable("gamepage"){
            GamePage {
                navController.navigate("playerdatapage")
            }
        }
    }
}