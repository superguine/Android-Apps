package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                CalculatorApp()
            }
        }
    }
}

@Composable
fun CalculatorApp() {
    var displayValue by remember { mutableStateOf("0") }
    var firstNumber by remember { mutableStateOf<Double?>(null) }
    var secondNumber by remember { mutableStateOf<Double?>(null) }
    var operator by remember { mutableStateOf<String?>(null) }
    var isResultDisplayed by remember { mutableStateOf(false) }

    // Function to handle number button clicks
    fun onNumberClick(value: String) {
        if (isResultDisplayed) {
            displayValue = value
            isResultDisplayed = false
        } else {
            displayValue = if (displayValue == "0") value else displayValue + value
        }
    }

    // Function to handle operator button clicks
    fun onOperatorClick(op: String) {
        if (operator == null) {
            firstNumber = displayValue.toDoubleOrNull()
            operator = op
            displayValue = ""//firstNumber.toString() + op
            //firstNumber = displayValue.toDoubleOrNull()
        }
    }

    fun calculate(a: Double, b: Double, op: String): Double {
        return when (op) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            "/" -> if (b != 0.0) a / b else Double.NaN
            else -> a
        }
    }

    // Function to handle equals button
    fun onEqualsClick() {
        secondNumber = displayValue.toDoubleOrNull()
        if (firstNumber != null && secondNumber != null && operator != null) {
            val result = calculate (firstNumber!!, secondNumber!!, operator!!)
            displayValue = result.toString()
            firstNumber = result
            secondNumber = null
            operator = null
            isResultDisplayed = true
        }
    }

    // Function to calculate based on the operator
    /*
    fun calculate(a: Double, b: Double, op: String): Double {
        return when (op) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            "/" -> if (b != 0.0) a / b else Double.NaN
            else -> a
        }
    }*/

    // Function to handle clear
    fun onClear() {
        displayValue = "0"
        firstNumber = null
        secondNumber = null
        operator = null
    }

    // Layout of calculator
    Box(modifier = Modifier.fillMaxSize().background(Color(0xffFAEEFF))) {
        Column(modifier = Modifier
            .align(Alignment.Center)
            .padding(16.dp)
        ) {
            // Display section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(color = Color(0xffd8c3f7)),
                contentAlignment = Alignment.CenterEnd
            ) {
                Text(
                    text = displayValue,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 40.sp,
                    modifier = Modifier.padding(16.dp)
                )
            }
            Spacer(modifier = Modifier.height(100.dp))

            // Calculator buttons
            Column {
                // Row 1: 7, 8, 9, /
                Row {
                    CalculatorButton("7") { onNumberClick("7") }
                    Spacer(Modifier.width(14.dp))
                    CalculatorButton("8") { onNumberClick("8") }
                    Spacer(Modifier.width(14.dp))
                    CalculatorButton("9") { onNumberClick("9") }
                    Spacer(Modifier.width(14.dp))
                    CalculatorButton("/") { onOperatorClick("/") }
                }
                Spacer(modifier = Modifier.height(8.dp))

                // Row 2: 4, 5, 6, *
                Row {
                    CalculatorButton("4") { onNumberClick("4") }
                    Spacer(Modifier.width(14.dp))
                    CalculatorButton("5") { onNumberClick("5") }
                    Spacer(Modifier.width(14.dp))
                    CalculatorButton("6") { onNumberClick("6") }
                    Spacer(Modifier.width(14.dp))
                    CalculatorButton("*") { onOperatorClick("*") }
                }
                Spacer(modifier = Modifier.height(8.dp))

                // Row 3: 1, 2, 3, -
                Row {
                    CalculatorButton("1") { onNumberClick("1") }
                    Spacer(Modifier.width(14.dp))
                    CalculatorButton("2") { onNumberClick("2") }
                    Spacer(Modifier.width(14.dp))
                    CalculatorButton("3") { onNumberClick("3") }
                    Spacer(Modifier.width(14.dp))
                    CalculatorButton("-") { onOperatorClick("-") }
                }
                Spacer(modifier = Modifier.height(8.dp))

                // Row 4: 0, ., =, +
                Row {
                    CalculatorButton("0") { onNumberClick("0") }
                    Spacer(Modifier.width(14.dp))
                    CalculatorButton(".") { onNumberClick(".") }
                    Spacer(Modifier.width(14.dp))

                    CalculatorButton("+",Modifier.width(176.dp)) { onOperatorClick("+") }
                }
                Spacer(modifier = Modifier.height(8.dp))

                // Row 5: C (clear)
                Row {
                    CalculatorButton("C", Modifier.width(130.dp)) { onClear() }
                    Spacer(Modifier.width(14.dp))
                    CalculatorButton("=", Modifier.width(217.dp)) { onEqualsClick() }
                }
            }
        }
    }
}

@Composable
fun CalculatorButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(onClick = onClick, colors = ButtonDefaults.buttonColors(Color(0xff4A0088)), modifier = modifier.size(80.dp, 60.dp)) {
        Text(text = text,
            color = (Color(0xffFAEEFF)),
            fontSize = 20.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalculatorTheme {
        CalculatorApp()
    }
}
