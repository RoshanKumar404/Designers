package com.example.thedesigners

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Drawer(onItemClick: () -> Unit) {

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Text("Settings", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(12.dp))

        NavigationDrawerItem(
            label = { Text("Colors") },
            selected = false,
            onClick = onItemClick
        )

        NavigationDrawerItem(
            label = { Text("Images") },
            selected = false,
            onClick = onItemClick
        )

        HorizontalDivider(Modifier.padding(vertical = 8.dp))

        Text("Premium", style = MaterialTheme.typography.titleMedium)

        NavigationDrawerItem(
            label = { Text("AI Editor") },
            selected = false,
            icon = {
                Icon(Icons.Outlined.Face, contentDescription = null)
            },
            onClick = onItemClick
        )
    }
}

//@Preview
//@Composable
//fun prev(){
//    Drawer{}
//}
