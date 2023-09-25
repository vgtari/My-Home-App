package com.example.myhomeapp.ui.theme.pages.Inventory

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myhomeapp.R
import com.example.myhomeapp.navigation.ROUTE_ADD_HOUSE
import com.example.myhomeapp.navigation.ROUTE_HOME
import com.example.myhomeapp.navigation.ROUTE_UPDATE_HOUSE
import com.example.myhomeapp.navigation.ROUTE_VIEW_HOUSE
import com.example.myhomeapp.navigation.ROUTE_VIEW_UPLOADS
import com.example.myhomeapp.ui.theme.MyHomeAppTheme

@Composable
fun InventoryScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.cage),
            contentDescription ="Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,) {

        Icon(
            painter = painterResource(id = R.drawable.home),
            contentDescription =null,
            Modifier.size(80.dp),
            tint = Color.Red
        )

        Text(
            text = "MY HOME",
            color = Color.Red,
            fontSize = 40.sp,
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Inventory",
            color = Color.Cyan,
            fontSize = 25.sp,
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Center
        )



        Spacer(modifier = Modifier.height(50.dp))

        Button(onClick = {navController.navigate(ROUTE_ADD_HOUSE)},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Red),) {
            Text(text = "Add House",
                color = Color.White,
                fontSize = 20.sp,
                modifier =  Modifier.padding())
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {navController.navigate(ROUTE_VIEW_UPLOADS)},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Red),) {
            Text(text = "View House",
                color = Color.White,
                fontSize = 20.sp,
                modifier =  Modifier.padding())
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {navController.navigate(ROUTE_UPDATE_HOUSE) },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Red),) {
            Text(text = "Update House",
                color = Color.White,
                fontSize = 20.sp,
                modifier =  Modifier.padding())
        }

        Spacer(modifier = Modifier.height(30.dp))



        Divider(
            color = Color.White,
            thickness = 2.dp,
            modifier = Modifier.padding(10.dp)
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Nothing to see here?", color = Color.Cyan)
            TextButton(onClick = {navController.navigate(ROUTE_HOME)}) {
                Text(text = "Back to Home", color = Color.Red)
            }


        }



    }
}


@Preview
@Composable
fun InventoryScreenPreview() {
    MyHomeAppTheme {
        InventoryScreen(rememberNavController())
    }
}