package com.example.mobile1project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.mobile1project.imc.views.IMCScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // 🔥 Se agregó el parámetro `savedInstanceState`
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) { // 🔥 Se limpió la importación del `Modifier`
                    IMCScreen()
                }
            }
        }
    }
}

