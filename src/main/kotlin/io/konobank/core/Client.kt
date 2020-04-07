package io.konobank.core

import io.ktor.client.HttpClient
import io.ktor.client.features.defaultRequest
import io.ktor.client.request.header

class Client() {

    var token: String = ""

    internal val client = HttpClient {
        defaultRequest {
            if (token.isNotBlank()) {
                header("X-Token", token)
            }
        }
    }

    constructor(token: String): this() {
        this.token = token
    }
}