package com.example.deltatask1


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun GamePage(navigateToPlayerdatapage:()->Unit){

    var tile by remember { mutableStateOf(List(25) { 0 }) }

    var playerOneTile by remember { mutableStateOf(List(25){ (-1) }) }

    var isPlayerOneTurn by remember { mutableStateOf(true) }
    val backgroundColor = if (isPlayerOneTurn) Color(0xFFff5f57) else Color(0xFF2fb6f0)

    var playerOnePoints by remember { mutableIntStateOf(0) }
    var playerTwoPoints by remember { mutableIntStateOf(0) }

    var playerOneFirstTurn by remember { mutableIntStateOf(1) }
    var playerTwoFirstTurn by remember { mutableIntStateOf(1) }

    var currentPlayer by remember { mutableIntStateOf(1) }

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Button(
            onClick = ({}),
            modifier = Modifier
                .height(60.dp)
                .width(80.dp)
                .offset(x = (0).dp, y = 80.dp),
            shape = RoundedCornerShape(topEnd = 30.dp, bottomEnd = 30.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2f323b)),
            border = BorderStroke(3.dp, color = Color(0xFF000000))
        ) {
            Text(
                text = "$playerTwoPoints",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color(0xFF2fb6f0),
                modifier = Modifier
                    .graphicsLayer(rotationZ = 180f)
            )
        }
//player2
        Button(
            onClick = ({}),
            modifier = Modifier
                .height(60.dp)
                .wrapContentWidth(align = Alignment.CenterHorizontally, unbounded = true)
                .offset(x = 90.dp, y = 80.dp)
                .clip(RoundedCornerShape(10.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2f323b)),
            shape = CutCornerShape(topStart = 30.dp, bottomStart = 30.dp),
            border = BorderStroke(3.dp, color = Color(0xFF000000))
        ) {
            Text(
                text = (if (globalTextFieldValueReference2 == "") "PLAYER2" else globalTextFieldValueReference2).uppercase(),
                fontSize = 30.sp, fontWeight = FontWeight.Bold,
                color = Color(0xFF2fb6f0),
                modifier = Modifier
                    .graphicsLayer(rotationZ = 180f)
                    .padding(top = 3.dp, bottom = 3.dp, end = 10.dp)
            )
        }

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2f323b)),
            shape = RoundedCornerShape(topStart = 30.dp, bottomStart = 30.dp),
            border = BorderStroke(3.dp, color = Color(0xFF000000)),
            modifier = Modifier
                .height(60.dp)
                .width(72.dp)
                .offset(x = (340).dp, y = 720.dp)
        ) {
            Text(
                text = "$playerOnePoints",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color(0xFFff5f57)
            )
        }
//PLAYER1
        Button(
            onClick = ({}),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2f323b)),
            shape = CutCornerShape(topEnd = 30.dp, bottomEnd = 30.dp),
            modifier = Modifier
                .padding(bottom = (58).dp, end = 85.dp)
                .clip(RoundedCornerShape(10.dp))
                .align(Alignment.BottomEnd),
            border = BorderStroke(3.dp, color = Color(0xFF000000))
        ) {
            Text(
                text = (if (globalTextFieldValueReference1 == "") "PLAYER1" else globalTextFieldValueReference1).uppercase(),
                fontSize = 30.sp,
                modifier = Modifier
                    .padding(top = 3.dp, start = 3.dp, bottom = 3.dp, end = 15.dp),
                fontWeight = FontWeight.Bold,
                color = Color(0xFFff5f57)
            )
        }

        Button(
            onClick = { navigateToPlayerdatapage() },
            shape = CircleShape,
            modifier = Modifier
                .size(50.dp)
                .offset(x = 330.dp, y = 25.dp)
                .shadow(10.dp, CircleShape),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text(
                text = "X", fontSize = 25.sp, color = Color(0xFFa0b9cd),
                fontWeight = FontWeight.Bold, textAlign = TextAlign.Center
            )
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(5),
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 245.dp,
                end = 20.dp
            ),
            modifier = Modifier.padding(5.dp),
            content = {
                items(25) {index->
                    Card(
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .size(70.dp)
                            .padding(3.dp)
                            .shadow(5.dp, RoundedCornerShape(10.dp))
                            .clickable {

                                if (playerOneFirstTurn == 1) {
                                    isPlayerOneTurn = !isPlayerOneTurn
                                    tile = tile
                                        .toMutableList()
                                        .also { it[index] = 3 }
                                    playerOneTile = playerOneTile
                                        .toMutableList()
                                        .also { it.add(index)}
                                    playerOneFirstTurn = 0
                                    playerOnePoints += 3
                                    currentPlayer = 2
                                } else if (playerTwoFirstTurn == 1) {
                                    isPlayerOneTurn = !isPlayerOneTurn
                                    tile = tile
                                        .toMutableList()
                                        .also { it[index] = 3 }
                                    playerTwoFirstTurn = 0
                                    playerTwoPoints += 3
                                    currentPlayer = 1
                                } else if (currentPlayer == 1) {
                                    isPlayerOneTurn = !isPlayerOneTurn
                                    if (tile[index] == 3){
                                        if (index == 0){
                                            tile = tile
                                                .toMutableList()
                                                .also { it[index] = 0 }
                                            tile = tile
                                                .toMutableList()
                                                .also { it[index + 1] += 1 }
                                        }
                                    }
                                    currentPlayer = 2
                                }

                            },
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFf5e5ce))
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(10.dp)),
                            contentAlignment = Alignment.Center
                        ){
                            if (tile[index] != 0){
                                if(index in playerOneTile){
                                    Box(
                                        modifier = Modifier
                                            .clip(CircleShape)
                                            .size(50.dp)
                                            .background(color = Color(0xFFff5f57)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(text = tile[index].toString(),
                                            fontSize = 25.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color.White)
                                    }
                                }
                                else{
                                    Box(
                                        modifier = Modifier
                                            .clip(CircleShape)
                                            .size(50.dp)
                                            .background(color = Color(0xFF2fb6f0)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(text = tile[index].toString(),
                                            fontSize = 25.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color.White)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        )
    }
}

