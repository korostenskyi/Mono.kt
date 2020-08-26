package io.monokt.core.data

import io.ktor.client.request.get
import io.ktor.client.request.post
import io.monokt.core.Client
import io.monokt.core.data.destinations.CLIENT_INFO_URL
import io.monokt.core.data.destinations.SET_WEBHOOK_URL
import io.monokt.core.data.destinations.STATEMENT_ITEMS_URL
import io.monokt.core.model.StatementItem
import io.monokt.core.model.Status
import io.monokt.core.model.UserInfo
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

suspend fun Client.fetchUserInfo(): UserInfo {
    val infoString = client.get<String>(CLIENT_INFO_URL)
    return Json.decodeFromString(infoString)
}

// TODO: Investigate this method
suspend fun Client.setWebHook(): Status {
    val statusString = client.post<String>(SET_WEBHOOK_URL)
    return Json.decodeFromString(statusString)
}

suspend fun Client.fetchStatementItems(
    account: String,
    from: String,
    to: String = System.currentTimeMillis().toString()
): List<StatementItem> {
    val itemsString = client.get<String>("$STATEMENT_ITEMS_URL$account/$from/$to/")
    return Json.decodeFromString(itemsString)
}