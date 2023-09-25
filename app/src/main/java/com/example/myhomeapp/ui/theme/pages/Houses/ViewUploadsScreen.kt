package com.example.myhomeapp.ui.theme.pages.Houses

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.myhomeapp.data.HouseRepository
import com.example.myhomeapp.models.Upload
import com.example.myhomeapp.navigation.ROUTE_UPDATE_HOUSE
import com.example.myhomeapp.ui.theme.MyHomeAppTheme

@Composable
fun ViewUploadsScreen(navController: NavHostController) {
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

        var context = LocalContext.current
        var houseRepository = HouseRepository(navController, context)


        val emptyUploadState = remember { mutableStateOf(Upload("","","","","")) }
        var emptyUploadsListState = remember { mutableStateListOf<Upload>() }

        var uploads = houseRepository.viewUploads(emptyUploadState, emptyUploadsListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "View Houses",
                fontSize = 40.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.White)


            Spacer(modifier = Modifier.height(20.dp))

            val sections = (0 until 25).toList().chunked(5)

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                items(uploads){
                    UploadItem(
                        image = it.image,
                        name = it.name,
                        description = it.description,
                        price = it.price,
                        id = it.id,
                        navController = navController,
                        houseRepository = houseRepository
                    )
                }

            }

        }
    }
}


@Composable
fun UploadItem(image:String,name:String, description:String, price:String, id:String,
               navController:NavHostController, houseRepository:HouseRepository) {

    val paddingModifier  = Modifier.padding(10.dp)
    Card(elevation = CardDefaults.cardElevation(
        defaultElevation = 6.dp
    ),
        modifier = Modifier
            .size(width = 240.dp, height = 300.dp)
    ){

        Image(
            painter = painterResource(id = R.drawable.crib),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(128.dp)
                .clip(RoundedCornerShape(10))

        )
        Text(text = name,
            modifier = Modifier.padding(30.dp,10.dp,10.dp),)
        Text(text = description,
            modifier = Modifier.padding(30.dp,10.dp,10.dp),)
        Text(text = price,
            modifier = Modifier.padding(30.dp,10.dp,10.dp),)

        Button(onClick = {
            houseRepository.deleteHouse(id)
        },
            colors = ButtonDefaults.buttonColors(Color.Red)
        ) {
            Text(text = "Delete")
        }
        Button(onClick = {
            navController.navigate("$ROUTE_UPDATE_HOUSE/$id")
        }) {
            Text(text = "Update")
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun ViewUploadsScreenPreview() {
    MyHomeAppTheme {
        ViewUploadsScreen(navController = rememberNavController())
    }
}