package com.example.jetpackcomposetasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.jetpackcomposetasks.task1_lazy.MyScreen
import com.example.jetpackcomposetasks.task1_lazy.itemList
import com.example.jetpackcomposetasks.ui.theme.JetpackComposeTasksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyScreen(items = itemList())
        }
    }
}
