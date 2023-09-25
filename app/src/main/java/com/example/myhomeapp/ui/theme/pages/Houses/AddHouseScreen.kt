package com.example.myhomeapp.ui.theme.pages.Houses


import android.content.Context
import android.content.res.Configuration
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myhomeapp.R
import com.example.myhomeapp.data.HouseRepository
import com.example.myhomeapp.models.House
import com.example.myhomeapp.ui.theme.MyHomeAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddHouseScreen(navController: NavHostController){
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
        Text(
            text = "Add House",
            fontSize = 30.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Cyan,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )
        var houseName by remember { mutableStateOf(TextFieldValue("")) }
        var houseDescription by remember { mutableStateOf(TextFieldValue("")) }
        var housePrice by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(
            value = houseName,
            onValueChange = { houseName = it },
            label = { Text(text = "House name ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = houseDescription,
            onValueChange = { houseDescription = it },
            label = { Text(text = "Description") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = housePrice,
            onValueChange = { housePrice = it },
            label = { Text(text = "Price") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            //-----------WRITE THE SAVE LOGIC HERE---------------//
            var houseRepository = HouseRepository(navController,context)
            houseRepository.saveHouse(houseName.text.trim(), houseDescription.text.trim(),
                housePrice.text)
        }) {
            Text(text = "Save",

            )
        }
        Spacer(modifier = Modifier.height(20.dp))



        ImagePicker(modifier = Modifier, context, navController, houseName.text.trim(), houseDescription.text.trim(), housePrice.text.trim())



    }
}

@Composable
fun ImagePicker(modifier: Modifier = Modifier, context: Context, navController: NavHostController, name:String, description:String, price:String) {
    var hasImage by remember { mutableStateOf(false) }
    var image by remember { mutableStateOf<Uri?>(null) }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            image = uri
        }
    )

    Column(modifier = modifier,) {
        if (hasImage && image != null) {
            val bitmap = MediaStore.Images.Media.
            getBitmap(context.contentResolver,image)
            Image(bitmap = bitmap.asImageBitmap(),
                contentDescription = "Selected image",
                modifier = Modifier
                    .size(200.dp)
                    .padding(30.dp, 10.dp, 10.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp), horizontalAlignment = Alignment.CenterHorizontally,) {
            Button(
                onClick = {
                    imagePicker.launch("image/*")
                },
            ) {
                Text(
                    text = "Select Image"
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                //-----------WRITE THE UPLOAD LOGIC HERE---------------//
                var houseRepository = HouseRepository(navController,context)
                houseRepository.saveHouseWithImage(name, description, price,image!!)


            }) {
                Text(text = "Upload")
            }
        }
    }
}



@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)

@Composable
fun AddHouseScreenPreview() {
    MyHomeAppTheme {
        AddHouseScreen(navController = rememberNavController())
    }
    }