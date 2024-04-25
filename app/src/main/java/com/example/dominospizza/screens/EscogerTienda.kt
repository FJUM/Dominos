package com.example.dominospizza.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dominospizza.ui.theme.DominosPizzaTheme
import com.example.dominospizza.R

typealias OnCambiarPantalla_EscogerTienda = (Pantalla) -> Unit

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EscogerTienda(onCambiarPantalla: OnCambiarPantalla_EscogerTienda){
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
                        Text("Escoge tu tienda",
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.background)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { onCambiarPantalla(Pantalla.INICIO) }) {
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
        Box(){
            Image(
                painter = painterResource(id = R.drawable.mapa),
                contentDescription = "Mapa",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier.fillMaxSize()
            )
            Column (modifier = Modifier.padding(top = 70.dp)) {
                Buscador()
                BodyEscogerTienda(onCambiarPantalla)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Buscador(){
    var text by remember { mutableStateOf("") }
    var white = MaterialTheme.colorScheme.background
    var black = MaterialTheme.colorScheme.onBackground
    TextField(
        value = "",
        onValueChange = { text = it },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = white,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search",
                tint = black.copy(alpha = 0.5f),
            )
        },
        placeholder = { Text(
            "Buscar dirección",
            color = black.copy(0.2f),
            fontWeight = FontWeight.Bold
        )
        },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun BodyEscogerTienda(onCambiarPantalla: OnCambiarPantalla_EscogerTienda){
    val sucursalesList = listOf(
        SucursalItem(
            id="1",
            nombre = "Lorem ipsum dolor sit amet",
            direccion = "Lorem ipsum dolor sit amet.Lorem ipsum dolor sit amet",
            ciudad = "Lorem"
        ),
        SucursalItem(
            id="2",
            nombre = "Lorem ipsum dolor sit amet",
            direccion = "Lorem ipsum dolor sit amet.Lorem ipsum dolor sit amet",
            ciudad = "Lorem"
        ),
        SucursalItem(
            id="3",
            nombre = "Lorem ipsum dolor sit amet",
            direccion = "Lorem ipsum dolor sit amet.Lorem ipsum dolor sit amet",
            ciudad = "Lorem"
        ),
        SucursalItem(
            id="4",
            nombre = "Lorem ipsum dolor sit amet",
            direccion = "Lorem ipsum dolor sit amet.Lorem ipsum dolor sit amet",
            ciudad = "Lorem"
        ),
        SucursalItem(
            id="5",
            nombre = "Lorem ipsum dolor sit amet",
            direccion = "Lorem ipsum dolor sit amet.Lorem ipsum dolor sit amet",
            ciudad = "Lorem"
        ),
        SucursalItem(
            id="6",
            nombre = "Lorem ipsum dolor sit amet",
            direccion = "Lorem ipsum dolor sit amet.Lorem ipsum dolor sit amet",
            ciudad = "Lorem"
        ),
        SucursalItem(
            id="7",
            nombre = "Lorem ipsum dolor sit amet",
            direccion = "Lorem ipsum dolor sit amet.Lorem ipsum dolor sit amet",
            ciudad = "Lorem"
        ),
        SucursalItem(
            id="8",
            nombre = "Lorem ipsum dolor sit amet",
            direccion = "Lorem ipsum dolor sit amet.Lorem ipsum dolor sit amet",
            ciudad = "Lorem"
        )
    )
    LazyColumn (
        modifier = Modifier.padding(top = 500.dp)
    ){
        items(sucursalesList) { sucursal ->
            Sucursales(sucursal, onClick={onCambiarPantalla(Pantalla.DOMINO)})
        }
    }

}

data class SucursalItem(val id:String,val nombre:String, val direccion:String,val ciudad:String)

@Composable
fun Sucursales(sucursal:SucursalItem,onClick:()->Unit){
    var white = MaterialTheme.colorScheme.background
    var black = MaterialTheme.colorScheme.onBackground
    var primary = MaterialTheme.colorScheme.primary
    var secundary = MaterialTheme.colorScheme.secondary
    var tertiary = MaterialTheme.colorScheme.tertiary
    Box(
        modifier = Modifier
            .background(white)
            .clickable { onClick() }
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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp,
                    bottom = 5.dp
                )
                .fillMaxWidth()
        ){
            Text(
                sucursal.id,
                color = primary,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(end = 10.dp)
            )
            Column (
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .weight(1f)
                    .drawBehind {
                        val strokeWidth = 0.5.dp.toPx()
                        val halfStrokeWidth = strokeWidth / 2
                        val y = size.height - strokeWidth
                        drawLine(
                            color = black,
                            start = Offset(halfStrokeWidth, 0f),
                            end = Offset(halfStrokeWidth, y),
                            strokeWidth = strokeWidth
                        )
                    }
            ) {
                Column (
                    modifier = Modifier
                        .padding(
                            top = 3.dp,
                            bottom = 3.dp,
                            start = 10.dp
                        )
                ) {
                    Text(sucursal.nombre,
                        color = secundary,
                        fontWeight = FontWeight.Bold
                    )
                    Text(sucursal.direccion,
                        color = black,
                        fontWeight = FontWeight.Bold
                    )
                    Text(sucursal.ciudad,
                        color = black.copy(0.3f),
                    )
                }


            }
            Icon(
                imageVector = Icons.Filled.Info,
                contentDescription = "Search",
                tint = secundary,
                modifier = Modifier
                    .padding(start = 10.dp)
            )
        }
    }
}

/*
@Preview(showSystemUi = true)
@Composable
fun PreviewEscogerTienda(){
    DominosPizzaTheme {
        var pantallaActual by remember { mutableStateOf(Pantalla.ESCOGER_TIENDA) }
        PantallaActual(pantallaActual) { nuevaPantalla ->
            pantallaActual = nuevaPantalla
        }
    }
}
 */

@Preview(showSystemUi = true)
@Composable
fun PreviewEscogerTienda(){
    DominosPizzaTheme {
        EscogerTienda (onCambiarPantalla={})
    }
}