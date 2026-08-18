package com.gisma.advanced_database.store.domain.usecase

import com.gisma.advanced_database.store.domain.model.Product
import com.gisma.advanced_database.store.domain.port.primary.ProductPort
import com.gisma.advanced_database.store.domain.port.secondary.ProductDataAccessPort
import java.util.UUID
import org.springframework.stereotype.Component

@Component
class ProductUseCase(
    private val productDataAccessPort: ProductDataAccessPort
) : ProductPort {
    override fun create(
        store: UUID,
        product: Product
    ): Product {
        TODO("Not yet implemented")
    }

    override fun findByStoreId(storeId: UUID): List<Product> {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: UUID) {
        TODO("Not yet implemented")
    }
}