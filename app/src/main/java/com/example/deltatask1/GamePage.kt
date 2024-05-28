package com.example.deltatask1

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GamePage(navigateToPlayerdatapage:()->Unit){

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFff5f57))
    ){
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFF2f323b)),
            shape = RoundedCornerShape(30.dp),
            border = BorderStroke(3.dp, color = Color(0xFF000000)),
            modifier = Modifier
                .height(60.dp)
                .width(160.dp)
                .offset(x = (-80).dp, y = 60.dp)
                .shadow(10.dp, RoundedCornerShape(30.dp))) {
            }

        Button(
            onClick = ({}),
            modifier = Modifier
                .height(60.dp)
                .width(180.dp)
                .offset(x = 90.dp, y = 60.dp)
                .clip(RoundedCornerShape(10.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2f323b)),
            shape = CutCornerShape(topStart = 30.dp, bottomStart = 30.dp),
            border = BorderStroke(3.dp, color = Color(0xFF000000))){
            Text("Ramanaa", fontSize = 30.sp, fontWeight = FontWeight.Bold,
                color = Color(0xFF2fb6f0),
                modifier = Modifier
                    .graphicsLayer(rotationZ = 180f))
        }

        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFF2f323b)),
            shape = RoundedCornerShape(30.dp),
            border = BorderStroke(3.dp, color = Color(0xFF000000)),
            modifier = Modifier
                .height(60.dp)
                .width(160.dp)
                .offset(x = (340).dp, y = 720.dp)
                .shadow(10.dp, RoundedCornerShape(30.dp))) {
        }

        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFF2f323b)),
            shape = CutCornerShape(topEnd = 30.dp, bottomEnd = 30.dp),
            modifier = Modifier
                .height(60.dp)
                .width(180.dp)
                .offset(x = 150.dp, y = 720.dp)
                .clip(RoundedCornerShape(10.dp)),
            border = BorderStroke(3.dp, color = Color(0xFF000000))){

        }

        Button(
            onClick = { navigateToPlayerdatapage() },
            shape = CircleShape,
            modifier = Modifier
                .size(50.dp)
                .offset(x = 330.dp, y = 25.dp)
                .shadow(10.dp, CircleShape),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)) {
            Text(text = "X", fontSize = 25.sp, color = Color(0xFFa0b9cd),
                fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(5),
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 235.dp,
                end = 20.dp
            ),
            modifier = Modifier.padding(5.dp),
            content = {
                items(25){i ->
                    Card(
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .size(70.dp)
                            .padding(3.dp)
                            .shadow(5.dp, RoundedCornerShape(10.dp))
                            .clickable { },
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFf5e5ce))
                    ){}
                }
            }
        )
    }
}