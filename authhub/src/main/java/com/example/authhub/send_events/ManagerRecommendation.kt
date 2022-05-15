package com.example.authhub.send_events

import com.example.factorhub.event.EventManager
import com.example.factorhub.event.EventResult
import org.json.JSONObject

object ManagerRecommendation : EventResult {

    // instancia o eventManager(para uso no auth hub)
    private var events = EventManager

    // Registra os possiveis eventos q podem ser enviados
    init {
        events.registerOperations(listOf("getOtp"))
    }

    // solicita o otp passando os dados necessarios ex: cpf etc. o parametro isError
    // é apenas para mockar a chamada no app demonstrando os dois cenarios sucesso e erro.
    fun requireOtp(error: Boolean) {
        val json = JSONObject()
        json.put("name", "Leonardo")
        json.put("isError", error)
        // pode implementar na classe o callback ou implementar para cada notificação
        events.notify("getOtp", json, this)

        // implementa e espera o resultado direto na notificação.
//        events.notify("getOtp", json, object : EventResult {
//            override fun <T> success(eventType: String, result: T) {
//                // trata o sucesso
//            }
//
//            override fun fail(eventType: String, error: String) {
//               // trata o erro
//            }
//
//        })
    }

    override fun <T> success(eventType: String, result: T) {
        when (eventType) {
            "getOtp" -> println(result as String)
        }
    }

    override fun fail(eventType: String, error: String) {
        when (eventType) {
            "getOtp" -> println(error)
        }
    }

}