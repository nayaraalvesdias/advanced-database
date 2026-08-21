package com.gisma.advanced_database.store.domain.port.primary

import com.gisma.advanced_database.store.domain.model.Product
import java.util.UUID

interface ProductPort {
    fun create(storeId: UUID, product: Product): Product
    fun update(id: UUID, productUpdateData: Product): Product
    fun findByStoreId(storeId: UUID): List<Product>
    fun deleteById(id: UUID)
    fun findById(id: UUID): Product
}