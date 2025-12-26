package com.example.thedesigners

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeGestures
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.thedesigners.ui.theme.Green
import com.example.thedesigners.ui.theme.TheDesignersTheme
import kotlinx.coroutines.launch
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                lightScrim = Color.Red.toArgb(),
                darkScrim = Color.Green.toArgb()
            )
        )
        setContent {
            TheDesignersTheme {
               Scaffold(
                   topBar = {
                       Topbar()
                   },
                   contentWindowInsets = WindowInsets.safeGestures
               ) {padding->
                   Column(
                       modifier = Modifier
                           .padding(padding)
                           .fillMaxSize()
                   ) {  }

                    Box(
                      modifier = Modifier
                          .background(Color.Cyan)
                          .padding(padding),
                        contentAlignment = Alignment.Center
                    )

                    {Column {
                        ImageAndBudtton()
                        Box(
                            modifier = Modifier
                                .height(280.dp)
                                .width(200.dp)
                                .background(Color.Cyan)
                        ) {
                            Text(
                                text = "this is the box content",
                                modifier = Modifier.align(Alignment.Center),
                                Color.Yellow
                            )
                        }
                        Row {
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
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(
            text = "jai sri ram", color = Color.Red,
            modifier = Modifier
                .border(width = 4.dp, shape = RectangleShape, color = Color.Red)
                .padding(20.dp)
        )
        Text(text = "jai roshan")

        Text(
            text = "You are the roshan", color = Color.Red,
            modifier = Modifier
                .border(
                    width = 10.dp,
                    shape = RoundedCornerShape(10.dp),
                    color = Color.Gray
                )
                .background(Color.Gray)
                .padding(20.dp),
            fontSize = 32.sp,
            fontStyle = FontStyle.Italic
        )
    }
}
@Composable
fun ImageAndBudtton(){
    var counter= remember{ mutableIntStateOf(0) }
//val context= LocalContext.current.applicationContext
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { counter.value+=1},
            shape = RoundedCornerShape(size = 19.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red))
        {
            Text(
                text = "Press plz"
            )
        }
        Text(text = counter.value.toString(), fontSize = 30.sp)
        Image(
            painter = painterResource(id = R.drawable.screenshot_2025_03_19_111225)
            , contentDescription = null,
            modifier = Modifier
                .height(300.dp)
                .width(300.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Topbar(){
    val context=LocalContext.current
    TopAppBar(title = {Text(text="The Designers")},
        navigationIcon = {
            IconButton(onClick =  { }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "IDK")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Green,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White
        ),
        actions = {
            IconButton(onClick = { Toast.makeText(context,"Contact", Toast.LENGTH_SHORT).show()}) {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "Contacts",tint=Color.White,)
            }
            IconButton(onClick = { Toast.makeText(context,"Search things",Toast.LENGTH_SHORT).show()}) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "search", tint = Color.White)
            }
            IconButton(onClick = {Toast.makeText(context,"s", Toast.LENGTH_SHORT).show()}) {
//MoreVert
                Icon(imageVector = Icons.Filled.Phone, contentDescription = "Phone", tint = Color.White)
            }
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val drawerState = rememberDrawerState(DrawerValue.Closed)

    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(
                onItemClick = {
                    scope.launch { drawerState.close() }
                }
            )
        }
    ) {
        Scaffold(
            topBar = {
                Topbar(
                    onMenuClick = {
                        scope.launch { drawerState.open() }
                    }
                )
            }
        ) { padding ->
            MainContent(padding)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TheDesignersTheme {
//        Greeting("Android")
//        Texts()
//        ImageAndBudtton()
        Topbar()
    }
}