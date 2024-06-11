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
fun PrestamosIntereses(){
    var CantidadPrestamo by rememberSaveable {
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
                    text = "Calculadora de Préstamos",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Espacio(tamanio = 16)
                OutlinedTextField(
                    value = CantidadPrestamo,
                    onValueChange = { CantidadPrestamo = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Ingrese el monto del préstamo") },
                    maxLines = 1,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Espacio(tamanio = 16)
                Button(
                    onClick = {
                        val amount = CantidadPrestamo.toDoubleOrNull()
                        if (amount != null) {
                            val (interest, installments) = when {
                                amount > 5000 -> 0.10 to 3
                                amount < 1000 -> 0.12 to 1
                                amount in 2000.0..3000.0 -> 0.12 to 2
                                else -> 0.12 to 5
                            }
                            val totalAmount = amount * (1 + interest)
                            val installmentAmount = totalAmount / installments
                            Resultado = "Total a pagar: $totalAmount\nNúmero de cuotas: $installments\nMonto por cuota: $installmentAmount"
                        } else {
                            Resultado = "Por favor, ingrese un monto válido"
                        }
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