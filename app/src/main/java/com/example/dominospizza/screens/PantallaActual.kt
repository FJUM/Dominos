package com.example.dominospizza.screens

import androidx.compose.runtime.Composable

@Composable
fun PantallaActual(pantallaActual: Pantalla, onCambiarPantalla: (Pantalla) -> Unit) {
    when (pantallaActual) {
        Pantalla.INICIO -> Inicio(onCambiarPantalla = onCambiarPantalla)
        Pantalla.ESCOGER_TIENDA -> EscogerTienda(onCambiarPantalla = onCambiarPantalla)
        Pantalla.MENU -> Menu(onCambiarPantalla = onCambiarPantalla)
        Pantalla.ENTRADAS -> Entradas(onCambiarPantalla = onCambiarPantalla)
        Pantalla.POSTRES -> Postres(onCambiarPantalla = onCambiarPantalla)
        Pantalla.SALSAS -> Salsas(onCambiarPantalla = onCambiarPantalla)
        Pantalla.PIZZA -> Pizza(onCambiarPantalla = onCambiarPantalla)
        Pantalla.POLLO -> Pollo(onCambiarPantalla = onCambiarPantalla)
        Pantalla.BEBIDAS -> Bebidas(onCambiarPantalla = onCambiarPantalla)
        Pantalla.MASAS -> Masas(onCambiarPantalla = onCambiarPantalla)
        Pantalla.TAMANOS -> Tamanos(onCambiarPantalla = onCambiarPantalla)
        Pantalla.DOMINO -> Domino(onCambiarPantalla = onCambiarPantalla)
        Pantalla.DETALLES -> Detalles(onCambiarPantalla = onCambiarPantalla)
        Pantalla.DETALLESPIZZA -> Detallespizza(onCambiarPantalla = onCambiarPantalla)
        Pantalla.PROMOS -> Promos(onCambiarPantalla = onCambiarPantalla)
        Pantalla.PAGO -> Pago(onCambiarPantalla = onCambiarPantalla)
    }
}