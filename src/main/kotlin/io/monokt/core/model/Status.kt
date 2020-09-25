package io.monokt.core.model

import kotlinx.serialization.Serializable

@Serializable
data class Status(
    val status: String
)