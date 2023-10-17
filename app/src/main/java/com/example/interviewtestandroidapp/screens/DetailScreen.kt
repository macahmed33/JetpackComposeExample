package com.example.interviewtestandroidapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.interviewtestandroidapp.model.AssociatedDrug
import com.google.gson.Gson
import com.example.interviewtestandroidapp.R

@Composable
fun DetailScreen(navController: NavController, data : String?){
    val drug : AssociatedDrug = Gson().fromJson(data,AssociatedDrug::class.java)

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.medicine),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Surface(
            color = Color.Black.copy(alpha = 0.7f),
            modifier = Modifier.fillMaxSize()
        ){
            Column(modifier = Modifier.fillMaxWidth().padding(16.dp),
            ) {
                Text(text = "Detail Screen",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(40.dp))
                Text(text = "Name: ${drug.name}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Dose: ${drug.dose}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Strength: ${drug.strength}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }





    
}