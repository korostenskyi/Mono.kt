package io.monokt.core

import io.ktor.client.HttpClient
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.monokt.core.destinations.CLIENT_INFO_URL
import io.monokt.core.destinations.CURRENCY_INFO_URL
import io.monokt.core.destinations.SET_WEBHOOK_URL
import io.monokt.core.destinations.STATEMENT_ITEMS_URL
import io.monokt.core.model.CurrencyInfo
import io.monokt.core.model.StatementItem
import io.monokt.core.model.Status
import io.monokt.core.model.UserInfo
import io.monokt.core.model.WebHookRequest
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class Client() {

    var token: String = ""

    private val client = HttpClient {
        defaultRequest {
            if (token.isNotBlank()) {
                header("X-Token", token)
            }
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    constructor(token: String): this() {
        this.token = token
    }

    suspend fun fetchUserInfo(): UserInfo {
        val infoString = client.get<String>(CLIENT_INFO_URL)
        return Json.decodeFromString(infoString)
    }

    suspend fun setWebHook(urlString: String): Status {
        val json = defaultSerializer()
        val statusString = client.post<String>(SET_WEBHOOK_URL) {
            body = json.write(WebHookRequest(urlString))
        }
        return Json.decodeFromString(statusString)
    }

    suspend fun fetchStatementItems(
            account: String,
            from: String,
            to: String = System.currentTimeMillis().toString()
    ): List<StatementItem> {
        val itemsString = client.get<String>("$STATEMENT_ITEMS_URL$account/$from/$to/")
        return Json.decodeFromString(itemsString)
    }

    // This method does not require API key.
    suspend fun fetchBankCurrency(): List<CurrencyInfo> {
        val infoString = client.get<String>(CURRENCY_INFO_URL)
        return Json.decodeFromString(infoString)
    }
}