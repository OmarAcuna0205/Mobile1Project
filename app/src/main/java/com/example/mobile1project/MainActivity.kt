package com.example.mobile1project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.mobile1project.navigation.TabBarNavigationView
import com.example.mobile1project.ui.theme.Mobile1ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mobile1ProjectTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    TabBarNavigationView()
                }
            }
        }
    }
}

