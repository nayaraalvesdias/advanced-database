package com.gisma.advanced_database.customer.adapter.primary.web.dto.request

import com.gisma.advanced_database.customer.domain.model.CardType
import com.gisma.advanced_database.customer.domain.model.CustomerCard

data class CreateCardRequest(
    val cardNumber: String,
    val expiration: String,
    val cvv: String,
    val type: CardType
) {

    fun toDomain() = CustomerCard(
        cardNumber = cardNumber,
        expiration = expiration,
        type = type,
        cvv = cvv
    )
}

