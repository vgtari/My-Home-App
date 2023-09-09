package com.example.myhomeapp.ui.theme.pages.splash

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myhomeapp.R
import com.example.myhomeapp.navigation.ROUTE_LOGIN
import com.example.myhomeapp.ui.theme.MyHomeAppTheme
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavHostController){
LaunchedEffect(key1 = true ){
    delay(2000L)
    navController.navigate(ROUTE_LOGIN)
}



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

Spacer(modifier = Modifier.height(100.dp))

        Text(text = "By : Victor Gitari",
            color = Color.Red,
            fontSize = 25.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold)





    }
}


@Preview
@Composable
fun SplashScreenPreview() {
   MyHomeAppTheme {
       SplashScreen(rememberNavController())
   }
}