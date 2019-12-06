package io.konobank.core.model

import kotlinx.serialization.Serializable

/**
 * Опис клієнта та його рахунків. Якщо клієнт не надав права читати його персональні данні, повернеться тільки перелік рахунків.
 */

@Serializable
data class UserInfo(
    val name: String,
    val accounts: List<Account>
)