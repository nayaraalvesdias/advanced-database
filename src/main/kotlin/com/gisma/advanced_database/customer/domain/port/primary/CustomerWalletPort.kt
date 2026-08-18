package com.gisma.advanced_database.customer.domain.port.primary

import com.gisma.advanced_database.customer.domain.model.CustomerCard
import java.util.UUID

interface CustomerWalletPort {
    fun create(customerId: UUID, customerCard: CustomerCard): CustomerCard
    fun findByCustomerId(customerId: UUID): List<CustomerCard>
    fun deleteById(id: UUID)
}