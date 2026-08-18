package com.gisma.advanced_database.customer.adapter.primary.web.dto.request

import com.gisma.advanced_database.customer.domain.model.CustomerAddress

data class UpdateCustomerAddressRequest(
    val street: String?,
    val city: String?,
    val state: String?,
    val number: String?,
    val zipCode: String?,
    val district: String?,
    val complement: String? = null
) {
    fun toDomain(): CustomerAddress = CustomerAddress(
        street = street,
        city = city,
        state = state,
        zipCode = zipCode,
        district = district,
        number = number,
        complement = complement
    )
}