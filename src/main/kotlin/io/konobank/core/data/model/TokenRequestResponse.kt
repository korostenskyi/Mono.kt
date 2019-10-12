package io.konobank.core.data.model

import com.google.gson.annotations.SerializedName

/**
 *
 */
data class TokenRequestResponse(
    @SerializedName("tokenRequestId") val tokenRequestId: String,
    @SerializedName("acceptUrl") val acceptUrl: String
)