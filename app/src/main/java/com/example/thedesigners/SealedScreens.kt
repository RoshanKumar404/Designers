package com.example.thedesigners

sealed class  SealedScreens(val Screens: String){
    data object Login: SealedScreens("Login")
    data object Main: SealedScreens("Main")
    data object AiEditor: SealedScreens("AiEditor")
    data object Feedback: SealedScreens("Feedback")
    data object  Colors: SealedScreens("Colors")
    data object  ImageImports: SealedScreens("ImageImports")
    data object Notification:SealedScreens("Notification")
    data object Profile:SealedScreens("Profile")
    data object Search: SealedScreens("Search")
    data object  Post: SealedScreens("Post")

}

