package com.example.myhomeapp.navigation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myhomeapp.ui.theme.pages.Houses.RoomsScreen
import com.example.myhomeapp.ui.theme.pages.Products.BedsitterScreen
import com.example.myhomeapp.ui.theme.pages.Products.OneBedroomScreen
import com.example.myhomeapp.ui.theme.pages.Products.PenthouseScreen
import com.example.myhomeapp.ui.theme.pages.Products.ThreeBedroomScreen
import com.example.myhomeapp.ui.theme.pages.Products.TwoBedroomScreen

import com.example.myhomeapp.ui.theme.pages.about.AboutScreen
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
        composable(ROUTE_HOUSES){
            RoomsScreen(navController)
        }
        composable(ROUTE_BEDSITTER){
            BedsitterScreen(navController)
        }
        composable(ROUTE_ONEBEDROOM){
            OneBedroomScreen(navController)
        }
        composable(ROUTE_TWOBEDROOM){
            TwoBedroomScreen(navController)
        }
        composable(ROUTE_THREEBEDROOM){
            ThreeBedroomScreen(navController)
        }
        composable(ROUTE_PENTHOUSE){
            PenthouseScreen(navController)
        }

    }
}


