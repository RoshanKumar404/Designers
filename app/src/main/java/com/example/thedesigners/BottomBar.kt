package com.example.thedesigners

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.thedesigners.ui.theme.Green
import com.google.android.material.bottomappbar.BottomAppBar

@Composable
fun Bottombar(navController: NavController)
{
    val currentRoute=navController.currentBackStackEntryAsState().value?.destination?.route
    BottomAppBar(containerColor = Green){
        IconButton(onClick = {
            navController.navigate(SealedScreens.Main.Screens){
                popUpTo(SealedScreens.Main.Screens){
                    inclusive=false
                }
            }
        }) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Home",
                tint = if (currentRoute== SealedScreens.Main.Screens) Color.White else Color.Green
            )
        }
        IconButton(onClick = {
            navController.navigate(SealedScreens.Profile.Screens){
                popUpTo(SealedScreens.Profile.Screens){
                    inclusive=false
                }
            }
        }) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profile",
                tint = if (currentRoute== SealedScreens.Profile.Screens) Color.White else Color.Green
            )
        }
        IconButton(onClick = {
            navController.navigate(SealedScreens.Search.Screens){
                popUpTo(SealedScreens.Profile.Screens){
                    inclusive=false
                }
            }
        }) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = if (currentRoute== SealedScreens.Search.Screens) Color.White else Color.Green
            )
        }
    }
}