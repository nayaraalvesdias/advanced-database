package com.gisma.advanced_database.customer.domain.model

import java.util.UUID

data class CustomerAddress(
    val id: UUID? = null,
    val customer: Customer? = null,
    val street: String?,
    val city: String?,
    val state: String?,
    val district: String?,
    val number: String?,
    val zipCode: String?,
    val complement: String? = null
) {
    fun update(customerAddress: CustomerAddress): CustomerAddress = copy(
        street = customerAddress.street ?: street,
        city = customerAddress.city ?: city,
        state = customerAddress.state ?: state,
        district = customerAddress.district ?: district,
        number = customerAddress.number ?: number,
        zipCode = customerAddress.zipCode ?: zipCode,
        complement = customerAddress.complement
    )
}