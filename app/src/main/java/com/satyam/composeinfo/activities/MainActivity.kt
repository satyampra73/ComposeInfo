package com.satyam.composeinfo.activities

import android.R.attr.label
import android.R.attr.onClick
import android.R.attr.text
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.satyam.composeinfo.activities.ui.theme.GreenLight
import com.satyam.composeinfo.activities.ui.theme.PurpleGrey40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingApp()
        }
    }
}

@Composable
fun GreetingApp() {
    val context = LocalContext.current
    var greeting = remember { mutableStateOf("Log In") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PurpleGrey40)

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .background(GreenLight),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = greeting.value,
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 20.dp)
            )



            Button(onClick = { greeting.value = "Logging In"
                val intent = Intent(context, SecondActivity::class.java)
                context.startActivity(intent)
            }) {
                Text("Change Greeting")
            }


        }
    }

}

@Preview
@Composable
fun GreetingAppPreview() {
    GreetingApp()
}




