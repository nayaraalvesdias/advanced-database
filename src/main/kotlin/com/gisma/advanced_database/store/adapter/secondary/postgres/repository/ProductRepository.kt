package com.gisma.advanced_database.store.adapter.secondary.postgres.repository

import com.gisma.advanced_database.store.adapter.secondary.postgres.entity.ProductDBO
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<ProductDBO, UUID> {
    fun findByStoreId(storeId: UUID): List<ProductDBO>
}