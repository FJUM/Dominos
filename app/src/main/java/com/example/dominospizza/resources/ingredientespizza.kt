package com.example.dominospizza.resources

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dominospizza.ui.theme.DominosPizzaTheme
import com.example.dominospizza.R

@Composable
fun ingredientespizza(caracteristica:String){
    var showañadir by remember { mutableStateOf(false) }
    Column {
        Row {
            Text(caracteristica)
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = if (showañadir) "Toca para eliminar" else "Toca para agregar",
                modifier = Modifier
                    .clickable { showañadir = !showañadir }
            )
        }

        if (showañadir) {
            contenidopizza()
        }
    }
}

@Composable
fun contenidopizza(){
    Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier
        .fillMaxWidth()
        .padding(top = 20.dp)) {
        pizza()
        Spacer(modifier = Modifier.weight(1f))
        opciones()
    }
}

@Composable
fun pizza(){
    var secundary = MaterialTheme.colorScheme.secondary
    var black = MaterialTheme.colorScheme.onBackground
    Row {
        Icon(
            painter = painterResource(id = R.drawable.pizza_media_izquierda),
            contentDescription = "media_pizza_izq",
            tint = black.copy(alpha = 0.3f),
            modifier = Modifier.width(30.dp)
        )
        Spacer(modifier = Modifier.padding(start = 8.dp))
        Icon(
            painter = painterResource(id = R.drawable.pizza_completa),
            contentDescription = "media_pizza_completa",
            tint = secundary,
            modifier = Modifier.width(30.dp)
        )
        Spacer(modifier = Modifier.padding(start = 8.dp))
        Icon(
            painter = painterResource(id = R.drawable.pizza_media_derecha),
            contentDescription = "media_pizza_der",
            tint = black.copy(alpha = 0.3f),
            modifier = Modifier.width(30.dp)
        )
    }
}

@Composable
fun opciones(){
    Box(
        modifier = Modifier
            .width(20.dp)
            .height(20.dp)
            .clickable { }
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(50.dp)
            )
            .border(
                width = 0.5.dp,
                color = MaterialTheme.colorScheme.onBackground,
                shape = RoundedCornerShape(50.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "-",
            fontSize = 15.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
    Spacer(modifier = Modifier.padding(start = 10.dp))
    Text("Normal")
    Spacer(modifier = Modifier.padding(end = 10.dp))
    Box(
        modifier = Modifier
            .width(20.dp)
            .height(20.dp)
            .clickable { }
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(50.dp)
            )
            .border(
                width = 0.5.dp,
                color = MaterialTheme.colorScheme.onBackground,
                shape = RoundedCornerShape(50.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "+",
            fontSize = 15.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}
@Preview(showSystemUi = true)
@Composable
fun previewingredientespizza(){
    DominosPizzaTheme {
        ingredientespizza(caracteristica = "Queso 100% mozarella")
    }
}