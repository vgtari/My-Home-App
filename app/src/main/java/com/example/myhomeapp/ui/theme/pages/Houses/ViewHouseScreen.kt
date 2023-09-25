package com.example.myhomeapp.ui.theme.pages.Houses


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myhomeapp.R
import com.example.myhomeapp.data.HouseRepository
import com.example.myhomeapp.models.Upload
import com.example.myhomeapp.navigation.ROUTE_UPDATE_HOUSE

@Composable
fun ViewHouseScreen(navController: NavHostController){
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


        val emptyHouseState = remember { mutableStateOf(Upload("","","","","")) }
        var emptyHousesListState = remember { mutableStateListOf<Upload>() }

        var houses = houseRepository.viewHouse(emptyHouseState, emptyHousesListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All Houses",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(3)
            ) {
                items(houses) {
                    HouseItem(
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
fun HouseItem(name:String, description:String, price:String, id:String,
             navController:NavHostController, houseRepository:HouseRepository) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name)
        Text(text = description)
        Text(text = price)
        Button(onClick = {
            houseRepository.deleteHouse(id)
        }) {
            Text(text = "Delete")
        }
        Button(onClick = {
            navController.navigate(ROUTE_UPDATE_HOUSE+"/$id")
        }) {
            Text(text = "Update")
        }
    }
}