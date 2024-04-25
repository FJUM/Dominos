package com.example.dominospizza.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dominospizza.R
import com.example.dominospizza.ui.theme.DominosPizzaTheme

typealias OnCambiarPantalla_Promos = (Pantalla) -> Unit

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Promos(onCambiarPantalla: OnCambiarPantalla_Promos){
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
                        Text("Promos",
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.background)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { onCambiarPantalla(Pantalla.DOMINO) }) {
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
        Column (modifier = Modifier.padding(top = 70.dp)
        ){
            BodyPromos(onCambiarPantalla)
        }
    }
}

@Composable
fun BodyPromos(onCambiarPantalla: OnCambiarPantalla_Promos) {
    var white = MaterialTheme.colorScheme.background
    var black = MaterialTheme.colorScheme.onBackground
    var primary = MaterialTheme.colorScheme.primary
    var secundary = MaterialTheme.colorScheme.secondary
    var tertiary = MaterialTheme.colorScheme.tertiary

    var showVerTodas by remember { mutableStateOf(true)}
    var showUnaPizza by remember { mutableStateOf(false)}
    var showDosoMasPizzas by remember { mutableStateOf(false)}
    var showCombos by remember { mutableStateOf(false)}

    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Box (modifier = Modifier
            .background(
                color = if(showVerTodas) secundary else white,
                shape = RoundedCornerShape(2.dp)
            )
            .border(width = 2.dp,
                color = if(showVerTodas) Color.Transparent else secundary,
                shape = RoundedCornerShape(2.dp)
            )
            .clickable {
                showVerTodas = true
                showUnaPizza = false
                showDosoMasPizzas = false
                showCombos = false
            }
        ) {
            Text("VER TODAS",
                color = if(showVerTodas) white else secundary,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                modifier = Modifier.padding(8.dp)
            )
        }

        Box (modifier = Modifier
            .background(color = if(showUnaPizza) secundary else white,
                    shape = RoundedCornerShape(2.dp)
            )
            .border(width = 2.dp,
                color = if(showUnaPizza) Color.Transparent else secundary,
                shape = RoundedCornerShape(2.dp))
            .clickable {
                showVerTodas = false
                showUnaPizza = true
                showDosoMasPizzas = false
                showCombos = false
            }
        ) {
            Text("1 PIZZA",
                color = if(showUnaPizza) white else secundary,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                modifier = Modifier.padding(8.dp)
            )
        }

        Box (modifier = Modifier
            .background(
                color = if(showDosoMasPizzas) secundary else white,
                shape = RoundedCornerShape(2.dp)
            )
            .border(width = 2.dp,
                color = if(showDosoMasPizzas) Color.Transparent else secundary,
                shape = RoundedCornerShape(2.dp)
            )
            .clickable {
                showVerTodas = false
                showUnaPizza = false
                showDosoMasPizzas = true
                showCombos = false
            }
        ){
            Text("2 O MÁS PIZZAS",
                color = if(showDosoMasPizzas) white else secundary,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
        Box (modifier = Modifier
            .background(
                color = if(showCombos) secundary else white,
                shape = RoundedCornerShape(2.dp)
            )
            .border(width = 2.dp,
                color = if(showCombos) Color.Transparent else secundary,
                shape = RoundedCornerShape(2.dp)
            )
            .clickable {
                showVerTodas = false
                showUnaPizza = false
                showDosoMasPizzas = false
                showCombos = true
            }
        ){
            Text("COMBOS",
                color = if(showCombos) white else secundary,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
    val promocionesList_todas = listOf(
        PromocionesItem(
            titulo ="Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            precio="$249",
            descripcion ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce in tortor ac massa euismod posuere."
        ),
        PromocionesItem(
            titulo ="Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            precio="$299",
            descripcion ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce in tortor ac massa euismod posuere."
        ),
        PromocionesItem(
            titulo ="Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            precio="$219",
            descripcion ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce in tortor ac massa euismod posuere."
        ),
        PromocionesItem(
            titulo ="Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            precio="$309",
            descripcion ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce in tortor ac massa euismod posuere."
        )
    )
    val promocionesList_unapizza = listOf(
        PromocionesItem(
            titulo ="Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            precio="$129",
            descripcion ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce in tortor ac massa euismod posuere."
        ),
        PromocionesItem(
            titulo ="Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            precio="$158",
            descripcion ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce in tortor ac massa euismod posuere."
        ),
        PromocionesItem(
            titulo ="Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            precio="$189",
            descripcion ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce in tortor ac massa euismod posuere."
        )
    )
    val promocionesList_dosomas = listOf(
        PromocionesItem(
            titulo ="Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            precio="$309",
            descripcion ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce in tortor ac massa euismod posuere."
        )
    )
    val promocionesList_combo = listOf(
        PromocionesItem(
            titulo ="Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            precio="$180",
            descripcion ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce in tortor ac massa euismod posuere."
        ),
        PromocionesItem(
            titulo ="Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            precio="$312",
            descripcion ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce in tortor ac massa euismod posuere."
        )
    )
    val promocionesList = if(showVerTodas){
        promocionesList_todas
    }else if(showUnaPizza){
        promocionesList_unapizza
    }else if(showDosoMasPizzas){
        promocionesList_dosomas
    }else if(showCombos){
        promocionesList_combo
    }else{
        emptyList()
    }

    LazyColumn {
        items(promocionesList){promocion ->
            Promociones(onClick = {onCambiarPantalla(Pantalla.MENU)}, promocion )
        }
    }
}

data class PromocionesItem(val titulo:String, val precio:String, val descripcion:String)

@Composable
fun Promociones(onClick:() -> Unit,promocion:PromocionesItem){
    var white = MaterialTheme.colorScheme.background
    var black = MaterialTheme.colorScheme.onBackground
    var primary = MaterialTheme.colorScheme.primary
    var secundary = MaterialTheme.colorScheme.secondary
    var tertiary = MaterialTheme.colorScheme.tertiary
    Box(modifier = Modifier
        .clickable {onClick()}
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.fondo),
                contentDescription = "Fondo",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .clip(shape = RoundedCornerShape(4.dp))
                    .height(130.dp)
            )
            Row {
                Text(
                    promocion.titulo,
                    modifier = Modifier.weight(1f),
                    fontWeight = FontWeight.Bold,
                    color = black
                )
                Text(
                    promocion.precio, modifier = Modifier.padding(start = 10.dp),
                    fontWeight = FontWeight.Bold,
                    color = secundary,
                    fontSize = 25.sp
                )
            }
            Text(
                promocion.descripcion,
                color = black.copy(alpha = 0.4f),
                fontSize = 15.sp,
                modifier = Modifier.padding(top = 8.dp, bottom = 15.dp)
            )

        }
    }
}

/*
@Preview(showSystemUi = true)
@Composable
fun previewPromos(){
    DominosPizzaTheme {
        Promociones(
            onClick ={} ,
            titulo ="Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            precio="$249",
            descripcion ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce in tortor ac massa euismod posuere."
        )
    }
}

 */


@Preview(showSystemUi = true)
@Composable
fun previewPromos(){
    DominosPizzaTheme {
        var pantallaActual by remember { mutableStateOf(Pantalla.PROMOS) }
        PantallaActual(pantallaActual) { nuevaPantalla ->
            pantallaActual = nuevaPantalla
        }
    }
}