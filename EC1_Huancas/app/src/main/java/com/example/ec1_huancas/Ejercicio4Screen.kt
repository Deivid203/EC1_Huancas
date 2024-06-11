package com.example.ec1_huancas

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
fun LimiteNumero (){
    var LimiteNumero by rememberSaveable {
        mutableStateOf("")
    }
    var Resultado by rememberSaveable {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
    ) {
        Column {
            Text(
                text = "Cubo y Cuarta de Números",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Espacio(tamanio = 10)
            OutlinedTextField(
                value = LimiteNumero,
                onValueChange = { LimiteNumero= it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese el límite") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Espacio(tamanio = 10)
            Button(
                onClick = {
                    val lim = LimiteNumero.toIntOrNull()
                    if (lim != null && lim > 0) {
                        Resultado = calcularCuboCuarta(lim)
                    } else {
                        Resultado = "Por favor ingrese un número válido como límite."
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Calcular")
            }
            Espacio(tamanio = 10)
            Text(text = Resultado)
        }
    }
}
fun calcularCuboCuarta(limite: Int): String {
    val resultadoBuilder = StringBuilder()
    for (i in 1..limite) {
        val cubo = i * i * i
        val cuarta = i * i * i * i
        resultadoBuilder.append("Número: $i, Cubo: $cubo, Cuarta: $cuarta\n")
    }
    return resultadoBuilder.toString()
}