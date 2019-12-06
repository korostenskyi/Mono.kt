package io.konobank.core.model

import kotlinx.serialization.Serializable

@Serializable
data class Status(
    val status: String
)