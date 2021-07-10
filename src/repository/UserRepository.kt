package com.techvidhya.repository

import com.techvidhya.model.UserModel
import kotlin.jvm.Throws

object UserRepository {

    private val userList = mutableListOf<UserModel>()

    fun isNotEmpty() = userList.isNotEmpty()

    fun add(user: UserModel) = userList.add(user)

    fun update(user: UserModel) {
        delete(user.id)
        add(user)
    }

    fun get(id: Long) = userList.find { it.id == id }

    fun all() = userList

    @Throws(NullPointerException::class)
    fun delete(id: Long) {
        userList.removeIf { it.id == id }
    }
}