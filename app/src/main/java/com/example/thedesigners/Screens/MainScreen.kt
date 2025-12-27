package com.example.thedesigners.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.thedesigners.Drawer
import com.example.thedesigners.Greeting
import com.example.thedesigners.ImageAndBudtton
import com.example.thedesigners.SealedScreensCode
import com.example.thedesigners.Texts
import com.example.thedesigners.Topbar
import com.example.thedesigners.ui.theme.Green
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {


    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
//    val navController = rememberNavController()

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet (drawerContainerColor = Color.White){
                Box(modifier = Modifier
                    .background(Green)
                    .fillMaxWidth()
                    .height(60.dp)
                )

                Drawer(
                    onItemClick = { Screens->
                        scope.launch()
                        { drawerState.close()
                            navController.navigate(Screens){
                                popUpTo(SealedScreensCode.Main.Screens)
                                launchSingleTop=true
                            }}
                    },
//                navController = navController
                )

            }
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
//




//            ***********************************************
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

