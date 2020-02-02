package io.konobank.core.data.destinations

// Base
internal const val BASE_URL = "https://api.monobank.ua/"

// Public methods
internal const val CURRENCY_INFO_URL = "$BASE_URL$CURRENCY_INFO_ENDPOINT"

// Private methods
internal const val CLIENT_INFO_URL = "$BASE_URL$CLIENT_INFO_ENDPOINT"
internal const val SET_WEBHOOK_URL = "$BASE_URL$SET_WEBHOOK_ENDPOINT"
internal const val STATEMENT_ITEMS_URL = "$BASE_URL$STATEMENT_ITEMS_ENDPOINT"