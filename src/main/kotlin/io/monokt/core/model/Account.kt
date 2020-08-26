package io.monokt.core.model

import kotlinx.serialization.Serializable

@Serializable
data class Account(
    val id: String,
    val balance: Long,
    val creditLimit: Long,
    val currencyCode: Int,
    val cashbackType: String,
    val maskedPan: List<String>,
    val type: String
)