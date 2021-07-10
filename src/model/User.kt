package com.techvidhya.model

import kotlinx.serialization.Serializable

@Serializable
data class UserModel(
    val id: Long,
    val userName: String,
    val firstName: String,
    val lastName: String,
    val age: Int
)
