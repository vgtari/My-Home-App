package com.example.myhomeapp.ui.theme.pages.home


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myhomeapp.navigation.ROUTE_ABOUT
import com.example.myhomeapp.navigation.ROUTE_BEDSITTER
import com.example.myhomeapp.navigation.ROUTE_HOUSES
import com.example.myhomeapp.navigation.ROUTE_LOGIN
import com.example.myhomeapp.navigation.ROUTE_PENTHOUSE

import com.example.myhomeapp.navigation.ROUTE_SIGNUP
import com.example.myhomeapp.ui.theme.MyHomeAppTheme


@Composable
fun HomeScreen(navController: NavHostController) {
    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Welcome to home screen",
            color = Color.Blue,
            fontSize = 30.sp,
            fontFamily = androidx.compose.ui.text.font.FontFamily.Cursive)

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.navigate(ROUTE_LOGIN) }) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.navigate(ROUTE_SIGNUP) }) {
            Text(text = "Signup")
        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.navigate(ROUTE_ABOUT) }) {
            Text(text = "About")
        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.navigate(ROUTE_HOUSES) }) {
            Text(text = "Houses")
        }

    }
}
@Preview
@Composable
fun HomeScreenPreview() {
    MyHomeAppTheme {
        HomeScreen(rememberNavController())
    }
}