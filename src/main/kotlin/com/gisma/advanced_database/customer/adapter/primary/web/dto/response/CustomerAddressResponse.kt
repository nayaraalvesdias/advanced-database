package com.gisma.advanced_database.customer.adapter.primary.web.dto.response

import com.gisma.advanced_database.customer.domain.model.CustomerAddress
import java.util.UUID

class CustomerAddressResponse(
    val id: UUID,
    val street: String,
    val city: String,
    val state: String,
    val zipCode: String
)

fun CustomerAddress.toCustomerAddressResponse() = CustomerAddressResponse(
    id = id!!,
    street = street!!,
    city = city!!,
    state = state!!,
    zipCode = zipCode!!
)

fun List<CustomerAddress>.toCustomerAddressResponse() = map { it.toCustomerAddressResponse() }