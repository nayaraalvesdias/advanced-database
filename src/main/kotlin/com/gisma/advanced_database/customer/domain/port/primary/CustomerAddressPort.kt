package com.gisma.advanced_database.customer.domain.port.primary

import com.gisma.advanced_database.customer.domain.model.CustomerAddress
import java.util.UUID

interface CustomerAddressPort {
    fun create(customerId: UUID, customerAddress: CustomerAddress): CustomerAddress
    fun update(id: UUID, customerAddress: CustomerAddress): CustomerAddress
    fun findById(id: UUID): CustomerAddress
    fun findByCustomerId(customerId: UUID): List<CustomerAddress>?
    fun deleteById(id: UUID)
}