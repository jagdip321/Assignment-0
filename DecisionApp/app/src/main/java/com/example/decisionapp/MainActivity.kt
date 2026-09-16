package com.example.decisionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.decisionapp.ui.theme.DecisionAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DecisionAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DecisionScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun DecisionScreen(modifier: Modifier = Modifier){
    var decisionResult by remember { mutableStateOf("") }
    var clickCount by remember { mutableIntStateOf(0) }
    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text= "Name: Jagdip Singh Brar  CCID: jagdipsi", fontSize = 20.sp)
        Spacer(modifier = Modifier.size(16.dp))
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            // 10% Button
            Button(
                onClick = { decisionResult = randomDecision(10); clickCount++ }
            ) {
                Text(text = "10%")
            }
            Spacer(modifier = Modifier.size(16.dp))
            // 25% Button
            Button(
                onClick = { decisionResult = randomDecision(25); clickCount++ }
            ) {
                Text(text = "25%")
            }
            Spacer(modifier = Modifier.size(16.dp))
            // 50% Button
            Button(
                onClick = { decisionResult = randomDecision(50); clickCount++ }
            ) {
                Text(text = "50%")
            }
        }
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = "Decision Result: $decisionResult", fontSize = 16.sp)
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = "Click Count: $clickCount", fontSize = 16.sp)
        }
}

fun randomDecision(odds: Int): String {
    val random = (1..100).random()
    if (random <= odds) {return "Yes"}
    return "No"
}