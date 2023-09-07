package com.example.myhomeapp.navigation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myhomeapp.ui.theme.pages.OneBedroom.AddOneBedroomScreen

import com.example.myhomeapp.ui.theme.pages.OneBedroom.ViewOneBedroomScreen
import com.example.myhomeapp.ui.theme.pages.Penthouse.AddPenthouseScreen
import com.example.myhomeapp.ui.theme.pages.Penthouse.ViewPenthouseScreen
import com.example.myhomeapp.ui.theme.pages.ThreeBedroom.AddThreeBedroomScreen import com.example.myhomeapp.ui.theme.pages.ThreeBedroom.ViewThreeBedroomScreen
import com.example.myhomeapp.ui.theme.pages.TwoBedroom.AddTwoBedroomScreen
import com.example.myhomeapp.ui.theme.pages.TwoBedroom.ViewTwoBedroomScreen
import com.example.myhomeapp.ui.theme.pages.about.AboutScreen
import com.example.myhomeapp.ui.theme.pages.bedsitter.AddBedsitterScreen
import com.example.myhomeapp.ui.theme.pages.bedsitter.ViewBedsitterScreen
import com.example.myhomeapp.ui.theme.pages.home.HomeScreen
import com.example.myhomeapp.ui.theme.pages.home.LoginScreen
import com.example.myhomeapp.ui.theme.pages.signup.SignupScreen


@Composable
fun AppNavHost (modifier: Modifier = Modifier,
                navController: NavHostController = rememberNavController(),
                startDestination:String = ROUTE_LOGIN) {
    NavHost(navController = navController,
        modifier = modifier, startDestination = startDestination){

        composable(ROUTE_HOME){
            HomeScreen(navController)
        }
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }

        composable(ROUTE_SIGNUP){
            SignupScreen(navController)
        }

        composable(ROUTE_ABOUT){
            AboutScreen(navController)
        }
        composable(ROUTE_BEDSITTER){
            AddBedsitterScreen(navController)
        }
        composable(ROUTE_BEDSITTER){
            ViewBedsitterScreen(navController)
        }
        composable(ROUTE_ONEBEDROOM){
            AddOneBedroomScreen(navController)
        }
        composable(ROUTE_ONEBEDROOM){
            ViewOneBedroomScreen(navController)
        }
        composable(ROUTE_TWOBEDROOM){
            AddTwoBedroomScreen(navController)
        }
        composable(ROUTE_TWOBEDROOM){
            ViewTwoBedroomScreen(navController)
        }
        composable(ROUTE_THREEBEDROOM){
            AddThreeBedroomScreen(navController)
        }
        composable(ROUTE_THREEBEDROOM){
            ViewThreeBedroomScreen(navController)
        }

        composable(ROUTE_THREEBEDROOM){
            AddPenthouseScreen(navController)
        }
        composable(ROUTE_THREEBEDROOM){
            ViewPenthouseScreen(navController)
        }


    }
}


