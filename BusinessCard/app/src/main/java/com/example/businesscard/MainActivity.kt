package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(
                        name  = stringResource(R.string.name),
                    )
                }
            }
        }
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffc2dfc3))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 225.dp)
        ) {
            Image(
                painter =  painterResource(R.drawable.android_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .background(color = Color(0xff082f4d))
            )
            Text(
                text = name,
                fontSize = 50.sp,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = modifier
                    .padding(top = 1.dp)
            )
            Text(
                text = "Android Developer",
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace,
                color = Color(0xff3e8741), //3e8741
                fontWeight = FontWeight.Bold,
                modifier = modifier
                    .padding(top = 1.dp)
            )
        }
        //###############  Bottom part \/
        Column(
            modifier = Modifier
                .padding(top = 700.dp)
        ) {
            Row{
                Image(
                    painter = painterResource(R.drawable.baseline_call_24) ,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 100.dp )
                        .size(19.dp)
                )
                Text (
                    text = "(+91)8388907270",
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 13.sp,
                    color = Color(0xff3e8741),
                    modifier = Modifier
                        .padding(start = 20.dp)
                )

            }
            Row{
                Image(
                    painter = painterResource(R.drawable.baseline_mail_outline_24) ,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 5.dp,start = 100.dp )
                        .size(22.dp)
                )
                Text (
                    text = "shawonroyetc39@gmail.com",
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    color = Color(0xff3e8741),
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(top = 5.dp,start = 20.dp)
                )
            }
            Row{
                Image(
                    painter = painterResource(R.drawable.mdi__linkedin) ,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 5.dp,start = 100.dp )
                        .size(19.dp)
                )
                Text (
                    text = "Shawon Roy",
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    color = Color(0xff3e8741),
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(top = 5.dp,start = 20.dp)
                )
            }

            Row{
                Image(
                    painter = painterResource(R.drawable.mdi__github) ,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 5.dp,start = 100.dp )
                        .size(19.dp)
                )
                Text (
                    text = "superguine",
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    color = Color(0xff3e8741),
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(top = 5.dp,start = 20.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Greeting(stringResource(R.string.name))
    }
}