package io.monokt.core.model

import kotlinx.serialization.Serializable

/**
 * Текст помилки для кінцевого користувача, для автоматичного оброблення потрібно аналізувати HTTP код відповіді (200, 404, 429 та інші)
 */
@Serializable
data class Error(
    val errorDescription: String
)