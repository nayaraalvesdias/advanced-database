package com.gisma.advanced_database.customer.adapter.primary.web.dto.response

import com.gisma.advanced_database.customer.domain.model.Customer
import java.util.UUID

data class CustomerResponse(
    val id: UUID,
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val phone: String?,
    val isActive: Boolean
)

fun Customer.toCustomerResponse() = CustomerResponse(
    id = id!!,
    firstName = firstName,
    lastName = lastName,
    email = email,
    phone = phone,
    isActive = isActive!!
)
