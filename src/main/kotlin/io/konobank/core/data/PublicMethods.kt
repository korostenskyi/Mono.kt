package io.konobank.core.data

import io.konobank.core.Client
import io.konobank.core.model.CurrencyInfo
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.parseList

@ImplicitReflectionSerializer
suspend fun Client.fetchBankCurrency(): List<CurrencyInfo> {
    return Json(JsonConfiguration.Stable).parseList(HttpClient().get("$BASE_URL$CURRENCY_INFO"))
}