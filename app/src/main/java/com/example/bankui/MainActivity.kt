package com.example.bankui

import android.graphics.Color
import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowInsetsControllerCompat
import com.example.bankui.ui.theme.BankUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SetBarColor(isLightTheme = !isSystemInDarkTheme())
            BankUITheme {
               Surface(
                   modifier = Modifier.fillMaxSize(),
                   color = MaterialTheme.colorScheme.background
               ) {
                   HomeScreen()
               }
            }
        }
    }

    @Composable
    private fun SetBarColor(isLightTheme: Boolean){
        LaunchedEffect(isLightTheme) {
            window?.apply {
                statusBarColor = Color.TRANSPARENT
                navigationBarColor = Color.TRANSPARENT

                WindowInsetsControllerCompat(this, decorView).apply {
                    isAppearanceLightStatusBars = isLightTheme
                    isAppearanceLightNavigationBars = isLightTheme
                }
            }
        }
    }

    @Preview
    @Composable
    fun HomeScreen(){
        Scaffold (
            bottomBar = {
                BottomNavigationBar()
            }
        ){ padding ->
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ){
                WalletSection()
                CardSection()
                FinanceSection()
                Spacer(modifier = Modifier.height(16.dp))
                CurrencySection()
            }
        }
    }
}


