package com.gisma.advanced_database.customer.adapter.secondary.postgres.entity

import com.gisma.advanced_database.customer.domain.model.Customer
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "customers")
data class CustomerDBO(
    @Id
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val isActive: Boolean,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
) {

    fun toDomain(): Customer {
        return Customer(
            id = this.id,
            firstName = this.firstName,
            lastName = this.lastName,
            email = this.email,
            phone = this.phone,
            isActive = this.isActive
        )
    }
}

fun Customer.toDBO(): CustomerDBO {
    return CustomerDBO(
        id = this.id ?: UUID.randomUUID(),
        firstName = this.firstName!!,
        lastName = this.lastName!!,
        email = this.email!!,
        phone = this.phone!!,
        isActive = this.isActive ?: true,
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )
}