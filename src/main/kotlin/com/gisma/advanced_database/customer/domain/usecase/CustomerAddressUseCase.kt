package com.gisma.advanced_database.customer.domain.usecase

import com.gisma.advanced_database.customer.domain.model.CustomerAddress
import com.gisma.advanced_database.customer.domain.port.primary.CustomerAddressPort
import com.gisma.advanced_database.customer.domain.port.secondary.CustomerAddressDataAccessPort
import com.gisma.advanced_database.customer.domain.port.secondary.CustomerDataAccessPort
import java.util.UUID
import org.springframework.stereotype.Component

@Component
class CustomerAddressUseCase(
    private val customerDataAccessPort: CustomerDataAccessPort,
    private val customerAddressDataAccessPort: CustomerAddressDataAccessPort
) : CustomerAddressPort {
    override fun create(customerId: UUID, customerAddress: CustomerAddress): CustomerAddress {
        return customerDataAccessPort.findById(customerId)?.let {
            customerAddressDataAccessPort.save(customerAddress.copy(customer = it))
        } ?: throw IllegalArgumentException("Customer not found")
    }

    override fun update(
        id: UUID,
        customerAddress: CustomerAddress
    ): CustomerAddress {
        return customerAddressDataAccessPort.findById(id)?.let {
            customerAddressDataAccessPort.save(customerAddress)
        } ?: throw IllegalArgumentException("Customer Address not found")
    }

    override fun findById(id: UUID): CustomerAddress {
        TODO("Not yet implemented")
    }

    override fun findByCustomerId(customerId: UUID): List<CustomerAddress> {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: UUID) {
        TODO("Not yet implemented")
    }

}