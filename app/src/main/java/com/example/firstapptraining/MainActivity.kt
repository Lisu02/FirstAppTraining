package com.example.firstapptraining

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firstapptraining.ui.screens.FunFactsNavigationGraph
import com.example.firstapptraining.ui.screens.Routes
import com.example.firstapptraining.ui.screens.UserInputScreen
import com.example.firstapptraining.ui.screens.WelcomeScreen
import com.example.firstapptraining.ui.theme.FirstAppTrainingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAppTrainingTheme {
                FunFactsApp()
            }
        }
    }

    @Composable
    fun FunFactsApp(){
        FunFactsNavigationGraph()
    }
}

