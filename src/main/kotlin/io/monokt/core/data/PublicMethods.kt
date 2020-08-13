package io.monokt.core.data

import io.monokt.core.Client
import io.monokt.core.data.destinations.CURRENCY_INFO_URL
import io.monokt.core.model.CurrencyInfo
import io.ktor.client.request.get
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.parseList

@ImplicitReflectionSerializer
suspend fun Client.fetchBankCurrency(): List<CurrencyInfo> {
    return Json(JsonConfiguration.Stable).parseList(client.get(CURRENCY_INFO_URL))
}