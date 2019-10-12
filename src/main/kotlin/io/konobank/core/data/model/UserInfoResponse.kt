package io.konobank.core.data.model

import com.google.gson.annotations.SerializedName
import io.konobank.core.model.Account

data class UserInfoResponse(
    @SerializedName("name") val name: String,
    @SerializedName("accounts") val accounts: List<Account>
)