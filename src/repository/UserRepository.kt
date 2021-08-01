package com.techvidhya.repository

import com.techvidhya.model.User
import com.techvidhya.model.UserModel
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import kotlin.jvm.Throws

object UserRepository {

    fun add(user: UserModel) = transaction {
        User.insert {
            it[userName] = user.userName
            it[firstName] = user.firstName
            it[lastName] = user.lastName
            it[age] = user.age
        }
    }

    fun update(id: Long, user: UserModel) = transaction {
        User.update({ User.id eq id }) {
            it[userName] = user.userName
            it[firstName] = user.firstName
            it[lastName] = user.lastName
            it[age] = user.age
        }
    }

    fun get(id: Long) = transaction {
        User
            .select { User.id eq id }
            .map { User.toUserModel(it) }
            .firstOrNull()
    }

    fun all() = transaction {
        User
            .selectAll()
            .map { User.toUserModel(it) }
    }

    @Throws(NullPointerException::class)
    fun delete(id: Long) = transaction {
        User.deleteWhere { User.id eq id }
    }
}