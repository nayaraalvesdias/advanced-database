package com.gisma.advanced_database.customer.adapter.primary.web.dto.response

import com.gisma.advanced_database.customer.domain.model.Customer
import com.gisma.advanced_database.customer.domain.model.CustomerCard
import java.util.UUID

class CustomerResponse(
    var lastName: String? = null,
    var firstName: String? = null,
    var email: String? = null,
    val phone: String? = null,
    val isActive: Boolean? = null
)

fun Customer.toCustomerResponse(): CustomerResponse = CustomerResponse(
    lastName = this.lastName,
    firstName = this.firstName,
    email = this.email,
    phone = this.phone,
    isActive = this.isActive
)

class CreateCustomerCardResponse(
    var id: UUID
)

fun CustomerCard.toCustomerCreateCardResponse() = CreateCustomerCardResponse(
    id = id!!
)
