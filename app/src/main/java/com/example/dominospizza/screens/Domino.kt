package com.example.dominospizza.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dominospizza.R
import com.example.dominospizza.ui.theme.DominosPizzaTheme

typealias OnCambiarPantalla_Domino = (Pantalla) -> Unit

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Domino(onCambiarPantalla: OnCambiarPantalla_Domino){
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
                        Text("Domino's",
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.background)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {onCambiarPantalla(Pantalla.INICIO)}) {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "HOME",
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
            BodyDomino(onCambiarPantalla)
        }
    }
}

@Composable
fun BodyDomino(onCambiarPantalla: OnCambiarPantalla_Domino){
    var white = MaterialTheme.colorScheme.background
    var black = MaterialTheme.colorScheme.onBackground
    var primary = MaterialTheme.colorScheme.primary
    var secundary = MaterialTheme.colorScheme.secondary
    var tertiary = MaterialTheme.colorScheme.tertiary
    Column(
        modifier = Modifier
            .padding(horizontal = 5.dp)
    ) {
        Box (
            modifier = Modifier
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
        ){
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 10.dp
                    )
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = { onCambiarPantalla(Pantalla.MENU) },
                    border = BorderStroke(2.dp,secundary),
                    shape = RoundedCornerShape(3.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = white),
                    modifier = Modifier
                        .width(150.dp).height(40.dp)
                ) {
                    Row (verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.restaurant_menu),
                            contentDescription = "menu",
                            tint = secundary,
                            modifier = Modifier.width(25.dp)
                        )
                        Text("MENÚ",
                            color = secundary,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 5.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(end = 10.dp))
                Button(
                    onClick = {onCambiarPantalla(Pantalla.PROMOS)},
                    border = BorderStroke(2.dp,secundary),
                    shape = RoundedCornerShape(3.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = white),
                    modifier = Modifier
                        .width(150.dp).height(40.dp)
                ) {
                    Row (verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.promos),
                            contentDescription = "promos",
                            tint = secundary,
                            modifier = Modifier.width(25.dp)
                        )
                        Text("PROMOS",
                            color = secundary,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 5.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(end = 10.dp))
                IconButton(onClick = {onCambiarPantalla(Pantalla.PAGO)}) {
                    Box {
                        Icon(
                            imageVector = Icons.Filled.ShoppingCart,
                            contentDescription = "ShoppingCart",
                            tint = secundary,
                        )
                    }
                }
            }
        }
        Box (
            modifier = Modifier
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
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Recoger en:", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", fontSize = 14.sp)
                    Text("Tiempo de entrega:", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    Text("Lorem", fontSize = 14.sp)
                }
                Text("VER DETALLE",
                    fontSize = 14.sp,
                    textAlign = TextAlign.End,
                    fontWeight = FontWeight.Bold,
                    color = secundary,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.padding(start = 50.dp)
                )
            }
        }
        Column (
            modifier = Modifier.padding(10.dp)
        ) {
            Text("¡Inspírate con estas promos!",fontWeight = FontWeight.Bold,modifier = Modifier.padding(vertical = 5.dp))
            Image(
                painter = painterResource(id = R.drawable.fondo),
                contentDescription = "Fondo",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .padding(top = 10.dp)
                    .clip(shape = RoundedCornerShape(4.dp))
                    .height(130.dp)
            )
            Text("CARRITO VACÍO",
                textAlign = TextAlign.Center,fontSize = 30.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 100.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewDomino() {
    DominosPizzaTheme {
        var pantallaActual by remember { mutableStateOf(Pantalla.DOMINO) }
        PantallaActual(pantallaActual) { nuevaPantalla ->
            pantallaActual = nuevaPantalla
        }
    }
}