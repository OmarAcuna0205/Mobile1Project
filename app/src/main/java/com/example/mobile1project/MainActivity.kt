package com.example.mobile1project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.mobile1project.ids.itit.views.ItitListScreen
import com.example.mobile1project.ids.location.views.LocationListScreen
import com.example.mobile1project.ids.students.views.StudentListScreen
import com.example.mobile1project.navigation.TabBarNavigationView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = androidx.compose.ui.Modifier.fillMaxSize()) {
                    TabBarNavigationView()
                }
            }
        }
    }
}
