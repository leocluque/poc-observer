package com.example.factorhub.event

object EventManager {

    private var listeners: MutableMap<String, MutableList<EventListener>> = HashMap()

    // função de registro de todas as operações que o Auth hub/outro modulo pode ter.
    fun registerOperations(operations: List<String>) {
        for (operation in operations) {
            listeners[operation] = ArrayList()
        }
    }

    // Modulos se inscrevem nos eventos para observar o evento de sua responsabilidade
    fun subscribe(eventType: String, listener: EventListener) {
        val users: MutableList<EventListener> = listeners[eventType]!!
        users.add(listener)
    }

    // para de observar
    fun unsubscribe(eventType: String, listener: EventListener) {
        val users: MutableList<EventListener> = listeners[eventType]!!
        users.remove(listener)
    }

    // Auth Hub envia os eventos e aqui dispara a notificação para quem conhece.
    fun notify(eventType: String, res: Any?, result: EventResult) {
        val users: List<EventListener> = listeners[eventType]!!
        for (listener in users) {
            listener.event(eventType, res, result)
        }
    }
}
