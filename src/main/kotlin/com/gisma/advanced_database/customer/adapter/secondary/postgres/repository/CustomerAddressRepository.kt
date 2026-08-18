package com.gisma.advanced_database.customer.adapter.secondary.postgres.repository

import com.gisma.advanced_database.customer.adapter.secondary.postgres.entity.CustomerAddressDBO
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerAddressRepository : JpaRepository<CustomerAddressDBO, UUID> {
    fun findByCustomerId(customerId: UUID): List<CustomerAddressDBO>
}