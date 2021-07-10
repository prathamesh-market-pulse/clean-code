package com.techvidhya.router

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
            if (UserRepository.isNotEmpty()) {
                call.respond(UserRepository.all())
            } else {
                call.respondText("No users found", status = HttpStatusCode.NotFound)
            }
        }
        get("{id}") {
            val id = call.parameters["id"]?.toLong() ?: return@get call.respondText(
                text = "Missing or malformed id",
                status = HttpStatusCode.BadRequest
            )
            val user = UserRepository.get(id) ?: return@get call.respondText(
                text = "No user with id $id",
                status = HttpStatusCode.NotFound
            )
            call.respond(user)
        }
        post {
            val user = call.receive<UserModel>()
            UserRepository.add(user)
            call.respondText("User stored correctly", status = HttpStatusCode.Created)
        }
        patch {
            val user = call.receive<UserModel>()
            UserRepository.update(user)
            call.respondText("User updated correctly", status = HttpStatusCode.OK)
        }
        delete("{id}") {
            val id = call.parameters["id"]?.toLong() ?: return@delete call.respondText(
                text = "Missing or malformed id",
                status = HttpStatusCode.BadRequest
            )
            UserRepository.delete(id)
            call.respondText("User deleted correctly", status = HttpStatusCode.OK)
        }
    }
}

fun Application.registerUserRoutes() {
    routing {
        userRouting()
    }
}