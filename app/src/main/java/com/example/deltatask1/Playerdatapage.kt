package com.example.deltatask1

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.format.TextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Playerinfo(navigationToGamePage:()->Unit){

    var player1state by remember{
        mutableStateOf("")
    }

    var player2state by remember{
        mutableStateOf("")
    }

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFfec271), Color(0xFFff606d))
                )
            )
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 25.dp, end = 25.dp))
        {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFffd6b7)),
                shape = CutCornerShape(30.dp),
                border = BorderStroke(2.dp, color = Color(0xFFcdb6b6)),
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth()
                    .offset(y = 55.dp)
                    .shadow(10.dp, CutCornerShape(30.dp)),
            ){
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("PLAYER INFORMATION", fontSize = 25.sp, fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center, color = Color(0xFF000000))
                }
            }
            
/*player1*/ Card(
                modifier = Modifier
                    .height(88.dp)
                    .width(160.dp)
                    .offset(x = 90.dp, y = 178.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF3d4175)),
                shape = RoundedCornerShape(25.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ){
                    TextField(
                        value = player1state,
                        placeholder = {
                            Text("Enter Player-1 Name", fontSize = 13.sp, color = Color.Gray)
                        },
                        onValueChange = {
                            player1state = it
                        },
                        textStyle = LocalTextStyle.current.copy(
                            textAlign = TextAlign.Center
                        ),
                        colors = TextFieldDefaults.textFieldColors(containerColor = Color(0xFF3d4175)
                        )
                    )
                    Text("--------", fontSize = 40.sp, fontWeight = FontWeight.Bold,
                        color = Color(0xFFff5f57), modifier = Modifier.offset(y = 7.dp))
                }
            }
            
            Card(
                modifier = Modifier
                    .height(88.dp)
                    .width(160.dp)
                    .offset(x = 90.dp, y = 207.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF3d4175)),
                shape = RoundedCornerShape(25.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ){
                    TextField(
                        value = player2state,
                        placeholder = {
                            Text("Enter Player-2 Name", fontSize = 13.sp, color = Color.Gray)
                        },
                        onValueChange = {
                            player2state = it
                        },
                        textStyle = LocalTextStyle.current.copy(
                            textAlign = TextAlign.Center
                        ),
                        colors = TextFieldDefaults.textFieldColors(containerColor = Color(0xFF3d4175)
                        )
                    )
                    Text("--------", fontSize = 40.sp, fontWeight = FontWeight.Bold,
                        color = Color(0xFF2fb6f0), modifier = Modifier.offset(y = 7.dp))
                }
            }
            Button(
                onClick = { navigationToGamePage() },
                modifier = Modifier
                    .height(68.dp)
                    .width(200.dp)
                    .offset(y = (470).dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2fb6f0)),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp)
            ) {
                Text("START", fontSize = 30.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
    Myimage2()
    Myimage3()
}

@Composable
fun Myimage2(){
    Image(painter = painterResource(id = R.drawable.icon3), contentDescription = null,
        modifier = Modifier
            .height(260.dp)
            .width(275.dp)
            .offset(x = (-30).dp, y = 205.dp))
}

@Composable
fun Myimage3(){
    Image(painter = painterResource(id = R.drawable.icon4), contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .offset(y = (140).dp))
}