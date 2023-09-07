package com.example.myhomeapp.ui.theme.pages.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myhomeapp.ui.theme.MyHomeAppTheme

@Composable
fun AboutScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Welcome to About screen",
            fontFamily = FontFamily.Serif,
            color = Color.Yellow,
            fontSize = 20.sp)

    }
}

@Preview
@Composable
fun AboutScreenPreview() {
     MyHomeAppTheme {
         AboutScreen(rememberNavController())
     }
}