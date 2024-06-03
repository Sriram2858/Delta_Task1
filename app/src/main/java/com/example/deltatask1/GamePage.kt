package com.example.deltatask1


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun GamePage(navController: NavHostController){

//    val context = LocalContext.current
//    val preferencesManager = remember { Preferencesmanager(context) }

    var showDialog by remember { mutableStateOf(false) }
    var showDialogReference2 by remember { mutableStateOf(false) }
    val tile = remember { mutableStateListOf(*Array(25) { 0 }) }
    val playerOneTile = remember { mutableStateListOf(*Array(25){ 0 }) }
    val playerTwoTile = remember { mutableStateListOf(*Array(25){ 0 }) }
    var isPlayerOneTurn by remember { mutableStateOf(true) }
    val backgroundColor = if (isPlayerOneTurn) Color(0xFFff5f57) else Color(0xFF2fb6f0)
    var playerOnePoints by remember { mutableIntStateOf(0) }
    var playerTwoPoints by remember { mutableIntStateOf(0) }
    var playerOneFirstTurn by remember { mutableIntStateOf(1) }
    var playerTwoFirstTurn by remember { mutableIntStateOf(1) }
    var currentPlayer by remember { mutableIntStateOf(1) }
    var winner by remember { mutableStateOf("") }

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {

//playertwo points
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
                fontSize = 26.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                color = Color(0xFF2fb6f0),
                modifier = Modifier
                    .graphicsLayer(rotationZ = 180f)
            )
        }

//player two name
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
//player one points
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2f323b)),
            shape = RoundedCornerShape(topStart = 30.dp, bottomStart = 30.dp),
            border = BorderStroke(3.dp, color = Color(0xFF000000)),
            modifier = Modifier
                .height(60.dp)
                .width(80.dp)
                .offset(x = (332).dp, y = 720.dp)
        ) {
            Text(
                text = "$playerOnePoints",
                fontSize = 26.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                color = Color(0xFFff5f57)
            )
        }
//PLAYER1 NAME
        Button(
            onClick = ({}),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2f323b)),
            shape = CutCornerShape(topEnd = 30.dp, bottomEnd = 30.dp),
            modifier = Modifier
                .padding(bottom = (58).dp, end = 93.dp)
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
//Tile expand
        fun expand(index: Int){
            val x = index % 5
            val y = index / 5
            val expandX = Array(4){-1}
            val expandY = Array(4){-1}
            val expandIndex = Array(4){-1}

            if (x-1 in 0..4 ) { expandX[0] = x-1 }
            if (x in 0..4 ) { expandX[1] = x }
            if (x+1 in 0..4 ) { expandX[2] = x+1 }
            if (x in 0..4 ) { expandX[3] = x }

            if (y in 0..4 ) {  expandY[0] = y }
            if (y-1 in 0..4 ) { expandY[1] = y-1 }
            if (y in 0..4 ) { expandY[2] = y }
            if (y+1 in 0..4 ) { expandY[3] = y+1 }

            for (i in 0..3){
                if ((expandX[i] in 0..4) && (expandY[i] in 0..4)){
                    expandIndex[i] = expandY[i] * 5 + expandX[i]
                    tile[expandIndex[i]] += 1
                    if (currentPlayer == 1) {
                        playerOneTile[expandIndex[i]] = 1
                        playerTwoTile[expandIndex[i]] = 0
                    }
                    else if(currentPlayer == 2){
                        playerOneTile[expandIndex[i]] = 0
                        playerTwoTile[expandIndex[i]] = 1
                    }
                    if (tile[expandIndex[i]] > 3){
                        tile[expandIndex[i]] = 0
                        expand( expandIndex[i] )
                    }
                }
            }
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
                items(25) {
                    Card(
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .size(70.dp)
                            .padding(3.dp)
                            .shadow(5.dp, RoundedCornerShape(10.dp))
                            .clickable {

                                if (playerOneFirstTurn == 1) {
                                    isPlayerOneTurn = !isPlayerOneTurn
                                    tile[it] = 3
                                    playerOneTile[it] = 1
                                    playerOneFirstTurn = 0
                                    playerOnePoints += 3
                                    currentPlayer = 2
                                } else if (playerTwoFirstTurn == 1) {
                                    isPlayerOneTurn = !isPlayerOneTurn
                                    tile[it] = 3
                                    playerTwoTile[it] = 1
                                    playerTwoFirstTurn = 0
                                    playerTwoPoints += 3
                                    currentPlayer = 1
                                } else if (currentPlayer == 1) {

                                    if (tile[it] == 3 && playerOneTile[it] == 1) {
                                        isPlayerOneTurn = !isPlayerOneTurn
                                        tile[it] = 0
                                        expand(it)
                                        currentPlayer = 2
                                    } else if (tile[it] != 0 && playerOneTile[it] == 1) {
                                        isPlayerOneTurn = !isPlayerOneTurn
                                        tile[it] += 1
                                        currentPlayer = 2
                                    }

                                    playerOnePoints = 0
                                    for (i in 0..24) {
                                        if (playerOneTile[i] == 1) {
                                            playerOnePoints += tile[i]
                                        }
                                    }
                                    playerTwoPoints = 0
                                    for (i in 0..24) {
                                        if (playerTwoTile[i] == 1) {
                                            playerTwoPoints += tile[i]
                                        }
                                    }

                                    if (playerOnePoints == 0) {
                                        winner =
                                            (if (globalTextFieldValueReference2 == "") "PLAYER2" else globalTextFieldValueReference2).uppercase()
                                        showDialog = true
                                    } else if (playerTwoPoints == 0) {
                                        winner = (if (globalTextFieldValueReference1 == "") {
                                            "PLAYER1"
                                        } else globalTextFieldValueReference1).uppercase()
                                        showDialog = true
                                    }

                                } else if (currentPlayer == 2) {
                                    if (tile[it] == 3 && playerTwoTile[it] == 1) {
                                        isPlayerOneTurn = !isPlayerOneTurn
                                        tile[it] = 0
                                        expand(it)
                                        currentPlayer = 1
                                    } else if (tile[it] != 0 && playerTwoTile[it] == 1) {
                                        isPlayerOneTurn = !isPlayerOneTurn
                                        tile[it] += 1
                                        currentPlayer = 1
                                    }

                                    playerOnePoints = 0
                                    for (i in 0..24) {
                                        if (playerOneTile[i] == 1) {
                                            playerOnePoints += tile[i]
                                        }
                                    }
                                    playerTwoPoints = 0
                                    for (i in 0..24) {
                                        if (playerTwoTile[i] == 1) {
                                            playerTwoPoints += tile[i]
                                        }
                                    }
                                    if (playerOnePoints == 0) {
                                        winner =
                                            (if (globalTextFieldValueReference2 == "") "PLAYER2" else globalTextFieldValueReference2).uppercase()
                                        showDialog = true
                                    } else if (playerTwoPoints == 0) {
                                        winner =
                                            (if (globalTextFieldValueReference1 == "") "PLAYER1" else globalTextFieldValueReference1).uppercase()
                                        showDialog = true
                                    }
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
                            if (tile[it] != 0){
                                if(playerOneTile[it] == 1){
                                    Box(
                                        modifier = Modifier
                                            .clip(CircleShape)
                                            .size(50.dp)
                                            .background(color = Color(0xFFff5f57)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(text = tile[it].toString(),
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
                                            .align(Alignment.Center)
                                            .background(color = Color(0xFF2fb6f0)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(text = tile[it].toString(),
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
//winner dialog box
        if(showDialog) {
            AlertDialog(onDismissRequest = {},
                confirmButton = {
                    Button(
                        onClick = {
                            navController.navigate("gamepage") },
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(Color(0xFFffc107))
                    ) {
                        Row {
                            Icon(
                                imageVector = Icons.Filled.Refresh,
                                contentDescription = "Replay Button",
                                modifier = Modifier
                                    .size(35.dp)
                                    .padding(3.dp)
                            )
                        }
                    }

                    Button(
                        onClick = {
                            navController.navigate("homepage")
                        },
                        colors = ButtonDefaults.buttonColors(Color(0xFFffc107))
                    ) {
                        Text(
                            "MAIN MENU", color = Color.White, fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(5.dp), fontSize = 17.sp
                        )
                    }
                },
                modifier = Modifier
                    .height(550.dp),
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "GAME OVER", fontSize = 30.sp, color = Color(0xFFffc107),
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                text = {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Image(painter = painterResource(id = R.drawable.winner), contentDescription = "Winner Icon")
                        Text(
                            winner, fontSize = 30.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            "IS THE WINNER", fontSize = 30.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            )
        }
//Exit and restart button
        Button(
            onClick = { showDialogReference2 = true },
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 23.dp, end = 28.dp)
                .size(55.dp),
            colors = ButtonDefaults.buttonColors(Color.White)
        ) {
            Text("X", fontSize = 28.sp, textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold, color = Color.Black)
        }

        //game over dialog box
        if(showDialogReference2){
            AlertDialog(
                onDismissRequest = {},
                confirmButton = {
                    Button(
                        onClick = { showDialogReference2 = false },
                        modifier = Modifier
                            .padding(2.dp)
                            .width(160.dp),
                        colors = ButtonDefaults.buttonColors(Color.Green)
                    ) {
                        Text(
                            "RESUME", color = Color.White,
                            fontWeight = FontWeight.Bold, fontSize = 17.sp
                        )
                    }

                    Button(
                        onClick = { navController.navigate("gamepage") },
                        modifier = Modifier
                            .padding(2.dp)
                            .width(160.dp),
                        colors = ButtonDefaults.buttonColors(Color.Blue)
                    ) {
                        Text(
                            "RESTART", color = Color.White,
                            fontWeight = FontWeight.Bold, fontSize = 17.sp
                        )
                    }

                    Button(
                    onClick = { navController.navigate("homepage") },
                    modifier = Modifier
                        .padding(2.dp)
                        .width(160.dp),
                    colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(
                        "MAIN MENU", color = Color.White,
                        fontWeight = FontWeight.Bold, fontSize = 17.sp
                    )
                }},
                modifier = Modifier
                    .height(235.dp)
                    .width(200.dp)
            )
        }
    }
}