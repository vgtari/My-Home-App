package com.example.myhomeapp.ui.theme.pages.signup

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
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
import com.example.myhomeapp.data.AuthRepository
import com.example.myhomeapp.navigation.ROUTE_LOGIN
import com.example.myhomeapp.ui.theme.MyHomeAppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(navController: NavHostController) {
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


        Spacer(modifier = Modifier.height(90.dp))
        Text(text = "Signup here",
            color = Color.Red,
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            textDecoration = TextDecoration.Underline,
            fontWeight = FontWeight.Bold)
        var name by remember { mutableStateOf(TextFieldValue("")) }
        var email by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(value = name,
            onValueChange = { name = it },
            label = { Text(text = "Name *")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email *")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(20.dp))





        Button(onClick = {
            // ------WRITE SIGNUP LOGIC HERE------//
            if (name.text.trim().isEmpty() || email.text.trim().isEmpty() || password.text.trim().isEmpty() ){
                Toast.makeText(context, "Fill all input fields", Toast.LENGTH_SHORT).show()
            }else if (password.text.trim().length < 6){
                Toast.makeText(context, "Password must be at least 6 or more characters", Toast.LENGTH_SHORT).show()
            }else{
                var authRepository = AuthRepository(navController, context)
                authRepository.signup(name.text.trim(),email.text.trim(),password.text.trim())
            }
        }) {
            Text(text = "Signup")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(ROUTE_LOGIN )
        }) {
            Text(text = "Have account? Login" )
        }

    }
}





