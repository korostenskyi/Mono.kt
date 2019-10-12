package io.konobank.core.model

/**
 * Текст помилки для кінцевого користувача, для автоматичного оброблення потрібно аналізувати HTTP код відповіді (200, 404, 429 та інші)
 */
data class Error(
    val errorDescription: String
)