package com.example.myhomeapp.ui.theme.pages.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myhomeapp.R
import com.example.myhomeapp.data.AuthRepository
import com.example.myhomeapp.navigation.ROUTE_ABOUT
import com.example.myhomeapp.navigation.ROUTE_ADD_HOUSE
import com.example.myhomeapp.navigation.ROUTE_INVENTORY

import com.example.myhomeapp.navigation.ROUTE_SIGNUP
import com.example.myhomeapp.navigation.ROUTE_UPDATE_HOUSE
import com.example.myhomeapp.navigation.ROUTE_VIEW_HOUSE
import com.example.myhomeapp.ui.theme.MyHomeAppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.cage),
            contentDescription ="Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current

Icon(
    painter = painterResource(id = R.drawable.home),
    contentDescription =null,
    tint = Color.Red,
    modifier = Modifier.size(70.dp)
    )
        Text(text = "MY HOME",
            color = Color.Red,
            fontSize = 30.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold)


Spacer(modifier = Modifier.height(90.dp))


        Text(text = "Login here",
            color = Color.Red,
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            textDecoration = TextDecoration.Underline,
            fontWeight = FontWeight.Bold)

        var email by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email *")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(20.dp))

       Button(onClick = { navController.navigate(ROUTE_INVENTORY)},
           modifier = Modifier.fillMaxWidth(),
           colors = ButtonDefaults.buttonColors(Color.Red)) {
Text(text = "LOGIN",
    Modifier.padding(vertical = 10.dp))
       }

        Spacer(modifier = Modifier.height(10.dp))
Divider(color = Color.White,
    thickness = 2.dp,
    modifier = Modifier.padding(10.dp))

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { navController.navigate(ROUTE_SIGNUP)},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Red)) {
            Text(text = "No Account? SIGNUP",
                Modifier.padding(vertical = 10.dp))
        }

        Spacer(modifier = Modifier.height(20.dp))


    }


}
@Preview
@Composable
fun LoginScreenPreview(){
    MyHomeAppTheme {
        LoginScreen(rememberNavController() )
    }
}

