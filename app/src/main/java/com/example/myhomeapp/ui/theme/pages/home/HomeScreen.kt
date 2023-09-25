package com.example.myhomeapp.ui.theme.pages.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myhomeapp.R
import com.example.myhomeapp.navigation.ROUTE_ABOUT

import com.example.myhomeapp.navigation.ROUTE_LOGIN


import com.example.myhomeapp.navigation.ROUTE_SIGNUP

import com.example.myhomeapp.ui.theme.MyHomeAppTheme


@Composable
fun HomeScreen(navController: NavHostController) {

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.cage),
            contentDescription = "Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = R.drawable.home),
            contentDescription = null,
            tint = Color.Red,
            modifier = Modifier.size(70.dp)
        )
        Text(
            text = "MY HOME",
            color = Color.Red,
            fontSize = 30.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Welcome to home screen",
            color = Color.Red,
            fontSize = 30.sp,
            fontFamily = androidx.compose.ui.text.font.FontFamily.Cursive
        )


        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.navigate(ROUTE_LOGIN) },
            modifier = Modifier.fillMaxWidth(),
            colors =ButtonDefaults.buttonColors(Color.Red),
        ) {
            Text(text = "LOGIN",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.padding())
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { navController.navigate(ROUTE_SIGNUP) },
            modifier = Modifier.fillMaxWidth(),
            colors =ButtonDefaults.buttonColors(Color.Red),
        ) {
            Text(text = "No Account? SIGNUP",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.padding())
        }

        Spacer(modifier = Modifier.height(200.dp))

        Row {


            Button(onClick = { navController.navigate(ROUTE_ABOUT) },
                    colors =ButtonDefaults.buttonColors(Color.Red),) {
                Text(
                    text = "About",
                    color = Color.White
                )
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