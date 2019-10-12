package io.konobank.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * Текст помилки для кінцевого користувача, для автоматичного оброблення потрібно аналізувати HTTP код відповіді (200, 404, 429 та інші)
 */
data class ErrorResponse(
    @SerializedName("errorDescription") val errorDescription: String
)