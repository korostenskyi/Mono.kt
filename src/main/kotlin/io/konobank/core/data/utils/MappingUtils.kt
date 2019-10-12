package io.konobank.core.data.utils

import io.konobank.core.data.model.AccountResponse
import io.konobank.core.data.model.CurrencyInfoResponse
import io.konobank.core.data.model.ErrorResponse
import io.konobank.core.data.model.StatementItemResponse
import io.konobank.core.model.Account
import io.konobank.core.model.CurrencyInfo
import io.konobank.core.model.Error
import io.konobank.core.model.StatementItem

fun AccountResponse.toAccount() = Account(
    id = id,
    balance = balance,
    creditLimit = creditLimit,
    currencyCode = currencyCode,
    cashbackType = cashbackType
)

fun ErrorResponse.toError() = Error(
    errorDescription = errorDescription
)

fun StatementItemResponse.toStatementItem() = StatementItem(
    id = id,
    time = time,
    description = description,
    mcc = mcc,
    hold = hold,
    amount = amount,
    operationAmount = operationAmount,
    currencyCode = currencyCode,
    commissionRate = commissionRate,
    cashbackAmount = cashbackAmount,
    balance = balance
)

fun CurrencyInfoResponse.toCurrencyInfo() = CurrencyInfo(
    currencyCodeA = currencyCodeA,
    currencyCodeB = currencyCodeB,
    date = date,
    rateSell = rateSell,
    rateBuy = rateBuy,
    rateCross = rateCross
)