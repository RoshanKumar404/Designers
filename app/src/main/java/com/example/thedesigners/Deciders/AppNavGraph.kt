package com.example.thedesigners.Deciders

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
//import com.example.thedesigners.MainScreen
import com.example.thedesigners.Screens.AiEditor
import com.example.thedesigners.Screens.Colors
import com.example.thedesigners.Screens.Feedback
import com.example.thedesigners.Screens.ImageImports
import com.example.thedesigners.Screens.MainScreen
import com.example.thedesigners.SealedScreensCode

@Composable
fun AppNavGraph(){
    val navController= rememberNavController()
    NavHost(
        navController=navController,
                startDestination = SealedScreensCode.Main.Screens
    ){
        composable(SealedScreensCode.Main.Screens){
            MainScreen(navController)
        }
        composable(SealedScreensCode.Colors.Screens) {
            Colors()
        }
        composable (SealedScreensCode.AiEditor.Screens){
            AiEditor()
        }
        composable(SealedScreensCode.ImageImports.Screens) {
            ImageImports()
        }
        composable(SealedScreensCode.Feedback.Screens) {
            Feedback()
        }


    }
//    NavHost()
}