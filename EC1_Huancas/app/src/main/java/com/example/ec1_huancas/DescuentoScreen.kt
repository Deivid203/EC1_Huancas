package com.example.ec1_huancas

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun DescuentoAlm(){
    var Cantidad by rememberSaveable {
        mutableStateOf("")
    }
    var Precio by rememberSaveable {
        mutableStateOf("")
    }
    var Resultado by rememberSaveable {
        mutableStateOf("")}

    Box(
        modifier = Modifier.fillMaxSize().padding(top = 40.dp)
    ) {
        Column {
            Text(
                text = "Descuento en el Almacén",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Espacio(tamanio = 16)
            OutlinedTextField(
                value = Cantidad,
                onValueChange = { Cantidad = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese la cantidad") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Espacio(tamanio = 16)
            OutlinedTextField(
                value = Precio,
                onValueChange = { Precio = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese el precio") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Espacio(tamanio = 16)
            Button(
                onClick = {
                    val total = Cantidad.toDouble() * Precio.toDouble()
                    val descuento = if (total > 200) total * 0.20 else 0.0
                    val precioFinal = total - descuento
                    Resultado = "Total a pagar: $precioFinal"
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Calcular")
            }
            Espacio(tamanio = 16)
            Text(text = Resultado)
        }
    }
}


@Composable
fun Espacio(tamanio: Int) {
    Spacer(modifier = Modifier.height(tamanio.dp))
}