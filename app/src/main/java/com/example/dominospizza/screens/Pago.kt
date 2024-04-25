@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class
)

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.textFieldColors
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dominospizza.R
import com.example.dominospizza.ui.theme.DominosPizzaTheme

typealias OnCambiarPantalla_Pago = (Pantalla) -> Unit

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Pago(onCambiarPantalla: OnCambiarPantalla_Pago){
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
                        Text("PAGO",
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.background)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {onCambiarPantalla(Pantalla.INICIO)}) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
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
        Column (modifier = Modifier.padding(top = 65.dp)) {
            BodyPago(onCambiarPantalla)
        }
    }
}

@Composable
fun BodyPago(onCambiarPantalla: OnCambiarPantalla_Pago){
    var white = MaterialTheme.colorScheme.background
    var black = MaterialTheme.colorScheme.onBackground
    var primary = MaterialTheme.colorScheme.primary
    var secundary = MaterialTheme.colorScheme.secondary
    var tertiary = MaterialTheme.colorScheme.tertiary
    Column (modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(black.copy(alpha = 0.1f))
        ) {
            Text(
                "Total $---",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
        }
        LazyColumn(modifier = Modifier.weight(1f)) {
            item {
                Iniciosesion()
            }
            item {
                Direccion()
            }
            item {
                Image(
                    painter = painterResource(id = R.drawable.mapa),
                    contentDescription = "Fondo",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .height(250.dp)
                        .fillMaxWidth()
                )
            }
            item {
                Datos()
            }
            item{
                Pagos()
            }
            item{
                Ofertas()
            }
            item {
                Terminos()
            }
        }
        Button(
            onClick = {onCambiarPantalla(Pantalla.INICIO) },
            shape = RoundedCornerShape(3.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 7.dp, end = 7.dp)
        ) {
            Text("ORDENAR", fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun Terminos(){
    Column (modifier = Modifier.padding(horizontal = 20.dp)){
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Text("Al realizar tu pedido, aceptas nuestros TÉRMINOS DE USO y que tienes al menos 13 años.", fontSize = 13.sp, textAlign = TextAlign.Center, color = MaterialTheme.colorScheme.onBackground.copy(0.5f))
        Spacer(modifier = Modifier.padding(top = 30.dp))
        Text("Nuestros términos y condiciones han cambiado, te invicamos a que los consultes en www.dominos.com.mx", fontSize = 13.sp, textAlign = TextAlign.Center, color = MaterialTheme.colorScheme.onBackground.copy(0.5f))
        Spacer(modifier = Modifier.padding(top = 30.dp))
        Row (verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Filled.Lock,
                contentDescription = "Seguro",
                tint = MaterialTheme.colorScheme.onBackground.copy(0.5f),
            )
            Text("Las transacciones están encriptadas y son seguras", fontSize = 13.sp, color = MaterialTheme.colorScheme.onBackground.copy(0.5f))
        }
        Spacer(modifier = Modifier.padding(top = 100.dp))
    }
}

@Composable
fun Ofertas() {
    val checked = remember { mutableStateOf(true) }
    Row (verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth()
    ){
        Checkbox(
            checked = checked.value,
            onCheckedChange = { checked.value = it },
            colors = CheckboxDefaults.colors(checkedColor = MaterialTheme.colorScheme.secondary)
        )
        Text("Recibir ofertas de Domino's Pizza por e-mail", fontWeight = FontWeight.Bold, fontSize = 15.sp)
    }
}

@Composable
fun Datos(){
    var black = MaterialTheme.colorScheme.onBackground
    var secundary = MaterialTheme.colorScheme.secondary
    Column (modifier = Modifier.padding(horizontal = 20.dp)){
        Box(modifier = Modifier
            .drawBehind {
                val strokeWidth = 0.5.dp.toPx()
                val y = size.height - strokeWidth
                drawLine(
                    color = black.copy(0.5f),
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = strokeWidth
                )
            }
        ) {
            Text("Ingresa tus datos:", color = secundary, fontWeight = FontWeight.Bold,modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp))
        }
        DatosField(titulo = "Nombre(s)", prioridad = "Requerido")
        DatosField(titulo = "Apellidos", prioridad = "Requerido")
        DatosField(titulo = "Teléfono / Celular", prioridad = "Requerido")
        DatosField(titulo = "Extensión", prioridad = "Opcional")
        DatosField(titulo = "E-mail", prioridad = "Requerido")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatosField(titulo:String,prioridad:String){
    var text by remember { mutableStateOf("Hello") }
    var white = MaterialTheme.colorScheme.background
    var black = MaterialTheme.colorScheme.onBackground
    Box (modifier = Modifier
        .fillMaxWidth()
        .drawBehind {
            val strokeWidth = 0.5.dp.toPx()
            val y = size.height - strokeWidth
            drawLine(
                color = black.copy(0.5f),
                start = Offset(0f, y),
                end = Offset(size.width, y),
                strokeWidth = strokeWidth
            )
        }
    ){
        Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 5.dp)){
            Text(titulo, modifier = Modifier.weight(1f), color = black.copy(0.8f))
            TextField(value = "",
                onValueChange = { text = it },
                placeholder = {
                    Text(
                        prioridad,
                        color = black.copy(0.5f),
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = textFieldColors(
                    containerColor = white,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                modifier = Modifier.width(200.dp)
            )
        }
    }
}

@Composable
fun Iniciosesion(){
    var white = MaterialTheme.colorScheme.background
    var black = MaterialTheme.colorScheme.onBackground
    var primary = MaterialTheme.colorScheme.primary
    var secundary = MaterialTheme.colorScheme.secondary
    var tertiary = MaterialTheme.colorScheme.tertiary
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
        Column(modifier = Modifier.padding(start = 50.dp, end = 50.dp, top = 20.dp, bottom = 20.dp)
        ) {
            Text(
                "Continua como invitado o inicia sesión para pagar más rápido.",
                textAlign = TextAlign.Center
            )
            Box(modifier = Modifier.padding(top = 10.dp, start = 50.dp, end = 50.dp)) {
                Box(
                    modifier = Modifier
                        .background(
                            color = white,
                            shape = RoundedCornerShape(5.dp)
                        )
                        .border(
                            width = 2.dp,
                            color = primary,
                            shape = RoundedCornerShape(5.dp)
                        )
                        .fillMaxWidth()
                ) {
                    Text(
                        "INICIAR SESIÓN",
                        color = primary,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(15.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun Direccion(){
    var white = MaterialTheme.colorScheme.background
    var black = MaterialTheme.colorScheme.onBackground
    var primary = MaterialTheme.colorScheme.primary
    var secundary = MaterialTheme.colorScheme.secondary
    var tertiary = MaterialTheme.colorScheme.tertiary
    Box () {
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
}

@Composable
fun Pagos(){
    var secundary = MaterialTheme.colorScheme.secondary
    var black = MaterialTheme.colorScheme.onBackground
    Column(modifier = Modifier.padding(horizontal = 15.dp)) {
        Box(modifier = Modifier
            .fillMaxWidth()
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
            Text(
                "Selecciona tu método de pago:",
                color = secundary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 15.dp)
            )
        }
        BotonRadio(
            titulo = "Paga en línea",
            descripcion = "Visa, Mastercard o American Express.",
            selected = true
        )
        BotonRadio(
            titulo = "Paga en efectivo",
            descripcion = "Nuestros repartidores llevarán máximo $200 de cambio.",
            selected = false
        )
        BotonRadio(
            titulo = "Paga con vales CDMX",
            descripcion = "Con esta forma de pago no se da cambio.",
            selected = false
        )
        BotonRadio(
            titulo = "Paga con crédito en la tienda",
            descripcion = "Nuestros repartidores llevarán la terminal bancaria.",
            selected = false
        )
    }
}

@Composable
fun BotonRadio(titulo:String,descripcion:String,selected:Boolean){
    var black = MaterialTheme.colorScheme.onBackground
    Column (modifier = Modifier
        .fillMaxWidth()
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
        .padding(vertical = 10.dp)
    ) {
        Row (verticalAlignment = Alignment.CenterVertically) {
            Column (modifier = Modifier.weight(1f)){
                Text(titulo, fontWeight = FontWeight.Bold)
                Text(descripcion, fontSize = 12.sp)
            }
            RadioButton(
                selected = selected,
                onClick = { },
                colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colorScheme.secondary)
            )
        }
    }
}



@Preview(showSystemUi = true)
@Composable
fun PreviewPagoTOTAL() {
    DominosPizzaTheme {
        var pantallaActual by remember { mutableStateOf(Pantalla.PAGO) }
        PantallaActual(pantallaActual) { nuevaPantalla ->
            pantallaActual = nuevaPantalla
        }
    }
}


/*
@Preview(showSystemUi = true)
@Composable
fun PreviewPago() {
    DominosPizzaTheme {
        Terminos()
    }
}

 */


