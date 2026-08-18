package com.gisma.advanced_database.customer.domain.port.primary

import com.gisma.advanced_database.customer.domain.model.Customer
import java.util.UUID

interface CustomerPort {
    fun create(customer: Customer): Customer
    fun update(id: UUID, customerUpdateData: Customer): Customer
    fun findById(id: UUID): Customer?
    fun deleteById(id: UUID)
}