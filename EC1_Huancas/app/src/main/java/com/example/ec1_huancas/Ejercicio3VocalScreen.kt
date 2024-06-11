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
fun VocalCorrespondiente(){
    var Numero by rememberSaveable {
        mutableStateOf("")
    }
    var Resultado by rememberSaveable {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Column {
            Text(
                text = "Vocal Correspondiente",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Espacio(tamanio = 16)
            OutlinedTextField(
                value = Numero,
                onValueChange = { Numero = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese un número") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Espacio(tamanio = 16)
            Button(
                onClick = {
                    val num = Numero.toIntOrNull()
                    Resultado = when (num) {
                        1 -> "A"
                        2 -> "E"
                        3 -> "I"
                        4 -> "O"
                        5 -> "U"
                        else -> "Número no corresponde a una vocal"
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Verificar")
            }
            Espacio(tamanio = 16)
            Text(text = Resultado)
        }
    }
}