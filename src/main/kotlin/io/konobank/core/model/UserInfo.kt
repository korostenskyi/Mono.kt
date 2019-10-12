package io.konobank.core.model

/**
 * Опис клієнта та його рахунків. Якщо клієнт не надав права читати його персональні данні, повернеться тільки перелік рахунків.
 */
data class UserInfo(
    val name: String,
    val accounts: List<Account>
)