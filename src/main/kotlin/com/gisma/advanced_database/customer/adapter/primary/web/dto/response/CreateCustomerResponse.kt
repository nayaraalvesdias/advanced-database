package com.gisma.advanced_database.customer.adapter.primary.web.dto.response

import com.gisma.advanced_database.customer.domain.model.Customer
import java.util.UUID

data class CreateCustomerResponse(
    val id: UUID
)

fun Customer.toCreateCustomerResponse(): CreateCustomerResponse = CreateCustomerResponse(
    id = id!!
)