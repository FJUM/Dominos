package com.example.dominospizza.screens

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dominospizza.R
import com.example.dominospizza.ui.theme.DominosPizzaTheme

typealias OnCambiarPantalla_Inicio = (Pantalla) -> Unit

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Inicio(onCambiarPantalla: OnCambiarPantalla_Inicio){
    Scaffold (
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                ),
                title = {

                },
                navigationIcon = {
                    Row {
                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Localized description",
                                tint = MaterialTheme.colorScheme.background
                            )
                        }
                        Spacer(modifier = Modifier.width(120.dp))
                        IconButton(onClick = { /* do something */ }) {
                            Image(
                                painter = painterResource(id = R.drawable.dominos_logo),
                                contentDescription = "Localized description"
                            )
                        }
                    }

                }
            )
        }
    ){
        Box(){
            Image(
                painter = painterResource(id = R.drawable.fondo),
                contentDescription = "Fondo",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier.fillMaxSize()
            )
            BodyInicio(onCambiarPantalla)
        }
    }
}

@Composable
fun BodyInicio(onCambiarPantalla: OnCambiarPantalla_Inicio){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { onCambiarPantalla(Pantalla.ESCOGER_TIENDA)},
            shape = RoundedCornerShape(3.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
        ) {
            Text("ENTREGA",color = Color.White)
        }
        Button(
            onClick = {onCambiarPantalla(Pantalla.ESCOGER_TIENDA)},
            shape = RoundedCornerShape(3.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
        ) {
            Text("RECOGER EN TIENDA",color = Color.White)
        }
        Text(
            "INICIAR SESIÓN",
            color = Color.White,
            modifier = Modifier
                .padding(bottom = 20.dp)
                .background(MaterialTheme.colorScheme.onBackground.copy(alpha = 0.3f)),
            style = TextStyle(
                textDecoration = TextDecoration.Underline,
                /*
                shadow = Shadow(
                    color = Color.Gray,
                    offset = Offset(1f,1f),
                    blurRadius = 2f
                )
                */
            )
        )
    }
}

/*
@Preview(showSystemUi = true)
@Composable
fun PreviewInicio(){
    DominosPizzaTheme {
        var pantallaActual by remember { mutableStateOf(Pantalla.INICIO) }
        PantallaActual(pantallaActual) { nuevaPantalla ->
            pantallaActual = nuevaPantalla
        }
    }
}
 */

@Preview(showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun PreviewInicio(){
    DominosPizzaTheme {
        Inicio (onCambiarPantalla={})
    }
}