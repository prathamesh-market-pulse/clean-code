package com.techvidhya

import com.techvidhya.repository.initDb
import com.techvidhya.router.registerUserRoutes
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) { json() }

    initDb()

    registerUserRoutes()
}
