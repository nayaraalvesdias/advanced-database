package com.gisma.advanced_database.store.adapter.primary.web.dto.request

import com.gisma.advanced_database.store.domain.model.Product
import java.math.BigDecimal

data class CreateProductRequest(
    val name: String,
    val price: BigDecimal,
    val quantity: Int,
    val category: String,
    val brand: String,
    val description: String
) {
    fun toDomain(): Product = Product(
        name = name,
        quantity = quantity,
        price = price,
        category = category,
        brand = brand,
        description = description,
        isAvailable = true
    )
}

data class ProductRequest(
    val name: String? = null,
    val price: BigDecimal? = null,
    val quantity: Int? = null,
    val category: String? = null,
    val brand: String? = null,
    val description: String? = null,
    val isAvailable: Boolean? = null
) {
    fun toDomain() = Product(
        name = name,
        quantity = quantity,
        price = price,
        category = category,
        brand = brand,
        description = description,
        isAvailable = isAvailable
    )
}

