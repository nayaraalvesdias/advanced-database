package com.gisma.advanced_database.customer.domain.model

import java.util.UUID

data class CustomerCard(
    val id: UUID? = null,
    val customer: Customer? = null,
    val cardNumber: String,
    val expiration: String,
    val type: CardType,
    val cvv: String,
    val main: Boolean? = null
) {
}