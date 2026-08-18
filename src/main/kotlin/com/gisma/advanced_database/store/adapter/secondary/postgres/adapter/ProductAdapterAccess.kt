package com.gisma.advanced_database.store.adapter.secondary.postgres.adapter

import com.gisma.advanced_database.store.adapter.secondary.postgres.repository.ProductRepository
import com.gisma.advanced_database.store.domain.model.Product
import com.gisma.advanced_database.store.domain.port.secondary.ProductDataAccessPort
import java.util.UUID
import org.springframework.stereotype.Component

@Component
class ProductAdapterAccess(
    private val productRepository: ProductRepository
) : ProductDataAccessPort {
    override fun save(product: Product): Product {
        TODO("Not yet implemented")
    }

    override fun findByCustomerId(storeId: UUID): List<Product> {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: UUID) {
        TODO("Not yet implemented")
    }

    override fun findById(id: UUID): Product? {
        TODO("Not yet implemented")
    }


}