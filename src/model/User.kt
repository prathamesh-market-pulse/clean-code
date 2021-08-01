package com.techvidhya.model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

object User: Table() {
    val id: Column<Long> = long("id").autoIncrement()
    val userName: Column<String> = varchar("name", 50).uniqueIndex()
    val firstName: Column<String> = varchar("first_name", 50)
    val lastName: Column<String> = varchar("last_name", 50)
    val age: Column<Int> = integer("age")

    override val primaryKey = PrimaryKey(id, name = "primary_key")

    fun toUserModel(row: ResultRow): UserModel = UserModel(
        id = row[id],
        userName = row[userName],
        firstName = row[firstName],
        lastName = row[lastName],
        age = row[age]
    )
}

@Serializable
data class UserModel(
    val id: Long? = null,
    val userName: String,
    val firstName: String,
    val lastName: String,
    val age: Int
)
