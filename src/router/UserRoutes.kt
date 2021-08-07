package com.techvidhya.router

import com.techvidhya.extensions.*
import com.techvidhya.model.UserModel
import com.techvidhya.repository.UserRepository
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.userRouting() {
    route("/user") {
        get {
            val users = UserRepository.all()
            if (users.isNotEmpty()) {
                call.respond(users)
            } else {
                call.respondUserNotFound()
            }
        }
        get("{id}") {
            val id = call.parameters["id"]?.toLong() ?: return@get call.respondMalformedRequest()
            val user = UserRepository.get(id) ?: return@get call.respondUserNotFound(id)
            call.respond(user)
        }
        post {
            val user = call.receive<UserModel>()
            UserRepository.add(user)
            call.respondUserCreated()
        }
        patch("{id}") {
            val id = call.parameters["id"]?.toLong() ?: return@patch call.respondMalformedRequest()
            val user = call.receive<UserModel>()
            UserRepository.update(id, user)
            call.respondUserUpdated()
        }
        delete("{id}") {
            val id = call.parameters["id"]?.toLong() ?: return@delete call.respondMalformedRequest()
            UserRepository.delete(id)
            call.respondUserDeleted()
        }
    }
}

fun Application.registerUserRoutes() {
    routing {
        userRouting()
    }
}