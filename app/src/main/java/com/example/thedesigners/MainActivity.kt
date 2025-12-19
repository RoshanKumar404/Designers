package com.example.thedesigners

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.thedesigners.ui.theme.TheDesignersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheDesignersTheme {
               Scaffold {innerpadding->
                    Box(
                        modifier = Modifier.fillMaxSize()
                            .padding(innerpadding),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Greeting(
                            name = "Roshan ji",
                            // modifier = Modifier.padding(innerPadding)
                        )
                        Texts()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Composable
fun Texts(){
    Text(
        text = "You are the roshan", color = Color.Red,
        modifier = Modifier.border(width = 10.dp, shape = RoundedCornerShape(10.dp), color = Color.Black).background(Color.Gray).padding(20.dp),
        fontSize = 32.sp,
        fontStyle = FontStyle.Italic
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TheDesignersTheme {
//        Greeting("Android")
        Texts()
    }
}