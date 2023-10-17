package com.example.interviewtestandroidapp.navigation

sealed class NavigationScreen(val route : String){

    object SignInScreen : NavigationScreen(route = "signInScreen")
    object HomeScreen : NavigationScreen(route = "homeScreen" + "/{email_key}"){
        fun getFullRoute(email: String): String {
            return "homeScreen" + "/$email"
        }
    }
    object DetailScreen : NavigationScreen(route = "detailScreen" + "/{data_key}"){
        fun getFullRoute(data: String): String {
            return "detailScreen" + "/$data"
        }
    }

}
