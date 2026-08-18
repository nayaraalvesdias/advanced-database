package com.gisma.advanced_database.customer.adapter.primary.web.dto.response

import com.gisma.advanced_database.customer.domain.model.CustomerAddress
import java.util.UUID

data class CreateCustomerAddressResponse(
    val id: UUID
)

fun CustomerAddress.toCreateCustomerAddressResponse() = CreateCustomerAddressResponse(
    id = id!!
)