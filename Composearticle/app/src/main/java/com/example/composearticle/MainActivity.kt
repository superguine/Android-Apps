package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(
                        //name = "Android",
                        //modifier = Modifier.padding(innerPadding)
                        heading = stringResource(R.string.heading),
                        first = stringResource(R.string.first_text),
                        second = stringResource(R.string.second_text),
                    )

                }
            }
        }
    }
}

@Composable
fun Greeting( modifier: Modifier = Modifier,first: String,second: String, heading: String) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column {
        Image(
            painter = image,
            contentDescription = null,
        )
        Text(
            text =  heading,
            fontSize = 28.sp,
            lineHeight = 55.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .padding(16.dp, bottom = 0.dp)
        )

        Text(
            text = first,
            fontSize = 18.sp,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding( start = 16.dp, end = 15.dp)

        )
        Text(
            text = second, //stringResource(R.string.second_text),
            fontSize = 18.sp,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        Greeting(
            heading = stringResource(R.string.heading),
            first = stringResource(R.string.first_text),
            second = stringResource(R.string.second_text),
            )
    }
}