package com.example.thedesigners.Deciders

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.thedesigners.Screens.BottomScreens.Notification
import com.example.thedesigners.Screens.BottomScreens.Profile
import com.example.thedesigners.Screens.BottomScreens.Search
//import com.example.thedesigners.MainScreen
import com.example.thedesigners.Screens.DrwawerScreens.AiEditor
import com.example.thedesigners.Screens.DrwawerScreens.Colors
import com.example.thedesigners.Screens.DrwawerScreens.Feedback
import com.example.thedesigners.Screens.DrwawerScreens.ImageImports
import com.example.thedesigners.Screens.MainScreen
import com.example.thedesigners.SealedScreens

@Composable
fun AppNavGraph(){
    val navController= rememberNavController()
    NavHost(
        navController=navController,
                startDestination = SealedScreens.Main.Screens
    ){
        composable(SealedScreens.Main.Screens){
            MainScreen(navController)
        }
        composable(SealedScreens.Colors.Screens) {
            Colors()
        }
        composable (SealedScreens.AiEditor.Screens){
            AiEditor()
        }
        composable(SealedScreens.ImageImports.Screens) {
            ImageImports()
        }
        composable(SealedScreens.Feedback.Screens) {
            Feedback()
        }
        composable(SealedScreens.Notification.Screens) {
            Notification()
        }
        composable (SealedScreens.Search.Screens){
            Search()
        }
        composable(SealedScreens.Profile.Screens) {
            Profile()
        }


    }
//    NavHost()
}