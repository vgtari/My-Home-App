package com.example.myhomeapp.ui.theme.pages.Houses



import android.widget.Toast
import androidx.compose.foundation.background
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myhomeapp.navigation.ROUTE_BEDSITTER
import com.example.myhomeapp.navigation.ROUTE_ONEBEDROOM
import com.example.myhomeapp.navigation.ROUTE_PENTHOUSE
import com.example.myhomeapp.navigation.ROUTE_THREEBEDROOM
import com.example.myhomeapp.navigation.ROUTE_TWOBEDROOM
import com.example.myhomeapp.ui.theme.MyHomeAppTheme

@Composable
fun RoomsScreen(navController: NavHostController) {

    val mContext= LocalContext.current
    Column (modifier = Modifier

        .fillMaxSize()
        .background(Color.Unspecified),
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Welcome to Rooms' Screen",
            color = Color.Magenta,
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive)


        Button(onClick = {
            navController.navigate(ROUTE_BEDSITTER)
            Toast.makeText(mContext,"Welcome to bedsitter",Toast.LENGTH_LONG).show()
        }) {
            Text(text = "Bedsitter")
        }
        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            navController.navigate(ROUTE_ONEBEDROOM)
            Toast.makeText(mContext,"Welcome to OneBedroom Screen",Toast.LENGTH_LONG).show()
        }) {
            Text(text = "OneBedroom")
        }
        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            navController.navigate(ROUTE_TWOBEDROOM)
            Toast.makeText(mContext,"Welcome to TwoBedroom Screen",Toast.LENGTH_LONG).show()
        }) {
            Text(text = "TwoBedroom")
        }
        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            navController.navigate(ROUTE_THREEBEDROOM)
            Toast.makeText(mContext,"Welcome to ThreeBedroom Screen",Toast.LENGTH_LONG).show()
        }) {
            Text(text = "ThreeBedroom")
        }
        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            navController.navigate(ROUTE_PENTHOUSE)
            Toast.makeText(mContext,"Welcome to Penthouse Screen",Toast.LENGTH_LONG).show()
        }) {
            Text(text = "Penthouse")
        }


    }
  
}
@Preview
@Composable
fun RoomsPreview() {
    MyHomeAppTheme {
        RoomsScreen(rememberNavController())
    }
}