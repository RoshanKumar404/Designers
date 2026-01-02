package com.example.thedesigners.Screens.Authentication

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalGraphicsContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thedesigners.ui.theme.Green
import com.example.thedesigners.ui.theme.TheDesignersTheme
import java.nio.file.WatchEvent

@Composable
fun Login(onLoginSuccess:()->Unit){
var username by remember { mutableStateOf("") }
    var userpassword by remember { mutableStateOf("") }
    val  context= LocalContext.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 25.dp, vertical = 100.dp)
        , verticalArrangement = Arrangement.Bottom
        , horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(value=username, onValueChange = {username=it},
            label = {"Username"},
            shape = RoundedCornerShape(22.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Green,
                unfocusedBorderColor = Green,
                focusedLabelColor = Green,
                cursorColor = Green,
                focusedLeadingIconColor = Green

            ),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person,contentDescription = null,)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        )
        OutlinedTextField(value=userpassword, onValueChange = {userpassword=it},
            label = {"Password"},
            shape = RoundedCornerShape(22.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Green,
                unfocusedBorderColor = Green,
                focusedLabelColor = Green,
                cursorColor = Green,
                focusedLeadingIconColor = Green

            ),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock,contentDescription = null,)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            visualTransformation = PasswordVisualTransformation()
        )

        Button(onClick = {
            if (authentication(username, userpassword)){
                onLoginSuccess()
                Toast.makeText(context,
                    "Logged in Broo",
                    Toast.LENGTH_SHORT)
                    .show()
            }else{
                Toast.makeText(context,
                    "Invalid Credentials Broo",
                    Toast.LENGTH_SHORT)
                    .show()
            }

        },
            colors = ButtonDefaults.buttonColors(Green),
            contentPadding = PaddingValues(start = 60.dp, end = 60.dp, top = 8.dp, bottom = 10.dp),
            modifier = Modifier.padding(top = 19.dp)
        ) {
            Text("Login", fontSize = 25.sp)
        }

    }

}

private  fun authentication(username: String, pasword:String): Boolean{
    val validUsernam ="Roshan"
    val validUserPassword="Roshan!@#"
    return username==validUsernam && pasword==validUserPassword
}
@Preview
@Composable
fun Prev(){
    TheDesignersTheme {
        Login(onLoginSuccess = {})
    }
}