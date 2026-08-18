package com.gisma.advanced_database.store.domain.port.secondary

import com.gisma.advanced_database.store.domain.model.Product
import java.util.UUID

interface ProductDataAccessPort {
    fun save(product: Product): Product
    fun findByCustomerId(storeId: UUID): List<Product>
    fun deleteById(id: UUID)
    fun findById(id: UUID): Product?
}