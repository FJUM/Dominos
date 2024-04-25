package com.example.dominospizza

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.dominospizza.screens.Pantalla
import com.example.dominospizza.screens.PantallaActual
import com.example.dominospizza.ui.theme.DominosPizzaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DominosPizzaTheme {
                var pantallaActual by remember { mutableStateOf(Pantalla.INICIO) }
                PantallaActual(pantallaActual) { nuevaPantalla ->
                    pantallaActual = nuevaPantalla
                }
            }
        }
    }
}

@Preview(showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun PreviewMainActivity() {
    DominosPizzaTheme {
        var pantallaActual by remember { mutableStateOf(Pantalla.INICIO) }
        PantallaActual(pantallaActual) { nuevaPantalla ->
            pantallaActual = nuevaPantalla
        }
    }
}

