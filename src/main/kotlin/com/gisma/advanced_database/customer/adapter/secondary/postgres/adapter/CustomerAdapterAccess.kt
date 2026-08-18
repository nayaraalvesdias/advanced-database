package com.gisma.advanced_database.customer.adapter.secondary.postgres.adapter

import com.gisma.advanced_database.customer.adapter.secondary.postgres.entity.toDBO
import com.gisma.advanced_database.customer.adapter.secondary.postgres.repository.CustomerRepository
import com.gisma.advanced_database.customer.domain.model.Customer
import com.gisma.advanced_database.customer.domain.port.secondary.CustomerDataAccessPort
import java.util.UUID
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class CustomerAdapterAccess(
    private val customerRepository: CustomerRepository
) : CustomerDataAccessPort {
    override fun save(customer: Customer): Customer {
        return customerRepository.save(customer.toDBO()).toDomain()
    }

    override fun findById(id: UUID): Customer? {
        return customerRepository.findByIdOrNull(id)?.toDomain()
    }

    override fun deleteById(id: UUID) {
        return customerRepository.deleteById(id)
    }
}