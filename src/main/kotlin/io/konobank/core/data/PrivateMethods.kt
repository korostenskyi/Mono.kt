package io.konobank.core.data

import io.konobank.core.Client
import io.konobank.core.data.destinations.CLIENT_INFO_URL
import io.konobank.core.data.destinations.SET_WEBHOOK_URL
import io.konobank.core.data.destinations.STATEMENT_ITEMS_URL
import io.konobank.core.model.StatementItem
import io.konobank.core.model.Status
import io.konobank.core.model.UserInfo
import io.ktor.client.request.get
import io.ktor.client.request.post
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.parseList

suspend fun Client.fetchUserInfo(): UserInfo {
    return Json(JsonConfiguration.Stable).parse(
        UserInfo.serializer(),
        client.get(CLIENT_INFO_URL)
    )
}

// TODO: Investigate this method
suspend fun Client.setWebHook(): Status {
    return Json(JsonConfiguration.Stable).parse(
        Status.serializer(),
        client.post(SET_WEBHOOK_URL)
    )
}

@ImplicitReflectionSerializer
suspend fun Client.fetchStatementItems(
    account: String,
    from: String,
    to: String = System.currentTimeMillis().toString()
): List<StatementItem> {
    return Json(JsonConfiguration(ignoreUnknownKeys = true)).parseList(
        client.get("$STATEMENT_ITEMS_URL$account/$from/$to/")
    )
}