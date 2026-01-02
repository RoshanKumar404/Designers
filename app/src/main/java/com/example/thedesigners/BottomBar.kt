package com.example.thedesigners

import android.R
import android.hardware.camera2.CameraExtensionSession
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.thedesigners.ui.theme.Green
import com.example.thedesigners.ui.theme.TheDesignersTheme
import com.google.android.material.bottomappbar.BottomAppBar
import java.nio.file.WatchEvent

//private val Icons.Filled.Videocam: ImageVector
//private val Icons.Filled.CameraAlt: ImageVector

@Composable
fun Bottombar(navController: NavController,
              onFabClick:()-> Unit)
{
    val context= LocalContext.current
    val currentRoute=navController.currentBackStackEntryAsState().value?.destination?.route
    BottomAppBar(containerColor = Green, ){
        IconButton(onClick = {
            navController.navigate(SealedScreens.Main.Screens){
                popUpTo(SealedScreens.Main.Screens){
                    inclusive=false
                }
            }
         },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Home",
                modifier = Modifier.size(30.dp),
                tint = if (currentRoute== SealedScreens.Main.Screens) Color.White else Color.Black
            )
        }
        IconButton(onClick = {
            navController.navigate(SealedScreens.Profile.Screens){
                popUpTo(SealedScreens.Profile.Screens){
                    inclusive=false
                }
            }
        },
            modifier = Modifier.weight(1f)) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profile",
                modifier = Modifier.size(30.dp),
                tint = if (currentRoute== SealedScreens.Profile.Screens) Color.White else Color.Black
            )
        }
        Box(Modifier
            .weight(1f)
            .padding(15.dp)
            , contentAlignment = Alignment.Center

        ){
            FloatingActionButton(onClick =
                {
                    onFabClick()
                } ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add", modifier = Modifier.size(30.dp), tint = Color.Black)

            }

        }
        IconButton(onClick = {
            navController.navigate(SealedScreens.Search.Screens){
                popUpTo(SealedScreens.Profile.Screens){
                    inclusive=false
                }
            }
         },
            modifier = Modifier.weight(1f)
         ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",

                tint = if (currentRoute== SealedScreens.Search.Screens) Color.White else Color.Black
            )
        }
        // this screen is not created its just dummy
        IconButton(onClick = {
            navController.navigate(SealedScreens.Search.Screens){
                popUpTo(SealedScreens.Profile.Screens){
                    inclusive=false
                }
            }
        },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Liked",

                tint = if (currentRoute== SealedScreens.Search.Screens) Color.White else Color.Black
            )
        }
    }

}
@Composable
fun BottomSheetItem(Icon: ImageVector,title: String,onClick:()->Unit){
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .clickable{onClick()}) {
        Icon(Icon, contentDescription = "jain", tint = Color.Black,)
        Spacer(Modifier.height(10.dp))
        Text(
            title, color = Green, fontSize = 32.sp, fontWeight = FontWeight.Medium
        )
    }
}
@Composable
fun BottomSheetContent(onClose:()-> Unit,
                       navController: NavController){
    Column(
        Modifier.fillMaxWidth()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        BottomSheetItem(Icon = Icons.Default.Create, title = "Create A Post" ){

              navController.navigate(SealedScreens.Post.Screens){
                  popUpTo(SealedScreens.Main.Screens){
                      inclusive=false
                  }
              }
            onClose()

        }
        BottomSheetItem(Icon = Icons.Default.Favorite, title = "Add a Story") {
            /* Handle Click */
        }
        BottomSheetItem(Icon = Icons.Default.Star, title = "Create a Reel") {
            /* Handle Click */
        }
        BottomSheetItem(Icon = Icons.Filled.PlayArrow, title = "Go Live") {
            /* Handle Click */
        }
    }
}
//@Preview
//@Composable
//fun Pre(){
//    val navController=rememberNavController()
//    TheDesignersTheme {
////        Bottombar(navController, onFabClick={})
//        BottomSheetContent {  }
//    }
//}