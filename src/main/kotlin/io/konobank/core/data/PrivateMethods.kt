package io.konobank.core.data

import io.konobank.core.Client
import io.konobank.core.model.UserInfo
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import java.net.URL

fun Client.fetchUserInfo(token: String = this.token): UserInfo {
    return URL("$BASE_URL$CLIENT_INFO").openConnection().apply {
        setRequestProperty("X-Token", token)
    }.getInputStream().use {
        Json(JsonConfiguration.Stable).parse(UserInfo.serializer(), String(it.readBytes()))
    }
}