package com.example.thedesigners.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.width

import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import com.example.thedesigners.Greeting
import com.example.thedesigners.ImageAndBudtton

import com.example.thedesigners.Texts


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

//val navController= rememberNavController()
//    val drawerState = rememberDrawerState(DrawerValue.Closed)
//    val scope = rememberCoroutineScope()
////    val navController = rememberNavController()


        Column(modifier = Modifier.fillMaxSize()) {

//                Topbar(
//                    onMenuClick = {
//                        scope.launch { drawerState.open() }
//                    }
//                )


//


//            ***********************************************
                Box(
                    modifier = Modifier
                        .background(Color.Cyan)
                        .weight(1f)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                )

                {
                    Column {
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



