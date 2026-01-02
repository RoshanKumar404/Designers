package com.example.thedesigners.Deciders

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.thedesigners.BottomSheetContent
import com.example.thedesigners.Bottombar
import com.example.thedesigners.Drawer
import com.example.thedesigners.Screens.BottomScreens.Notification
import com.example.thedesigners.Screens.BottomScreens.Profile
import com.example.thedesigners.Screens.BottomScreens.Search
import com.example.thedesigners.Screens.DrwawerScreens.AiEditor
import com.example.thedesigners.Screens.DrwawerScreens.Colors
import com.example.thedesigners.Screens.DrwawerScreens.Feedback
import com.example.thedesigners.Screens.DrwawerScreens.ImageImports
import com.example.thedesigners.Screens.MainScreen
import com.example.thedesigners.Screens.Post
import com.example.thedesigners.SealedScreens
import com.example.thedesigners.Topbar
import com.example.thedesigners.ui.theme.Green
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavGraph() {

    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    // now i am trying to do dynamic route hanling
    // trying to obeserve  the current route
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute= navBackStackEntry?.destination?.route

    //this is for the bottomsheet
    val sheetState= rememberModalBottomSheetState()
    var showBottomsheet by remember {
        mutableStateOf(false)
    }

    if (showBottomsheet){
        ModalBottomSheet(
            onDismissRequest = {showBottomsheet=false},
            sheetState=sheetState,
            containerColor = Color.White
        ) {
            BottomSheetContent(onClose={showBottomsheet=false},navController)
        }
    }

    //defining which screens should show the bars ->>
    // obviously the mainscreen
    // here im dividing the both the screen types
    val bottomBarScreens=listOf(
        SealedScreens.Main.Screens,
        SealedScreens.Search.Screens,
        SealedScreens.Notification.Screens,
        SealedScreens.Profile.Screens
    )
    //do we have to show bars?
    val showbars=currentRoute in bottomBarScreens

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled =showbars,
        drawerContent = {
            ModalDrawerSheet {
                Box(
                    modifier = Modifier
                        .background(Green)
                        .fillMaxWidth()
                        .height(65.dp)
                )

                Drawer(
                    onItemClick = { screen ->
                        scope.launch {
                            drawerState.close()
                            navController.navigate(screen)
//                                popUpTo(SealedScreens.Main.Screens)
//                                launchSingleTop = true
//                            }
                        }
                    }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                if(showbars){
                    Topbar(
                        onMenuClick = {
                            scope.launch { drawerState.open() }
                        }
                    )
                }

            },
            bottomBar = {
                if (showbars){
                    Bottombar(navController = navController, onFabClick = {showBottomsheet=true })
                }

            }
        ) { innerPadding ->
            // The NavHost now switches ONLY the middle content
            NavHost(
                navController = navController,
                startDestination = SealedScreens.Main.Screens,
                modifier = Modifier.padding(if (showbars)innerPadding else PaddingValues(0.dp))
            ) {
                composable(SealedScreens.Main.Screens) {
                    MainScreen()
                }
                composable(SealedScreens.Colors.Screens) { Colors() }
                composable(SealedScreens.AiEditor.Screens) { AiEditor() }
                composable(SealedScreens.ImageImports.Screens) { ImageImports() }
                composable(SealedScreens.Feedback.Screens) { Feedback() }
                composable(SealedScreens.Notification.Screens) { Notification() }
                composable(SealedScreens.Search.Screens) { Search() }
                composable(SealedScreens.Profile.Screens) { Profile() }
                composable ( SealedScreens.Post.Screens ){ Post() }
            }

        }


    }
}