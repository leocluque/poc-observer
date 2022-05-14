package com.example.authtoken

import com.example.authtoken.listeners.TokenListener
import com.example.factorhub.event.EventManager

object Client {

    // inicia o modulo passando a instancia do EventManager(factorHub) instanciado
    // no modulo de auth hub
    fun init() {
        TokenListener(EventManager)
    }
}