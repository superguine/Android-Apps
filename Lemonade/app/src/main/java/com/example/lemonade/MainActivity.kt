package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme
import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.contentColorFor
import androidx.compose.ui.platform.LocalContext


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

//@Preview
@Composable
fun LemonadeApp() {
    Images (modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

// Function to check if the device is in light mode
// Extension function for Context
fun Context.isDarkMode(): Boolean {
    val currentNightMode = this.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
    return currentNightMode == Configuration.UI_MODE_NIGHT_YES
}


@Composable
fun Images (modifier: Modifier = Modifier ) {
    var change by remember { mutableIntStateOf(1) }
    var squeezeCount by remember { mutableIntStateOf(0) }
    var requiredSqueezes by remember { mutableIntStateOf((2..4).random()) }
    val context = LocalContext.current

    // Call the isLightMode extension function
    val isDarkMode = context.isDarkMode()
    var bga = 0xfff7f724
    var tx = 0xff080800
    var bgb = 0xffd5f7c4
    if (isDarkMode) {
        bga = 0xff52520d
        tx = 0xfff7f724
        bgb = 0xff5e7156
    }
    val imagesource  = when(change){
        1 ->  R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val textsource = when (change){
        1 -> R.string.Tap_the_lemon_tre_to_select_a_lemon
        2 -> R.string.Slowly_keep_tapping_the_lemon_to_squeeze_it
        3 -> R.string.Glass_of_lemonade_tap_to_drink_it
        else -> R.string.Tap_the_empty_glass_to_start_again
    }
    val description = when(change){
        1 -> stringResource(R.string.lemon_tree_content_Description)
        2 -> stringResource(R.string.lemon_content_Description)
        3 -> stringResource(R.string.glass_of_lemonade_content_Description)
        else -> stringResource(R.string.empty_glass_content_Description)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(bgb))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(width = 100.dp,height = 100.dp)
                .background(Color(bga))
                .align(Alignment.TopCenter)
                .alpha(5f)
        ){
            Text(
                text = "Lemonade",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = Color(tx),
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 10.dp)
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = {
                    if (change == 2) {
                        squeezeCount++
                        if (squeezeCount >= requiredSqueezes) {
                            change++
                            squeezeCount = 0
                            requiredSqueezes = (2..4).random()
                        }
                    } else {
                        change = if (change == 1 || change == 3) change + 1 else 1
                    }
                },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(bgb))
            ) {
                Image(
                    painter = painterResource(imagesource),
                    contentDescription = description,
                    modifier = Modifier
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = stringResource(textsource),
                fontFamily = FontFamily.Serif,
            )
        }
    }
}

@Preview(showBackground =true)
@Composable
fun Preview() {
    LemonadeTheme {
       LemonadeApp()
    }
}