package com.techvidhya

import com.techvidhya.model.User
import com.techvidhya.router.registerUserRoutes
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) { json() }

    Database.connect("jdbc:h2:mem:regular;DB_CLOSE_DELAY=-1;", "org.h2.Driver")
    transaction {
        SchemaUtils.create(User)

        User.insert {
            it[userName] = "Pandit"
            it[firstName] = "Abhishek"
            it[lastName] = "Nayak"
            it[age] = 5
        }

        User.insert {
            it[userName] = "Rangari"
            it[firstName] = "Manish"
            it[lastName] = "Malviya"
            it[age] = 50
        }

        User.insert {
            it[userName] = "Kidnapper"
            it[firstName] = "Prashant"
            it[lastName] = "Kumar"
            it[age] = 40
        }

        User.insert {
            it[userName] = "Chicken"
            it[firstName] = "Alok"
            it[lastName] = "Singh"
            it[age] = 30
        }
    }

    registerUserRoutes()
}
