package com.gisma.advanced_database.store.adapter.primary.web.dto.response

import com.gisma.advanced_database.store.domain.model.Product
import java.math.BigDecimal
import java.util.UUID

data class ProductResponse(
    val id: UUID,
    val name: String? = null,
    val price: BigDecimal? = null,
    val quantity: Int? = null,
    val category: String? = null,
    val brand: String? = null,
    val description: String? = null,
    val rating: BigDecimal? = null,
    val isAvailable: Boolean? = null
)

fun Product.toProductResponse() = ProductResponse(
    id = id!!,
    name = name,
    price = price,
    quantity = quantity,
    category = category,
    brand = brand,
    description = description,
    rating = rating,
    isAvailable = isAvailable
)
