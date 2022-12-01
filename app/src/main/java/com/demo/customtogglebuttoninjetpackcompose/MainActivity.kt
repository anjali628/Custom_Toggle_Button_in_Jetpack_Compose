package com.demo.customtogglebuttoninjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.customtogglebuttoninjetpackcompose.ui.theme.CustomToggleButtonInJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomToggleButtonInJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                    CustomToggleButton()
                }
            }
        }
    }
}

@Composable
fun CustomToggleButton(){

    var isToggle by remember { mutableStateOf(false) }

    Box(contentAlignment = Center) {

        Card(
            shape = RoundedCornerShape(39.dp),
            elevation = 0.dp
        ) {
            Box(
                modifier = Modifier
                    .background(
                        if (isToggle) Color.Green else Color.Red
                    )
                    .clickable {
                        isToggle = !isToggle
                    },
                contentAlignment = Alignment.Center
            ) {
                if (isToggle) {
                    Row(modifier = Modifier.padding(5.dp)) {
                        Text(
                            text = "ON", style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.W400
                            ), color = Color.White, modifier = Modifier
                                .padding(start = 10.dp)
                                .align(CenterVertically)
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.on), contentDescription = "",
                            tint = Color.Unspecified,
                            modifier = Modifier.padding(start = 10.dp)
                        )

                    }
                } else {
                    Row(modifier = Modifier.padding(5.dp)) {
                        Icon(
                            painter = painterResource(id = R.drawable.off), contentDescription = "",
                            tint = Color.Unspecified
                        )
                        Text(
                            text = "OFF", style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.W400
                            ), color = Color.White, modifier = Modifier
                                .padding(start = 10.dp, end = 10.dp)
                                .align(CenterVertically)
                        )
                    }
                }
            }
        }

    }
}