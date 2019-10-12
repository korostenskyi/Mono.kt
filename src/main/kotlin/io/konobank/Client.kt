package io.konobank

class Client() {

    private lateinit var token: String

    constructor(token: String): this() {
        this.token = token
    }
}