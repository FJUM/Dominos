package com.example.dominospizza.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dominospizza.ui.theme.DominosPizzaTheme
import com.example.dominospizza.R
import com.example.dominospizza.resources.Boton

typealias OnCambiarPantalla_Postres= (Pantalla) -> Unit

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Postres(onCambiarPantalla: OnCambiarPantalla_Postres){
    Scaffold (
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                ),
                title = {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Postres",
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.background)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {onCambiarPantalla(Pantalla.MENU)}) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "ArrowBack",
                            tint = MaterialTheme.colorScheme.background,
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {onCambiarPantalla(Pantalla.PAGO)}) {
                        Box {
                            Icon(
                                imageVector = Icons.Filled.ShoppingCart,
                                contentDescription = "ShoppingCart",
                                tint = MaterialTheme.colorScheme.background,
                            )
                        }
                    }
                }
            )
        }
    ){
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier.fillMaxSize().padding(top = 100.dp)
        ) {
            BodyPostres(onCambiarPantalla)
        }
    }
}

@Composable
fun BodyPostres(onCambiarPantalla: OnCambiarPantalla_Entradas){
    Column {
        Row {
            Boton(onClick = {onCambiarPantalla(Pantalla.DETALLES)}, context = "BROWNIE COOKIE", dirimage = R.drawable.fondo)
            Spacer(Modifier.width(8.dp))
            Boton(onClick = {onCambiarPantalla(Pantalla.DETALLES)}, context = "VOLCAN", dirimage = R.drawable.fondo)
        }
        Spacer(Modifier.height(8.dp))
        Row {
            Boton(onClick = {onCambiarPantalla(Pantalla.DETALLES)}, context = "CANELA BAITZ", dirimage = R.drawable.fondo)
            Spacer(Modifier.width(8.dp))
            Boton(onClick = {onCambiarPantalla(Pantalla.DETALLES)}, context = "CAJETA BAITZ", dirimage = R.drawable.fondo)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewPostres() {
    DominosPizzaTheme {
        var pantallaActual by remember { mutableStateOf(Pantalla.POSTRES) }
        PantallaActual(pantallaActual) { nuevaPantalla ->
            pantallaActual = nuevaPantalla
        }
    }
}
/*
@Preview(showSystemUi = true)
@Composable
fun PreviewPostres(){
    DominosPizzaTheme {
        Postres (onCambiarPantalla = {})
    }
}
 */