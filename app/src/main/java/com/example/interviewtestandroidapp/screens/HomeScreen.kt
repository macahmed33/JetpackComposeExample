package com.example.interviewtestandroidapp.screens

import android.util.Log.d
import android.widget.ProgressBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.interviewtestandroidapp.Network.Result
import com.example.interviewtestandroidapp.model.*
import com.example.interviewtestandroidapp.navigation.NavigationScreen
import com.google.gson.Gson
import com.example.interviewtestandroidapp.R
import com.example.interviewtestandroidapp.viewModel.HomeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Stack

@Composable
fun HomeScreen(navController: NavHostController ,email : String?) {
    val viewModel : HomeViewModel = hiltViewModel()
    val dataList by viewModel.associatedDrug.collectAsState()
    val errorMsg by viewModel.errorMsg.collectAsState()
    val apiState by viewModel.apiState.collectAsState()
    println("listData: ${dataList.size}")
    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "WELCOME",  //$email
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
            )
        Text(text = "mohib@gmail.com",  //email ?: "-"
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.height(20.dp))
        when (apiState){
            Result.Status.LOADING -> Text(text = "Loading...")
            Result.Status.SUCCESS -> list(navController = navController, dataList = dataList)
            Result.Status.ERROR -> {
                if (dataList.isEmpty()){
                    Text(text = errorMsg)
                }else{
                    Column() {
                        Text(text = errorMsg + "\nThis is Cache Data")
                        list(navController = navController, dataList = dataList)
                    }
                }
            }
        }

    }

    
}

@Composable
fun list(navController: NavHostController, dataList : ArrayList<AssociatedDrug>) {
    val associatedDrugList = java.util.ArrayList<AssociatedDrug>()
    associatedDrugList.addAll(dataList)
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(associatedDrugList){ item ->
            ItemCard(navController= navController, item)
        }
        }
    }

@Composable
fun ItemCard(navController: NavHostController, item: AssociatedDrug) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable {
                val data = Gson().toJson(item, AssociatedDrug::class.java)
                navController.navigate(NavigationScreen.DetailScreen.getFullRoute(data = data))
            }
            .wrapContentHeight()
        ,
        shape = RoundedCornerShape(12),
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.medicine),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 40.dp, height = 100.dp),
                contentScale = ContentScale.Crop,
            )
            Column(Modifier.padding(start = 16.dp, top = 0.dp, bottom = 0.dp, end = 8.dp)) {
                Text(
                    text = item.name ?: "-",
                    style = MaterialTheme.typography.h5,
                    color = MaterialTheme.colors.onSurface,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = item.dose ?: "-",
                    style = MaterialTheme.typography.body2,
                )
                Text(
                    text = item.strength ?: "-",
                    style = MaterialTheme.typography.body2,
                )
            }
        }
    }
}
