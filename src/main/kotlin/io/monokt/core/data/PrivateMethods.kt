package io.monokt.core.data

import io.monokt.core.Client
import io.monokt.core.data.destinations.CLIENT_INFO_URL
import io.monokt.core.data.destinations.SET_WEBHOOK_URL
import io.monokt.core.data.destinations.STATEMENT_ITEMS_URL
import io.monokt.core.model.StatementItem
import io.monokt.core.model.Status
import io.monokt.core.model.UserInfo
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