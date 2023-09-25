package com.example.myhomeapp.navigation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myhomeapp.ui.theme.pages.Houses.AddHouseScreen
import com.example.myhomeapp.ui.theme.pages.Houses.UpdateHouseScreen


import com.example.myhomeapp.ui.theme.pages.Houses.ViewHouseScreen
import com.example.myhomeapp.ui.theme.pages.Houses.ViewUploadsScreen
import com.example.myhomeapp.ui.theme.pages.Inventory.InventoryScreen
import com.example.myhomeapp.ui.theme.pages.about.AboutScreen
import com.example.myhomeapp.ui.theme.pages.home.HomeScreen
import com.example.myhomeapp.ui.theme.pages.home.LoginScreen
import com.example.myhomeapp.ui.theme.pages.signup.SignupScreen
import com.example.myhomeapp.ui.theme.pages.splash.SplashScreen


@Composable
fun AppNavHost (modifier: Modifier = Modifier,
                navController: NavHostController = rememberNavController(),
                startDestination:String = ROUTE_SPLASH) {
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
        composable(ROUTE_ADD_HOUSE){
            AddHouseScreen(navController)
        }
        composable(ROUTE_VIEW_HOUSE){
            ViewHouseScreen(navController)
        }
        composable("$ROUTE_UPDATE_HOUSE/{id}") { passedData ->
            UpdateHouseScreen(navController, passedData.arguments?.getString("id")!!)
        }
        composable(ROUTE_SPLASH){
           SplashScreen(navController)
        }
        composable(ROUTE_INVENTORY){
           InventoryScreen(navController)
        }

        composable(ROUTE_VIEW_UPLOADS){
            ViewUploadsScreen(navController)
        }




    }
}


