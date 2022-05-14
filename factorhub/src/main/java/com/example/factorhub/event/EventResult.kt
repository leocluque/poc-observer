package com.example.factorhub.event

interface EventResult {
    // resultado generico para q o auth hub trate da maneira que quiser
    fun <T> success(eventType: String, result: T)
    // no erro pode devolver direto a exception ou não
    fun fail(eventType: String, error: String)
}