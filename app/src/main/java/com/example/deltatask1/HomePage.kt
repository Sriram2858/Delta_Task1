package com.example.deltatask1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Mainpage(navigationToPlayerdatapage:()->Unit){
    val fontFamily = FontFamily(
        Font(R.font.leckerlione_regular, FontWeight.Normal)
    )
    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF1b1110), Color(0xFFcc7d77))
    )
    var showDialog by remember { mutableStateOf(false) }
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFfec271), Color(0xFFff606d))
                )
            ))
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "COLOR CONQUEST",
                style = TextStyle(
                    brush = gradient,
                    fontSize = 68.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = fontFamily,
                ),
                modifier = Modifier.padding(vertical = 105.dp),
            )

            Button(
                modifier = Modifier
                    .height(68.dp)
                    .width(210.dp)
                    .offset(x = (-30).dp, y = (320).dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2fb6f0)),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp),
                onClick = { navigationToPlayerdatapage() },
            ) {
                Text("PLAY", fontSize = 35.sp, fontWeight = FontWeight.Bold)
            }

            Button(
                modifier = Modifier
                    .height(68.dp)
                    .offset(x = 140.dp, y = 255.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3b4276)),
                onClick = { showDialog = true },
            ) {
                Text("?", fontSize = 40.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
    Myimage()

    if(showDialog){
        AlertDialog(onDismissRequest = { showDialog = false },
            confirmButton = { /*TODO*/ },
            modifier = Modifier.height(500.dp),
            title = {Text("Instructions", fontWeight = FontWeight.Bold)},
            text = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    Text("1st Turn of each player:", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text("Players can choose any tile on the grid on this turn only. Clicking a tile assigns your colour to it and awards you 3 points on that tile.\n", fontSize = 20.sp)
                    Text("Subsequent Turns:", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text("After the first turn, players can only click on tiles that already have their own colour. Clicking a tile with your colour adds 1 point to that tile.The background colour indicates the next player.\n", fontSize = 20.sp)
                    Text("Conquest and Expansion:", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text("When a tile with your colour reaches 4 points, it triggers an expansion:\n" +
                            "The colour completely disappears from the original tile.\n" +
                            "Your colour spreads to the four surrounding squares in a plus shape (up, down, left, right).\n" +
                            "Each of the four surrounding squares gains 1 point with your colour.\n" +
                            "If any of the four has your opponent’s colour, you conquer the opponent's points on that tile while adding a point to it, completely erasing theirs.\n" +
                            "The expansion is retriggered if the neighbouring tile as well reaches 4 points this way.\n" +
                            "Players take turns clicking on tiles and the objective is to eliminate your opponent's colour entirely from the screen.", fontSize = 20.sp)
                }
            }
            )
    }
}

@Composable
fun Myimage(){
    Image(painter = painterResource(id = R.drawable.icons), contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .offset(y = (90).dp))
}