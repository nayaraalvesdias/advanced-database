package com.gisma.advanced_database.store.domain.usecase

import com.gisma.advanced_database.store.domain.model.Product
import com.gisma.advanced_database.store.domain.port.primary.ProductPort
import com.gisma.advanced_database.store.domain.port.secondary.ProductDataAccessPort
import com.gisma.advanced_database.store.domain.port.secondary.StoreDataAccessPort
import java.util.UUID
import org.springframework.stereotype.Component

@Component
class ProductUseCase(
    private val productDataAccessPort: ProductDataAccessPort,
    private val storeDataAccessPort: StoreDataAccessPort
) : ProductPort {
    override fun create(
        storeId: UUID,
        product: Product
    ): Product {
        return storeDataAccessPort.findById(storeId)?.let {
            productDataAccessPort.save(product.copy(store = it))
        } ?: throw IllegalArgumentException("Store not found")
    }

    override fun findByStoreId(storeId: UUID): List<Product> {
        return productDataAccessPort.findByStoreId(storeId)
    }

    override fun deleteById(id: UUID) {
        productDataAccessPort.findById(id)?.let {
            productDataAccessPort.deleteById(id)
        } ?: throw IllegalArgumentException("Product not found")
    }

    override fun findById(id: UUID): Product {
        return productDataAccessPort.findById(id)
            ?: throw IllegalArgumentException("Product not found")
    }

    override fun update(id: UUID, productUpdateData: Product): Product {
        return productDataAccessPort.findById(id)?.let {
            productDataAccessPort.save(product = it.update(productUpdateData))
        } ?: throw IllegalArgumentException("Product not found")
    }
}