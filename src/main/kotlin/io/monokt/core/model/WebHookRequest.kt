package io.monokt.core.model

import kotlinx.serialization.Serializable

@Serializable
data class WebHookRequest(
    val webHookUrl: String
)
