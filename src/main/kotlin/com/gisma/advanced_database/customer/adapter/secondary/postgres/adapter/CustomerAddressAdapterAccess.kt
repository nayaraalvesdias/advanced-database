package com.gisma.advanced_database.customer.adapter.secondary.postgres.adapter

import com.gisma.advanced_database.customer.adapter.secondary.postgres.entity.toDBO
import com.gisma.advanced_database.customer.adapter.secondary.postgres.repository.CustomerAddressRepository
import com.gisma.advanced_database.customer.domain.model.CustomerAddress
import com.gisma.advanced_database.customer.domain.port.secondary.CustomerAddressDataAccessPort
import java.util.UUID
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class CustomerAddressAdapterAccess(
    private val customerAddressRepository: CustomerAddressRepository
) : CustomerAddressDataAccessPort {

    override fun save(customerAddress: CustomerAddress): CustomerAddress {
        return customerAddressRepository.save(customerAddress.toDBO()).toDomain()
    }

    override fun findByCustomerId(customerId: UUID): List<CustomerAddress> {
        return customerAddressRepository.findByCustomerId(customerId).map { it.toDomain() }
    }

    override fun findById(id: UUID): CustomerAddress? {
        return customerAddressRepository.findByIdOrNull(id)?.toDomain()
    }

    override fun deleteById(id: UUID) {
        return customerAddressRepository.deleteById(id)
    }
}