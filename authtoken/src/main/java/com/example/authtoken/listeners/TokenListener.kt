package com.example.authtoken.listeners

import com.example.factorhub.event.EventListener
import com.example.factorhub.event.EventManager
import com.example.factorhub.event.EventResult
import org.json.JSONObject

class TokenListener(eventManager: EventManager) : EventListener {

    // informa o factor hub que é responsavel pelo evento getOtp
    init {
        eventManager.subscribe("getOtp", this)
    }

    // recebe e trata o evento e devolve sua resposta
    override fun <T> event(eventType: String?, data: T, result: EventResult) {
        when (eventType) {
            "getOtp" -> {
                val isError = (data as JSONObject).getBoolean("isError")
                if (!isError) {
                    result.success(eventType, "123456")
                } else {
                    result.fail(eventType, "Deu ruim pra pegar o token")
                }
            }
        }
    }

}