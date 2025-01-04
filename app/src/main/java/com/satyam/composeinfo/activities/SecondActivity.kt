package com.satyam.composeinfo.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satyam.composeinfo.activities.ui.theme.GreenLight
import com.satyam.composeinfo.activities.ui.theme.PurpleGrey40

class SecondActivity : ComponentActivity() {
    var mobileNo = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mobileNo = intent.getStringExtra("mobile").toString()

        setContent {
            GreetingApp1(mobileNo)
        }
    }
}

@Composable
fun GreetingApp1(mobileNo: String) {
    var greeting = remember { mutableStateOf("Welcome To second Activity") }
    greeting.value=mobileNo
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
                modifier = Modifier.padding(bottom = 16.dp)
            )



        }
    }

}

@Preview
@Composable
fun GreetingAppPreview2() {
    GreetingApp1("8989898989")
}

