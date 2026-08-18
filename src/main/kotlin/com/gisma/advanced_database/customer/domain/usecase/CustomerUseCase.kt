package com.gisma.advanced_database.customer.domain.usecase

import com.gisma.advanced_database.customer.domain.model.Customer
import com.gisma.advanced_database.customer.domain.port.primary.CustomerPort
import com.gisma.advanced_database.customer.domain.port.secondary.CustomerDataAccessPort
import java.util.UUID
import org.springframework.stereotype.Component

@Component
class CustomerUseCase(
    private val customerDataAccessPort: CustomerDataAccessPort
) : CustomerPort {
    override fun create(customer: Customer): Customer {
        return customerDataAccessPort.save(customer)
    }

    override fun update(id: UUID, customerUpdateData: Customer): Customer {
        return customerDataAccessPort.findById(id)?.let {
            customerDataAccessPort.save(customer = it.update(customerUpdateData))
        } ?: throw NullPointerException("Customer with id $id not found")
    }

    override fun findById(id: UUID): Customer {
        return customerDataAccessPort.findById(id)
            ?: throw NullPointerException("Customer with id $id not found")
    }

    override fun deleteById(id: UUID) {
        customerDataAccessPort.findById(id)?.let {
            customerDataAccessPort.save(customer = it.copy(isActive = false))
        } ?: throw NullPointerException("Customer with id $id not found")
    }
}