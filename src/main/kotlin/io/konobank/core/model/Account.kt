package io.konobank.core.model

import kotlinx.serialization.Serializable

@Serializable
data class Account(
    val id: String,
    val balance: Long,
    val creditLimit: Long,
    val currencyCode: Int,
    val cashbackType: CashbackType
)