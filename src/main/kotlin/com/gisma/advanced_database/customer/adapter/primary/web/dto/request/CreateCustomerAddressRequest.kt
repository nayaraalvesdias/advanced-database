package com.gisma.advanced_database.customer.adapter.primary.web.dto.request

import com.gisma.advanced_database.customer.domain.model.CustomerAddress

data class CustomerAddressRequest(
    val street: String,
    val city: String,
    val state: String,
    val zipCode: String
) {
    fun toDomain(): CustomerAddress = CustomerAddress(
        street = street,
        city = city,
        state = state,
        zipCode = zipCode
    )
}