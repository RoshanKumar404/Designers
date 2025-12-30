package com.example.thedesigners

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun Drawer( onItemClick: (String) -> Unit) {
//    val navControler= rememberNavController()
//    val  coroutineScope=rememberCoroutineScope()
//    val drawerState = rememberDrawerState(DrawerValue.Closed)

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(12.dp))
        Text("Designers", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.titleLarge)
        HorizontalDivider()

//        Text("Settings", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(12.dp))

        NavigationDrawerItem(
            label = { Text("Colors",color = Color.Green) },
            selected = false,
            icon = {Icon(Icons.Outlined.Edit, contentDescription = "fsas", tint = Color.Green)},
            onClick = {

                    onItemClick(SealedScreens.Colors.Screens)

            }
        )

        NavigationDrawerItem(
            label = { Text("Image Imports", color = Color.Green) },
            selected = false,
            icon = {Icon(Icons.Outlined.AddCircle, contentDescription = "fsas", tint = Color.Green)},
            onClick = {
                onItemClick(SealedScreens.ImageImports.Screens)
            }
        )

        HorizontalDivider(Modifier.padding(vertical = 8.dp))

        Text("Premium",Modifier.padding(16.dp), style = MaterialTheme.typography.titleLarge)

        NavigationDrawerItem(
            label = { Text("AI Editor",color = Color.Green) },
            selected = false,
            icon = {
                Icon(Icons.Outlined.Face, contentDescription = null, tint = Color.Green)
            },
            onClick = { onItemClick(SealedScreens.AiEditor.Screens) }
        )
        NavigationDrawerItem(
            label = { Text("Help and feedback",color = Color.Green) },
            selected = false,
            icon = { Icon(Icons.Outlined.Home, contentDescription = null, tint = Color.Green) },
            onClick = { onItemClick(SealedScreens.Feedback.Screens) },
        )
        Spacer(Modifier.height(12.dp))
    }
}


