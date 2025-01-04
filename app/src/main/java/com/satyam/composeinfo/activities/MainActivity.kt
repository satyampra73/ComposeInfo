package com.satyam.composeinfo.activities

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    var greeting = remember { mutableStateOf("Welcome To Compose Info") }
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
                modifier = Modifier.padding(bottom = 20.dp),
                style = TextStyle(
                    fontWeight = FontWeight.Bold
                )
            )

            var mobileNo = remember { mutableStateOf("") }
            var password = remember { mutableStateOf("") }

            TextField(
                value = mobileNo.value,
                onValueChange = {
                        mobileNo.value = it
                },
                modifier = Modifier.padding(bottom = 15.dp).fillMaxWidth()
                    .padding(horizontal = 20.dp),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Phone
                ),
                placeholder = { Text("Enter Mobile Number") }
            )


            TextField(
                value = password.value,
                onValueChange = {
                    password.value = it
                },
                modifier = Modifier.padding(bottom = 15.dp).fillMaxWidth()
                    .padding(horizontal = 20.dp),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password
                ),
                placeholder = { Text("Enter Password") },
                visualTransformation = PasswordVisualTransformation()
            )


            Button(onClick = {
//                greeting.value = "Logging In"
                val intent = Intent(context, SecondActivity::class.java)
                intent.putExtra("mobileNo", mobileNo.value)
                context.startActivity(intent)
            },
modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
                ) {
                Text("LOG IN")
            }


        }
    }

}


@Preview
@Composable
fun GreetingAppPreview() {
    GreetingApp()
}




