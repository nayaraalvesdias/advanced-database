package com.gisma.advanced_database.customer.adapter.secondary.postgres.adapter

import com.gisma.advanced_database.customer.adapter.secondary.postgres.entity.toDBO
import com.gisma.advanced_database.customer.adapter.secondary.postgres.repository.CustomerWalletRepository
import com.gisma.advanced_database.customer.domain.model.CustomerCard
import com.gisma.advanced_database.customer.domain.port.secondary.CustomerWalletDataAccessPort
import java.util.UUID
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class CustomerWalletAdapterAccess(
    private val customerWalletRepository: CustomerWalletRepository
) : CustomerWalletDataAccessPort {

    override fun save(customerCard: CustomerCard): CustomerCard {
        return customerWalletRepository.save(customerCard.toDBO()).toDomain()
    }

    override fun deleteById(id: UUID) {
        customerWalletRepository.deleteById(id)
    }

    override fun findById(id: UUID): CustomerCard? {
        return customerWalletRepository.findByIdOrNull(id)?.toDomain()
    }

    override fun findByCustomerId(customerId: UUID): List<CustomerCard> {
        return customerWalletRepository.findByCustomerId(customerId).map { it.toDomain() }
    }
}