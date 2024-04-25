package com.example.dominospizza.resources

import android.webkit.WebSettings.TextSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dominospizza.ui.theme.DominosPizzaTheme

@Composable
fun botonnum(){
    Row (verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .width(30.dp).height(30.dp)
                .clickable {  }
                .background(
                    color = MaterialTheme.colorScheme.background,
                    shape = RoundedCornerShape(topStart = 2.dp, bottomStart = 2.dp)
                )
                .border(
                    width = 0.5.dp,
                    color = MaterialTheme.colorScheme.onBackground,
                    shape = RoundedCornerShape(topStart = 2.dp, bottomStart = 2.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "-",
                fontSize = 15.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .height(30.dp).width(30.dp)
                .border(BorderStroke(0.5.dp, MaterialTheme.colorScheme.onBackground))
        ){
            Text("1", fontSize = 15.sp)
        }
        Box(
            modifier = Modifier
                .width(30.dp).height(30.dp)
                .clickable {  }
                .background(
                    color = MaterialTheme.colorScheme.background,
                    shape = RoundedCornerShape(topEnd = 2.dp, bottomEnd = 2.dp)
                )
                .border(
                    width = 0.5.dp,
                    color = MaterialTheme.colorScheme.onBackground,
                    shape = RoundedCornerShape(topEnd = 2.dp, bottomEnd = 2.dp)
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



}

@Preview
@Composable
fun previewbotonnum(){
    DominosPizzaTheme {
        botonnum()
    }
}
