package com.gisma.advanced_database.customer.domain.model

import java.util.UUID

data class CustomerAddress(
    val id: UUID? = null,
    val customer: Customer? = null,
    val street: String?,
    val city: String?,
    val state: String?,
    val zipCode: String?,
    val complement: String? = null
) {

}