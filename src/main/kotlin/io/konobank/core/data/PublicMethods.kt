package io.konobank.core.data

import io.konobank.core.Client
import io.konobank.core.model.CurrencyInfo
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.parseList
import java.net.URL

@ImplicitReflectionSerializer
fun Client.fetchBankCurrency(): List<CurrencyInfo> =
    Json(JsonConfiguration.Stable).parseList(URL("$BASE_URL$CURRENCY_INFO").readText())