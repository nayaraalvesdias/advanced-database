package com.gisma.advanced_database.customer.adapter.secondary.postgres.repository

import com.gisma.advanced_database.customer.adapter.secondary.postgres.entity.CustomerWalletDBO
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerWalletRepository : JpaRepository<CustomerWalletDBO, UUID> {
    fun save(customer: CustomerWalletDBO): CustomerWalletDBO
    fun findByCustomerId(customerId: UUID): List<CustomerWalletDBO>
}