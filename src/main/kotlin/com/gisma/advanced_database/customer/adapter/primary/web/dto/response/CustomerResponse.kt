package com.gisma.advanced_database.customer.adapter.primary.web.dto.response

import com.gisma.advanced_database.customer.domain.model.CustomerCard
import java.util.UUID

class CustomerWalletCardResponse(
    val id: UUID,
    var cardNumber: String
)

fun CustomerCard.toCustomerCardResponse() = CustomerWalletCardResponse(
    id = id!!,
    cardNumber = cardNumber
)

fun List<CustomerCard>.toCustomerResponse() = this.map {
    it.toCustomerCardResponse()
}