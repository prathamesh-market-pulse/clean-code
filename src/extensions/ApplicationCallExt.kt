package com.techvidhya.extensions

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*

suspend fun ApplicationCall.respondMalformedRequest() = respondText(
    text = "Missing or malformed id",
    status = HttpStatusCode.BadRequest
)

suspend fun ApplicationCall.respondUserNotFound(id: Long) = respondText(
    text = "No user with id $id",
    status = HttpStatusCode.NotFound
)

suspend fun ApplicationCall.respondUserNotFound() = respondText(
    text = "No users found",
    status = HttpStatusCode.NotFound
)

suspend fun ApplicationCall.respondUserCreated() = respondText(
    text = "User stored correctly",
    status = HttpStatusCode.Created
)

suspend fun ApplicationCall.respondUserUpdated() = respondText(
    text = "User updated correctly",
    status = HttpStatusCode.OK
)

suspend fun ApplicationCall.respondUserDeleted() = respondText(
    text = "User deleted correctly",
    status = HttpStatusCode.OK
)