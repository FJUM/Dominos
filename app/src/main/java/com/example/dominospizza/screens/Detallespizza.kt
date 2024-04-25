package com.example.dominospizza.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dominospizza.R
import com.example.dominospizza.resources.botonnum
import com.example.dominospizza.resources.ingredientes
import com.example.dominospizza.resources.ingredientespizza
import com.example.dominospizza.ui.theme.DominosPizzaTheme

typealias OnCambiarPantalla_Detallespizza = (Pantalla) -> Unit

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Detallespizza(onCambiarPantalla: OnCambiarPantalla_Detallespizza){
    Scaffold (
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                ),
                title = {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 56.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Detalles",
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.background)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { onCambiarPantalla(Pantalla.TAMANOS) }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "ArrowBack",
                            tint = MaterialTheme.colorScheme.background,
                        )
                    }
                }
            )
        }
    ){
        Column (modifier = Modifier.padding(top = 70.dp)) {
            BodyDetallespizza(onCambiarPantalla)
        }
    }
}

@Composable
fun BodyDetallespizza(onCambiarPantalla: OnCambiarPantalla_Detallespizza){
    Column(modifier = Modifier.padding(start = 8.dp, top = 8.dp, bottom = 25.dp)) {
        Text("Lorem ipsum dolor sit amet", fontWeight = FontWeight.Bold)
        Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", fontSize = 12.sp )
    }
    Column {
        Ingredientes(onCambiarPantalla)
    }

}

@Composable
fun Ingredientes(onCambiarPantalla: OnCambiarPantalla_Detallespizza){
    var white = MaterialTheme.colorScheme.background
    var black = MaterialTheme.colorScheme.onBackground
    var primary = MaterialTheme.colorScheme.primary
    var secundary = MaterialTheme.colorScheme.secondary
    var tertiary = MaterialTheme.colorScheme.tertiary

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        item(){
            Producto(onCambiarPantalla)
        }
        item(){
            Salsa()
        }
        item {
            Queso()
        }
        item {
            Ingredientes_Pizza()
        }
        item {
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
        }
        item {
            Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer pulvinar in ex ut lacinia. ",
                modifier = Modifier.padding(8.dp),
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = black.copy(alpha = 0.5f)
            )
        }
    }
}

@Composable
fun Producto(onCambiarPantalla: OnCambiarPantalla_Detallespizza){
    var white = MaterialTheme.colorScheme.background
    var black = MaterialTheme.colorScheme.onBackground
    var primary = MaterialTheme.colorScheme.primary
    var secundary = MaterialTheme.colorScheme.secondary
    var tertiary = MaterialTheme.colorScheme.tertiary
    Column(modifier = Modifier.padding(bottom = 8.dp)) {
        Column(
            modifier = Modifier
                .background(secundary)
                .fillMaxWidth()
        ) {
            Text(
                "1. PERSONALIZA TU PRODUCTO",
                fontWeight = FontWeight.Bold,
                color = white,
                modifier = Modifier.padding(8.dp)
            )
        }
        Column(modifier = Modifier
            .drawBehind {
                val strokeWidth = 0.5.dp.toPx()
                val y = size.height - strokeWidth
                drawLine(
                    color = black,
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = strokeWidth
                )
            }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .padding(8.dp)
            ) {
                Text("Seleccionar masa")
                Spacer(modifier = Modifier.weight(1f))
                Text("Lorem >", color = secundary, fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { onCambiarPantalla(Pantalla.MASAS) }
                )
            }
        }
        Column(modifier = Modifier
            .drawBehind {
                val strokeWidth = 0.5.dp.toPx()
                val y = size.height - strokeWidth
                drawLine(
                    color = black,
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = strokeWidth
                )
            }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .padding(8.dp)
            ) {
                Text("Seleccionar tamaño")
                Spacer(modifier = Modifier.weight(1f))
                Text("Lorem ipsum >", color = secundary, fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { onCambiarPantalla(Pantalla.TAMANOS) }
                )
            }
        }
        Column(modifier = Modifier
            .drawBehind {
                val strokeWidth = 0.5.dp.toPx()
                val y = size.height - strokeWidth
                drawLine(
                    color = black,
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = strokeWidth
                )
            }
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
                Text(
                    "Seleccionar cantidad"
                )
                Spacer(modifier = Modifier.weight(1f))
                botonnum()
            }
        }
    }
}

@Composable
fun Salsa() {
    var white = MaterialTheme.colorScheme.background
    var black = MaterialTheme.colorScheme.onBackground
    var primary = MaterialTheme.colorScheme.primary
    var secundary = MaterialTheme.colorScheme.secondary
    var tertiary = MaterialTheme.colorScheme.tertiary
    Column(modifier = Modifier.padding(bottom = 8.dp)) {
        Column(
            modifier = Modifier
                .background(secundary)
                .fillMaxWidth()
        ) {
            Text(
                "2. SALSA",
                fontWeight = FontWeight.Bold,
                color = white,
                modifier = Modifier.padding(8.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            ingredientes(caracteristica = "Salsa de tomate")
        }
    }
}

@Composable
fun Queso(){
    var white = MaterialTheme.colorScheme.background
    var black = MaterialTheme.colorScheme.onBackground
    var primary = MaterialTheme.colorScheme.primary
    var secundary = MaterialTheme.colorScheme.secondary
    var tertiary = MaterialTheme.colorScheme.tertiary
    Column(modifier = Modifier.padding(bottom = 8.dp)) {
        Column(
            modifier = Modifier
                .background(secundary)
                .fillMaxWidth()
        ) {
            Text(
                "3. QUESO",
                fontWeight = FontWeight.Bold,
                color = white,
                modifier = Modifier.padding(8.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            ingredientespizza(caracteristica = "Queso 100% mozarella")
        }
    }
}

@Composable
fun Ingredientes_Pizza(){
    var white = MaterialTheme.colorScheme.background
    var black = MaterialTheme.colorScheme.onBackground
    var primary = MaterialTheme.colorScheme.primary
    var secundary = MaterialTheme.colorScheme.secondary
    var tertiary = MaterialTheme.colorScheme.tertiary
    var showCarnes by remember { mutableStateOf(true)}
    var showVegetales by remember { mutableStateOf(false)}
    Column (modifier = Modifier
        .background(secundary)
        .fillMaxWidth()) {
        Text("4. INGREDIENTES",
            fontWeight = FontWeight.Bold,
            color = white,
            modifier = Modifier.padding(8.dp)
        )
    }
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .weight(1f)
                    .height(30.dp)
                    .drawBehind {
                        val strokeWidth = 3.dp.toPx()
                        val y = size.height - strokeWidth
                        drawLine(
                            color = if (showCarnes) secundary else Color.Transparent,
                            start = Offset(0f, y),
                            end = Offset(size.width, y),
                            strokeWidth = strokeWidth
                        )
                    }
                    .clickable {
                        showCarnes = true
                        showVegetales = false
                    }
            ){
                Text(
                    text = "CARNES",
                    textAlign = TextAlign.Center,
                    color = if(showCarnes) secundary else black,
                    fontWeight = if(showCarnes) FontWeight.Bold else FontWeight.Normal
                )
            }
            Box(contentAlignment = Alignment.Center, modifier = Modifier
                .weight(1f)
                .height(30.dp)
                .drawBehind {
                    val strokeWidth = 3.dp.toPx()
                    val y = size.height - strokeWidth
                    drawLine(
                        color = if (showVegetales) secundary else Color.Transparent,
                        start = Offset(0f, y),
                        end = Offset(size.width, y),
                        strokeWidth = strokeWidth
                    )
                }
                .clickable {
                    showVegetales = true
                    showCarnes = false
                }
            ){
                Text(
                    text = "VEGETALES",
                    textAlign = TextAlign.Center,
                    color = if(showVegetales) secundary else black,
                    fontWeight = if(showVegetales) FontWeight.Bold else FontWeight.Normal
                )
            }
        }
        if(showCarnes) {
            Subingredientes_Pizza(caracteristica = "Pepperoni")
            Subingredientes_Pizza(caracteristica = "Jamón")
            Subingredientes_Pizza(caracteristica = "Carne molida")
            Subingredientes_Pizza(caracteristica = "Tocino")
            Subingredientes_Pizza(caracteristica = "Chorizo")
            Subingredientes_Pizza(caracteristica = "Pollo")
            Subingredientes_Pizza(caracteristica = "Salami")
        }
        if (showVegetales){
            Subingredientes_Pizza(caracteristica = "Salsa Fuego")
            Subingredientes_Pizza(caracteristica = "Champiñones frescos")
            Subingredientes_Pizza(caracteristica = "Piña")
            Subingredientes_Pizza(caracteristica = "Jalapeños")
            Subingredientes_Pizza(caracteristica = "Pimiento")
            Subingredientes_Pizza(caracteristica = "Cebolla")
            Subingredientes_Pizza(caracteristica = "Aceitunas")
            Subingredientes_Pizza(caracteristica = "Queso crema")
            Subingredientes_Pizza(caracteristica = "Queso chedar")
            Subingredientes_Pizza(caracteristica = "Queso parmesano")
            Subingredientes_Pizza(caracteristica = "Salsa mango habanero")
        }
    }
}

@Composable
fun Subingredientes_Pizza(caracteristica:String){
    var black = MaterialTheme.colorScheme.onBackground
    Box(modifier = Modifier
        .drawBehind {
            val strokeWidth = 0.5.dp.toPx()
            val y = size.height - strokeWidth
            drawLine(
                color = black,
                start = Offset(0f, y),
                end = Offset(size.width, y),
                strokeWidth = strokeWidth
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(vertical = 15.dp)
        ) {
            ingredientespizza(caracteristica = caracteristica)
        }
    }
}

/*
@Preview(showSystemUi = true)
@Composable
fun previewDetallespizza(){
    DominosPizzaTheme {
        Column {
            Ingredientes_Pizza()
        }
    }
}
 */


@Preview(showSystemUi = true)
@Composable
fun previewDetallespizza(){
    DominosPizzaTheme {
        var pantallaActual by remember { mutableStateOf(Pantalla.DETALLESPIZZA) }
        PantallaActual(pantallaActual) { nuevaPantalla ->
            pantallaActual = nuevaPantalla
        }
    }
}