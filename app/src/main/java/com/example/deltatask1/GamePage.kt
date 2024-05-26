package com.example.deltatask1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun GamePage(){
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF2fb6f0))
    )
}