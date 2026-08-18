package com.gisma.advanced_database.store.domain.model

import java.util.UUID

data class Product(
    val id: UUID? = null,

    ) {
    fun update(productUpdateData: Product) = this.copy(

    )

}