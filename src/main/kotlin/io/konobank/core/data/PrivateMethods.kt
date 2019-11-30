package io.konobank.core.data

import io.konobank.core.Client
import io.konobank.core.model.UserInfo
import io.konobank.core.model.Status
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import java.net.HttpURLConnection
import java.net.URL

fun Client.fetchUserInfo(token: String = this.token): UserInfo {
    return with(URL("$BASE_URL$CLIENT_INFO").openConnection() as HttpURLConnection) {
        requestMethod = "GET"
        setRequestProperty("X-Token", token)
        inputStream.use {
            Json(JsonConfiguration.Stable).parse(UserInfo.serializer(), String(it.readBytes()))
        }
    }
}

fun Client.setWebHook(token: String = this.token): Status {
    return with(URL("$BASE_URL$SET_WEBHOOK").openConnection() as HttpURLConnection) {
        requestMethod = "POST"
        setRequestProperty("X-Token", token)
        inputStream.use {
            Json(JsonConfiguration.Stable).parse(Status.serializer(), String(it.readBytes()))
        }
    }
}