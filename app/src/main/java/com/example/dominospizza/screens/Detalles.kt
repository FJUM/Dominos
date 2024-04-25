package com.example.dominospizza.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
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
import androidx.compose.ui.unit.sp
import com.example.dominospizza.ui.theme.DominosPizzaTheme
import com.example.dominospizza.resources.botonnum

typealias OnCambiarPantalla_Detalles= (Pantalla) -> Unit

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Detalles(onCambiarPantalla: OnCambiarPantalla_Detalles){
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
                        Text("Detalles",
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
                    IconButton(onClick = {  }) {
                        Box {
                        }
                    }
                }
            )
        }
    ){
        Column (modifier = Modifier.padding(top = 70.dp)) {
            BodyDetalles(onCambiarPantalla)
        }
    }
}

@Composable
fun BodyDetalles(onCambiarPantalla: OnCambiarPantalla_Detalles) {
    var white = MaterialTheme.colorScheme.background
    var black = MaterialTheme.colorScheme.onBackground
    var primary = MaterialTheme.colorScheme.primary
    var secundary = MaterialTheme.colorScheme.secondary
    var tertiary = MaterialTheme.colorScheme.tertiary
    Box(modifier = Modifier.padding(start = 8.dp, top = 8.dp, bottom = 25.dp)) {
        Text("Lorem ipsum dolor", fontWeight = FontWeight.Bold)
    }
    Column (modifier = Modifier
        .background(secundary)
        .fillMaxWidth()) {
        Text("Lorem ipsum dolor",
            fontWeight = FontWeight.Bold,
            color = white,
            modifier = Modifier.padding(8.dp)
        )
    }
    Column (modifier = Modifier.fillMaxWidth()) {
        Row (verticalAlignment = Alignment.CenterVertically,modifier = Modifier.padding(8.dp)) {
            Text("Seleccionar cantidad:"
            )
            Spacer(modifier = Modifier.weight(1f))
            botonnum()
        }
    }
    Column (modifier = Modifier.padding(10.dp)){
        Button(
            onClick = { onCambiarPantalla(Pantalla.DOMINO) },
            shape = RoundedCornerShape(3.dp),
            modifier = Modifier.fillMaxWidth()
        )
        {
            Text("AGREGAR ORDEN",fontWeight = FontWeight.Bold,)
        }
    }
    Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer pulvinar in ex ut lacinia. ",
        modifier = Modifier.padding(8.dp),
        fontSize = 13.sp,
        fontWeight = FontWeight.Bold,
        color = black.copy(alpha = 0.5f)
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewDetalles() {
    DominosPizzaTheme {
        var pantallaActual by remember { mutableStateOf(Pantalla.DETALLES) }
        PantallaActual(pantallaActual) { nuevaPantalla ->
            pantallaActual = nuevaPantalla
        }
    }
}