package com.gisma.advanced_database.store.adapter.secondary.postgres.adapter

import com.gisma.advanced_database.store.adapter.secondary.postgres.entity.toDBO
import com.gisma.advanced_database.store.adapter.secondary.postgres.repository.ProductRepository
import com.gisma.advanced_database.store.domain.model.Product
import com.gisma.advanced_database.store.domain.port.secondary.ProductDataAccessPort
import java.util.UUID
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class ProductAdapterAccess(
    private val productRepository: ProductRepository
) : ProductDataAccessPort {
    override fun save(product: Product): Product {
        return productRepository.save(product.toDBO()).toDomain()
    }

    override fun findByStoreId(storeId: UUID): List<Product> {
        return productRepository.findByStoreId(storeId).map { it.toDomain() }
    }

    override fun deleteById(id: UUID) {
        productRepository.findByIdOrNull(id)?.let { productRepository.deleteById(id) }
            ?: throw IllegalArgumentException("to do")
    }

    override fun findById(id: UUID): Product? =
        productRepository.findByIdOrNull(id)?.toDomain()
}