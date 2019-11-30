package io.konobank.core

class Client() {

    lateinit var token: String

    constructor(token: String): this() {
        this.token = token
    }
}