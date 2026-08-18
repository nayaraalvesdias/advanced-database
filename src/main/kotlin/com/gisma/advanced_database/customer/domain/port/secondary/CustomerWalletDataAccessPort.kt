package com.gisma.advanced_database.customer.domain.port.secondary

import com.gisma.advanced_database.customer.domain.model.CustomerCard
import java.util.UUID

interface CustomerWalletDataAccessPort {
    fun save(customerCard: CustomerCard): CustomerCard
    fun findByCustomerId(customerId: UUID): List<CustomerCard>
    fun deleteById(id: UUID)
}