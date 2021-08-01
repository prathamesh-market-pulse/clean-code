package com.techvidhya.repository

import com.techvidhya.model.User
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

fun initDb() {
    Database.connect("jdbc:postgresql://database:5432/clean_code_db", driver = "org.postgresql.Driver",
        user = "clean_code_user", password = "clean_code_pwd")
}

fun createAndPrePopulateDb() = transaction {
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