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
            Mainpage (navController)
        }
        composable("playerdatapage"){
            Playerinfo (navController)
        }
        composable("gamepage"){
            GamePage(navController)
        }
    }
}