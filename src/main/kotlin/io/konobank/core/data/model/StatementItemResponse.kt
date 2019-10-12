package io.konobank.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * Перелік транзакцій за вказанний час
 */
data class StatementItemResponse(
    @SerializedName("id") val id: String,
    @SerializedName("time") val time: Int,
    @SerializedName("description") val description: String,
    @SerializedName("mcc") val mcc: Int,
    @SerializedName("hold") val hold: Boolean,
    @SerializedName("amount") val amount: Long,
    @SerializedName("operationAmount") val operationAmount: Long,
    @SerializedName("currencyCode") val currencyCode: Int,
    @SerializedName("commissionRate") val commissionRate: Long,
    @SerializedName("cashbackAmount") val cashbackAmount: Long,
    @SerializedName("balance") val balance: Long
)