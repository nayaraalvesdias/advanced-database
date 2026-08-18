package com.gisma.advanced_database.customer.domain.port.secondary

import com.gisma.advanced_database.customer.domain.model.CustomerAddress
import java.util.UUID

interface CustomerAddressDataAccessPort {
    fun save(customerAddress: CustomerAddress): CustomerAddress
    fun findById(id: UUID): CustomerAddress?
    fun findByCustomerId(customerId: UUID): List<CustomerAddress>
    fun deleteById(id: UUID)
}