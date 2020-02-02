package io.konobank.core.data

import io.konobank.core.Client
import io.konobank.core.model.StatementItem
import io.konobank.core.model.Status
import io.konobank.core.model.UserInfo
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.parseList

suspend fun Client.fetchUserInfo(token: String = this.token): UserInfo {
    return Json(JsonConfiguration.Stable).parse(
        UserInfo.serializer(),
        client.get("$BASE_URL$CLIENT_INFO") {
            header("X-Token", token)
        }
    )
}

// TODO: Investigate this method
suspend fun Client.setWebHook(token: String = this.token): Status {
    return Json(JsonConfiguration.Stable).parse(
        Status.serializer(),
        client.post("$BASE_URL$SET_WEBHOOK") {
            header("X-Token", token)
        }
    )
}

@UnstableDefault
@ImplicitReflectionSerializer
suspend fun Client.fetchStatementItems(
    token: String = this.token,
    account: String,
    from: String,
    to: String = System.currentTimeMillis().toString()
): List<StatementItem> {
    return Json(JsonConfiguration(strictMode = false)).parseList(
        client.get("$BASE_URL$STATEMENT_ITEMS/$account/$from/$to") {
            header("X-Token", token)
        }
    )
}