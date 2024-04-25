package com.example.dominospizza.resources

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Boton(onClick:()->Unit,context:String,dirimage:Int){
    var white = MaterialTheme.colorScheme.background
    var black = MaterialTheme.colorScheme.onBackground
    var primary = MaterialTheme.colorScheme.primary
    var secundary = MaterialTheme.colorScheme.secondary
    var tertiary = MaterialTheme.colorScheme.tertiary
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(7.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        modifier = Modifier
            .width(160.dp)
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(7.dp),
                ambientColor = black,
                spotColor = black
            )
    ) {
        Column {
            Image(painter = painterResource(id = dirimage), contentDescription = "pizza")
            Text(context,
                color = secundary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                textAlign = TextAlign.Center)
        }
    }
}