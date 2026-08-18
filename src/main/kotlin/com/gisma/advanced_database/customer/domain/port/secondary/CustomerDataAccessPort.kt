package com.gisma.advanced_database.customer.domain.port.secondary

import com.gisma.advanced_database.customer.domain.model.Customer
import java.util.UUID

interface CustomerDataAccessPort {
    fun save(customer: Customer): Customer
    fun findById(id: UUID): Customer?
}