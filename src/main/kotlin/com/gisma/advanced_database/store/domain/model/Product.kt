package com.gisma.advanced_database.store.domain.model

import java.math.BigDecimal
import java.util.UUID

data class Product(
    val id: UUID? = null,
    val store: Store? = null,
    val name: String? = null,
    val price: BigDecimal? = null,
    val quantity: Int? = null,
    val category: String? = null,
    val brand: String? = null,
    val description: String? = null,
    val rating: BigDecimal? = null,
    val isAvailable: Boolean? = null
) {
    fun update(productUpdateData: Product) = this.copy(
        name = productUpdateData.name,
        price = productUpdateData.price,
        quantity = productUpdateData.quantity,
        category = productUpdateData.category,
        brand = productUpdateData.brand,
        description = productUpdateData.description,
        rating = productUpdateData.rating,
        isAvailable = productUpdateData.isAvailable
    )
}
