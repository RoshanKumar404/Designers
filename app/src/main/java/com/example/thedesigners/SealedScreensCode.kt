package com.example.thedesigners

sealed class  SealedScreensCode(val Screens: String){
    data object Main: SealedScreensCode("Main")
    data object AiEditor: SealedScreensCode("AiEditor")
    data object Feedback: SealedScreensCode("Feedback")
    data object  Colors: SealedScreensCode("Colors")
    data object  ImageImports: SealedScreensCode("ImageImports")
}

