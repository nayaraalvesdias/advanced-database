package com.gisma.advanced_database.customer.adapter.secondary.postgres.entity

import com.gisma.advanced_database.customer.domain.model.CustomerAddress
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "customer_addresses")
data class CustomerAddressDBO(
    @Id
    val id: UUID,
    @OneToOne
    val customer: CustomerDBO,
    val street: String,
    val city: String,
    val state: String,
    val zipCode: String,
    val complement: String?,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
) {

    fun toDomain(): CustomerAddress {
        return CustomerAddress(
            id = this.id,
            customer = this.customer.toDomain(),
            street = this.street,
            city = this.city,
            state = this.state,
            zipCode = this.zipCode
        )
    }

}

fun CustomerAddress.toDBO(): CustomerAddressDBO {
    return CustomerAddressDBO(
        id = this.id ?: UUID.randomUUID(),
        customer = this.customer!!.toDBO(),
        street = this.street!!,
        city = this.city!!,
        state = this.state!!,
        zipCode = this.zipCode!!,
        complement = this.complement,
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )
}