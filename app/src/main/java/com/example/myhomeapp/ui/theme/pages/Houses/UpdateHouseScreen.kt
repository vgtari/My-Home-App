package com.example.myhomeapp.ui.theme.pages.Houses

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.platform.LocalContext
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
import com.example.myhomeapp.data.HouseRepository
import com.example.myhomeapp.models.House
import com.example.myhomeapp.models.Upload
import com.example.myhomeapp.ui.theme.MyHomeAppTheme
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateHouseScreen(navController: NavHostController, id:String) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current
        var image by remember{ mutableStateOf("") }
        var name by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }
        var price by remember { mutableStateOf("") }

        var currentDataRef = FirebaseDatabase.getInstance().reference
            .child("Uploads/$id")
        currentDataRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var upload = snapshot.getValue(Upload::class.java)
                image = upload!!.image
                name = upload!!.name
                description = upload!!.description
                price = upload!!.price
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })

        Text(
            text = "Add Houses",
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Red,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )


        var uploadImage by remember { mutableStateOf(TextFieldValue(image)) }
        var uploadName by remember { mutableStateOf(TextFieldValue(name)) }
        var uploadDescription by remember { mutableStateOf(TextFieldValue(description)) }
        var uploadPrice by remember { mutableStateOf(TextFieldValue(price)) }





        OutlinedTextField(
            value = uploadName,
            onValueChange = { uploadName = it },
            label = { Text(text = "House name *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = uploadDescription,
            onValueChange = { uploadDescription = it },
            label = { Text(text = "House Description *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = uploadPrice,
            onValueChange = { uploadPrice = it },
            label = { Text(text = "House price *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            //-----------WRITE THE UPDATE LOGIC HERE---------------//
            var houseRepository = HouseRepository(navController, context)
            houseRepository.updateHouse(uploadImage.text.trim(),uploadName.text.trim(),uploadDescription.text.trim(),uploadPrice.text.trim(), id)
        }
        )
        {
            Text(text = "Update")
        }

    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun UpdateHouseScreenPreview() {
MyHomeAppTheme {
    UpdateHouseScreen(navController = rememberNavController(), id ="" )
}
}