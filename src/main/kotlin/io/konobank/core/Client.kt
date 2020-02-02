package io.konobank.core

import io.ktor.client.HttpClient

class Client() {

    internal val client = HttpClient()

    var token: String = ""

    constructor(token: String): this() {
        this.token = token
    }
}