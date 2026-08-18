package com.gisma.advanced_database.customer.adapter.secondary.postgres.entity

import com.gisma.advanced_database.customer.domain.model.CardType
import com.gisma.advanced_database.customer.domain.model.CustomerCard
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "customer_wallet")
data class CustomerWalletDBO(
    @Id
    val id: UUID,
    @OneToOne
    val customer: CustomerDBO,
    val cardNumber: String,
    @Enumerated(EnumType.STRING)
    val type: CardType,
    val expiration: String,
    val cvv: String,
    val main: Boolean?,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
) {

    fun toDomain(): CustomerCard {
        return CustomerCard(
            id = this.id,
            customer = this.customer.toDomain(),
            cardNumber = this.cardNumber,
            expiration = this.expiration,
            type = type,
            cvv = this.cvv
        )
    }
}

fun CustomerCard.toDBO(): CustomerWalletDBO {
    return CustomerWalletDBO(
        id = this.id ?: UUID.randomUUID(),
        customer = this.customer!!.toDBO(),
        cardNumber = this.cardNumber,
        expiration = this.expiration,
        cvv = this.cvv,
        type = type,
        main = main,
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )
}