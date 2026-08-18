package com.gisma.advanced_database.customer.domain.usecase

import com.gisma.advanced_database.customer.domain.model.CustomerCard
import com.gisma.advanced_database.customer.domain.port.primary.CustomerWalletPort
import com.gisma.advanced_database.customer.domain.port.secondary.CustomerDataAccessPort
import com.gisma.advanced_database.customer.domain.port.secondary.CustomerWalletDataAccessPort
import java.util.UUID
import org.springframework.stereotype.Component

@Component
class CustomerWalletUseCase(
    private val customerDataAccessPort: CustomerDataAccessPort,
    private val customerWalletDataAccessPort: CustomerWalletDataAccessPort
) : CustomerWalletPort {
    override fun create(customerId: UUID, customerCard: CustomerCard): CustomerCard {
        return customerDataAccessPort.findById(customerId)?.let {
            customerWalletDataAccessPort.save(customerCard.copy(customer = it))
        } ?: throw IllegalArgumentException("Customer not found")
    }

    override fun findByCustomerId(customerId: UUID): List<CustomerCard> {
        return customerWalletDataAccessPort.findByCustomerId(customerId)
    }

    override fun deleteById(id: UUID) {
        customerWalletDataAccessPort.deleteById(id)
    }
}