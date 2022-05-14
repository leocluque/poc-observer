package com.example.pocobserver

import android.app.Application
import com.example.authhub.send_events.ClientAuthHub
import com.example.authtoken.Client

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // inicia o modulo de authHub
        ClientAuthHub.init()
        // inicia o modulo de token
        Client.init()

    }
}