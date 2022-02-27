package com.example.smarthome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.smarthome.ui.theme.SmartHomeTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import kotlin.math.max

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           LottieExample()
        }
    }
}


@Composable
fun LottieExample() {
    var isPlaying by remember {
        mutableStateOf(true)
    }
    var speed by remember {
        mutableStateOf(1f)
    }

    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.smarthome)
    )

    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever,
        isPlaying = isPlaying,
        speed = speed,
        restartOnPlay = false
    )

    Column(
        Modifier
            .background(Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Lottie",
            color = Color.Gray,
            fontSize = 70.sp,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(10.dp)
        )

        LottieAnimation(
            composition, progress,
            modifier = Modifier.size(400.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Button(
                    onClick = {
                        speed = max(speed - 0.25f, 0f)
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF0F9D58)
                    )
                ) {
                    Text(
                        text = "-",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }

                Text(
                    text = "Speed ( $speed )",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp, modifier = Modifier.padding(horizontal = 10.dp)
                )

                Button(
                    onClick = {
                        speed += 0.25f
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF0F9D58)
                    )
                ) {
                    Text(
                        text = "+",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )

                }

            }

        }

        Button(
            onClick = {
                isPlaying = !isPlaying
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF0F9D58)
            )
        ) {
            Text(
                text = if(isPlaying) "Pause" else "Play",
                color = Color.White
            )
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SmartHomeTheme {
        Greeting("Android")
    }
}