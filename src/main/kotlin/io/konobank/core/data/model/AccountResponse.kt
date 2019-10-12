package io.konobank.core.data.model

import com.google.gson.annotations.SerializedName
import io.konobank.core.model.CashbackType

data class AccountResponse(
    @SerializedName("id") val id: String,
    @SerializedName("balance") val balance: Long,
    @SerializedName("creditLimit") val creditLimit: Long,
    @SerializedName("currencyCode") val currencyCode: Int,
    @SerializedName("cashbackType") val cashbackType: CashbackType
)