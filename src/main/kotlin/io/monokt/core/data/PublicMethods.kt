package io.monokt.core.data

import io.ktor.client.request.get
import io.monokt.core.Client
import io.monokt.core.data.destinations.CURRENCY_INFO_URL
import io.monokt.core.model.CurrencyInfo
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

suspend fun Client.fetchBankCurrency(): List<CurrencyInfo> {
    val infoString = client.get<String>(CURRENCY_INFO_URL)
    return Json.decodeFromString(infoString)
}