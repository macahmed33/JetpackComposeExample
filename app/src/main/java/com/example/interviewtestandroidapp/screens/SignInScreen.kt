package com.example.interviewtestandroidapp.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.interviewtestandroidapp.navigation.NavigationScreen

@Composable
fun SignInScreen(navController: NavHostController) {

    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column (modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            heading()
            Spacer(modifier = Modifier.height(50.dp))
            createSignInTextField{
                email = it
            }
            Spacer(modifier = Modifier.height(10.dp))
            createPassTextField{
                pass = it
            }
            Spacer(modifier = Modifier.height(10.dp))
            registerText()
            Spacer(modifier = Modifier.height(20.dp))
            signInBtn(navController,email,pass)
        }
    }

}

@Composable
fun heading(){
    Text(text = "SIGN IN",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun createSignInTextField(onTextChanged: (String) -> Unit){
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        label = { Text(text = "Enter Email") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        onValueChange = { it ->
            text = it
            onTextChanged(it.text)
        }
    )
}

@Composable
fun createPassTextField(onPassChanged: (String) -> Unit){
    var newPass by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = newPass,
        label = { Text(text = "Enter Pass") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        onValueChange = { it ->
            newPass = it
            onPassChanged(it.text)
        }
    )
}

@Composable
fun registerText(){
    Row{
        Text(text = "Don't have an account? ",
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal
        )
        Text(text = "Resgister Here ",
            color = Color.Blue,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun signInBtn(navController: NavHostController, email: String, pass: String) {
    val context = LocalContext.current
    Button(onClick = {
        print("SignIn Click")
        if (validation(context,email,pass)) {
            navController.navigate(NavigationScreen.HomeScreen.getFullRoute(email = email))  //NavigationScreen.HomeScreen.route
        }
    }, modifier = Modifier.size(width = 130.dp, height = 40.dp) ) {
        Text(text = "Sign In")
    }
}

fun validation(context: Context, email: String, pass: String): Boolean{
    var isValid = true
    if (email.isEmpty()){
        Toast.makeText(context,"Please Enter Email",Toast.LENGTH_LONG).show()
        return false
    }
    if (pass.isEmpty()){
        Toast.makeText(context,"Please Enter Password",Toast.LENGTH_LONG).show()
        return false
    }
    return isValid
}
