package com.example.myhomeapp.ui.theme.pages.home


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import com.example.myhomeapp.navigation.ROUTE_ONEBEDROOM
import com.example.myhomeapp.navigation.ROUTE_PENTHOUSE

import com.example.myhomeapp.navigation.ROUTE_SIGNUP
import com.example.myhomeapp.navigation.ROUTE_THREEBEDROOM
import com.example.myhomeapp.navigation.ROUTE_TWOBEDROOM
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
        Row {
            Button(onClick = { navController.navigate(ROUTE_BEDSITTER) }) {
                Text(text = "Add Bedsitter")
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = { navController.navigate(ROUTE_BEDSITTER) }) {
                Text(text = "View Bedsitter")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Button(onClick = { navController.navigate(ROUTE_ONEBEDROOM)}) {
                Text(text = "Add Onebedroom")
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = { navController.navigate(ROUTE_ONEBEDROOM) }) {
                Text(text = "View Onebedroom")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Button(onClick = { navController.navigate(ROUTE_TWOBEDROOM) }) {
                Text(text = "Add Twobedroom")
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = { navController.navigate(ROUTE_TWOBEDROOM) }) {
                Text(text = "View Twobedroom")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Button(onClick = { navController.navigate(ROUTE_THREEBEDROOM) }) {
                Text(text = "Add Threebedroom")
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = { navController.navigate(ROUTE_THREEBEDROOM) }) {
                Text(text = "View Threebedroom")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Button(onClick = { navController.navigate(ROUTE_PENTHOUSE) }) {
                Text(text = "Add Penthouse")
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = { navController.navigate(ROUTE_PENTHOUSE) }) {
                Text(text = "View Penthouse")
            }
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