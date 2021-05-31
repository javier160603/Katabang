package com.example.katabang.utils

import com.example.katabang.utils.Constants.OPEN_GOOGLE
import com.example.katabang.utils.Constants.OPEN_SEARCH
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object BotResponse {

    fun basicResponses(_message: String): String {

        val random = (0..2).random()
        val message =_message.toLowerCase()

        return when {

            //Lanza una moneda
            message.contains("gira") && message.contains("moneda") -> {
                val r = (0..1).random()
                val result = if (r == 0) "Sol" else "Aguila"

                "Lancé la moneda y cayo $result"
            }

            //Operaciones Matematicas
            message.contains("resuelve") -> {
                val equation: String? = message.substringAfterLast("resuelve")
                return try {
                    val answer = SolveMath.solveMath(equation ?: "0")
                    "$answer"

                } catch (e: Exception) {
                    "Disculpa, no puedo resolver eso."
                }
            }

            //Hola
            message.contains("hola") -> {
                when (random) {
                    0 -> "Hola, qué tal?"
                    1 -> "Qué onda?"
                    2 -> "Quiubo!"
                    else -> "error" }
            }

            //Ayuda
            message.contains("ayuda") -> {
                when (random) {
                    0 -> "Esta es mi lista de comandos:\n" +
                            "Gira una moneda\n" +
                            "Hora\n" +
                            "Abrir Google\n" +
                            "Buscar (Palabra que quieras buscar)\n" +
                            "Resuelve (operación)\n" +
                            "Cuentame un chiste"
                    1 -> "Esta es mi lista de comandos:\n" +
                            "Gira una moneda\n" +
                            "Hora\n" +
                            "Abrir Google\n" +
                            "Buscar (Palabra que quieras buscar)\n" +
                            "Resuelve (operación)\n"+
                            "Cuentame un chiste"
                    2 -> "Esta es mi lista de comandos:\n" +
                            "Gira una moneda\n" +
                            "Hora\n" +
                            "Abrir Google\n" +
                            "Buscar (Palabra que quieras buscar)\n" +
                            "Resuelve (operación)\n"+
                            "Cuentame un chiste"
                    else -> "error" }
            }

            //Como estas?
            message.contains("cómo estás") -> {
                when (random) {
                    0 -> "Estoy muy bien, gracias!!"
                    1 -> "Aburrido, la nube es un lugar solitario..."
                    2 -> "Feliz como una lombriz, qué tal tu?"
                    else -> "error"
                }
            }

            //Chiste
            message.contains("chiste") -> {
                when (random) {
                    0 -> "¿Por qué llora un libro de matemáticas?\n" +
                            "¡Porque tiene muchos problemas!"
                    1 -> "¿Cuál es el baile favorito del tomate?\n" +
                            "¡La salsa!"
                    2 -> "¿Qué le dice un pez a otro?\n" +
                            "¡Nada!!"
                    3 -> "¿Qué le dice un gusano a otro?\n" +
                            "Me voy a dar la vuelta a la manzana."
                    else -> "error" }
            }

            //Que hora es?
            message.contains("hora")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }

            //Abrir Google
            message.contains("abre") && message.contains("google")-> {
                OPEN_GOOGLE
            }

            message.contains("abrir") && message.contains("google")-> {
                OPEN_GOOGLE
            }

            //Buscar en internet
            message.contains("busca")-> {
                OPEN_SEARCH
            }
            message.contains("buscar")-> {
                OPEN_SEARCH
            }

            //Cuando el Leo no entiende
            else -> {
                when (random) {
                    0 -> "No entiendo..."
                    1 -> "Prueba decirme algo diferente"
                    2 -> "Aun estoy aprendiendo, prueba con otra cosa..."
                    else -> "error"
                }
            }
        }
    }
}