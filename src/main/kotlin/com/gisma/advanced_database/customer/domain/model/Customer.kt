package com.gisma.advanced_database.customer.domain.model

import java.util.UUID

data class Customer(
    val id: UUID? = null,
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val phone: String?,
    val isActive: Boolean? = true
) {
    fun update(customerUpdateData: Customer) = this.copy(
        firstName = customerUpdateData.firstName ?: this.firstName,
        lastName = customerUpdateData.lastName ?: this.lastName,
        email = customerUpdateData.email ?: this.email,
        phone = customerUpdateData.phone ?: this.phone
    )

}