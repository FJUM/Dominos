package com.example.dominospizza.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dominospizza.ui.theme.DominosPizzaTheme
import com.example.dominospizza.R

typealias OnCambiarPantalla_Masas = (Pantalla) -> Unit

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Masas(onCambiarPantalla: OnCambiarPantalla_Masas){
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
                        Text("Masas",
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
        Column {
            Image(
                painter = painterResource(id = R.drawable.fondo),
                contentDescription = "Fondo",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .padding(top = 64.dp)
                    .height(120.dp)
            )
            BodyMasas(onCambiarPantalla)
        }
    }
}

@Composable
fun BodyMasas(onCambiarPantalla: OnCambiarPantalla_Masas){Column {
    Masa(
        masa = "ORIGNAL",
        descipcion = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc vitae nisl pulvinar dui aliquet auctor.",
        onClick = {onCambiarPantalla(Pantalla.TAMANOS)}
    )
    Masa(
        masa = "ORILLA RELLENA DE QUESO",
        descipcion = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc vitae nisl pulvinar dui aliquet auctor.",
        onClick = {onCambiarPantalla(Pantalla.TAMANOS)}
    )
    Masa(
        masa = "SARTÉN",
        descipcion = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc vitae nisl pulvinar dui aliquet auctor.",
        onClick = {onCambiarPantalla(Pantalla.TAMANOS)}
    )
    Masa(
        masa = "ITALIANA",
        descipcion = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc vitae nisl pulvinar dui aliquet auctor.",
        onClick = {onCambiarPantalla(Pantalla.TAMANOS)}
    )
    Masa(
        masa = "CRUNCHY",
        descipcion = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc vitae nisl pulvinar dui aliquet auctor.",
        onClick = {onCambiarPantalla(Pantalla.TAMANOS)}
    )
}

}

@Composable
fun Masa(masa:String,descipcion:String,onClick: () -> Unit){
    var white = MaterialTheme.colorScheme.background
    var black = MaterialTheme.colorScheme.onBackground
    var primary = MaterialTheme.colorScheme.primary
    var secundary = MaterialTheme.colorScheme.secondary
    var tertiary = MaterialTheme.colorScheme.tertiary

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable (onClick = onClick)
            .drawBehind {
                val strokeWidth = 0.5.dp.toPx()
                val y = size.height - strokeWidth
                drawLine(
                    color = black.copy(0.4f),
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = strokeWidth
                )
            }
    ){
        Text(masa, color = secundary, fontWeight = FontWeight.Bold)
        Text(descipcion, color = black.copy(0.4f), modifier = Modifier.padding(bottom = 10.dp))
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewMasas() {
    DominosPizzaTheme {
        var pantallaActual by remember { mutableStateOf(Pantalla.MASAS) }
        PantallaActual(pantallaActual) { nuevaPantalla ->
            pantallaActual = nuevaPantalla
        }
    }
}