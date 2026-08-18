package com.gisma.advanced_database.customer.adapter.primary.web.dto.request

import com.gisma.advanced_database.customer.domain.model.CustomerAddress

data class CustomerAddressRequest(
    val street: String,
    val city: String,
    val number: String,
    val state: String,
    val zipCode: String,
    val district: String?,
    val complement: String? = null
) {
    fun toDomain(): CustomerAddress = CustomerAddress(
        street = street,
        city = city,
        state = state,
        number = number,
        district = district,
        zipCode = zipCode,
        complement = complement
    )
}