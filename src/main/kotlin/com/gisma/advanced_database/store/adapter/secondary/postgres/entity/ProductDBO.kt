package com.gisma.advanced_database.store.adapter.secondary.postgres.entity

import com.gisma.advanced_database.store.domain.model.Product
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "products")
data class ProductDBO(
    @Id
    val id: UUID,
    @OneToOne
    val store: StoreDBO,
    val name: String,
    val isAvailable: Boolean,
    val price: BigDecimal,
    val quantity: Int,
    val category: String,
    val brand: String,
    val description: String,
    val rating: BigDecimal? = null,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
) {

    fun toDomain(): Product = Product(
        id = this.id,
        name = name,
        store = this.store.toDomain(),
        isAvailable = isAvailable,
        price = price,
        quantity = quantity,
        category = category,
        brand = brand,
        description = description,
        rating = rating
    )
}

fun Product.toDBO(): ProductDBO {
    return ProductDBO(
        id = this.id ?: UUID.randomUUID(),
        name = name!!,
        store = this.store!!.toDBO(),
        isAvailable = this.isAvailable!!,
        price = price!!,
        quantity = quantity!!,
        category = category!!,
        brand = brand!!,
        description = description!!,
        rating = rating,
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )
}