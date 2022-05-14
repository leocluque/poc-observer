package com.example.factorhub.event


interface EventListener {
    // envia o tipo do evento, envia o data caso precise para fazer
    // alguma request etc, e devolve o resultado da solicitação do evento
    fun <T> event(eventType: String?, data: T, result: EventResult)
}