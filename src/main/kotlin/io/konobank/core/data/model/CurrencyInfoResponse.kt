package io.konobank.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * Перелік курсів. Кожна валютна пара може мати одне і більше полів з rateSell, rateBuy, rateCross.
 */
data class CurrencyInfoResponse(
    @SerializedName("currencyCodeA") val currencyCodeA: Int,
    @SerializedName("currencyCodeB") val currencyCodeB: Int,
    @SerializedName("date") val date: Long,
    @SerializedName("rateSell") val rateSell: Double? = null,
    @SerializedName("rateBuy") val rateBuy: Double? = null,
    @SerializedName("rateCross") val rateCross: Double? = null
)