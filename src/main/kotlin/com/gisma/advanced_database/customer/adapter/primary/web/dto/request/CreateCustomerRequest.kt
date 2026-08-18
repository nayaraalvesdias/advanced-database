package com.gisma.advanced_database.customer.adapter.primary.web.dto.request

import com.gisma.advanced_database.customer.domain.model.Customer

data class CreateCustomerRequest(
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String
) {
    fun toDomain(): Customer = Customer(
        firstName = firstName,
        lastName = lastName,
        email = email,
        phone = phone,
    )
}

