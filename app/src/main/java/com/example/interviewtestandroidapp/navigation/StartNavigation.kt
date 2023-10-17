package com.example.interviewtestandroidapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.interviewtestandroidapp.model.AssociatedDrug
import com.example.interviewtestandroidapp.screens.DetailScreen
import com.example.interviewtestandroidapp.screens.HomeScreen
import com.example.interviewtestandroidapp.screens.SignInScreen
import com.google.gson.Gson

@Composable
fun startNavigation(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationScreen.SignInScreen.route){

        composable(NavigationScreen.SignInScreen.route){
            SignInScreen(navController)
        }
        composable(
            route = NavigationScreen.HomeScreen.route,
            arguments = listOf(
                navArgument(name = "email_key"){
                    type = NavType.StringType
                }
            )
        ){
            val email = it.arguments?.getString("email_key")
            HomeScreen(navController = navController, email = email)
        }
        composable(route = NavigationScreen.DetailScreen.route,
        arguments = listOf(
            navArgument("data_key"){
                type = NavType.StringType
            }
        )
            ){
            val data = it.arguments?.getString("data_key")

            DetailScreen(navController, data= data)
        }

    }

}