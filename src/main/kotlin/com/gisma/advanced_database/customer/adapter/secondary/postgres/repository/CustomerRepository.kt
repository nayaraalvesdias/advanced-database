package com.gisma.advanced_database.customer.adapter.secondary.postgres.repository

import com.gisma.advanced_database.customer.adapter.secondary.postgres.entity.CustomerDBO
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : JpaRepository<CustomerDBO, UUID> {
    fun save(customer: CustomerDBO): CustomerDBO
}