package io.konobank.core.model

import kotlinx.serialization.Serializable

/**
 *
 */

@Serializable
data class TokenRequest(
    val tokenRequestId: String,
    val acceptUrl: String
)