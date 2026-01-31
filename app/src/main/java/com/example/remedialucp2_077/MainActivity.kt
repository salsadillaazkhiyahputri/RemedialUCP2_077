package com.example.remedialucp2_077

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.remedialucp2_077.ui.theme.RemedialUCP2_077Theme
import com.example.remedialucp2_077.view.uicontroller.LibraryApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RemedialUCP2_077Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LibraryApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

