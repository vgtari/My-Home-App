package com.example.myhomeapp.ui.theme.pages.about

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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myhomeapp.R
import com.example.myhomeapp.ui.theme.MyHomeAppTheme

@Composable
fun AboutScreen(ignoredNavController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.cage),
            contentDescription = "Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
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
        Row (modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically){
            Icon(painter = painterResource(id = R.drawable.home),
                contentDescription =null,
                Modifier.size(25.dp),
                tint = Color.Cyan)

            Spacer(modifier = Modifier.width(20.dp))

            Text(text = "About App",
                color = Color.Cyan,
                fontSize = 30.sp,
                textAlign = TextAlign.Left,
                fontFamily = FontFamily.Monospace
            )
        }

        Divider(color = Color.White,
            thickness = 2.dp, modifier = Modifier.padding(10.dp))

        Text(
            textAlign = TextAlign.Center,
            text = "-> My Home is a house-finding app, that helps the user locate a suitable and economic house to settle. ",
            color = Color.Red,
            fontSize = 20.sp)

        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically){
            Icon(painter = painterResource(id = R.drawable.home),
                contentDescription =null,
                Modifier.width(25.dp),
                tint = Color.Cyan)

            Spacer(modifier = Modifier.width(20.dp))

            Text(text = "The Creator",
                color = Color.Cyan,
                fontSize = 30.sp,
                textAlign = TextAlign.Left,
                fontFamily = FontFamily.Monospace)
        }

            Divider(color = Color.White,
                thickness = 2.dp, modifier = Modifier.padding(10.dp))

            Text(
                textAlign = TextAlign.Center,
                text = "-> The Application was created by Victor Gitari-eMobilis Student-",
                color = Color.Red,
                fontSize = 20.sp)

        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically){
            Icon(painter = painterResource(id = R.drawable.home),
                contentDescription =null,
                Modifier.width(25.dp),
                tint = Color.Cyan)

            Spacer(modifier = Modifier.width(20.dp))

            Text(text = "Aims & Goals",
                color = Color.Cyan,
                fontSize = 30.sp,
                textAlign = TextAlign.Left,
                fontFamily = FontFamily.Monospace)
        }

        Divider(color = Color.White,
            thickness = 2.dp, modifier = Modifier.padding(10.dp))

        Text(
            textAlign = TextAlign.Center,
            text = "-> My Home will enable the user to view, select and book the house that they find suitable.They can therefore contact the respective offices and get the required information to move in."
            + "Eventually, it will easen the burden of roaming long distances looking for houses",
            color = Color.Red,
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