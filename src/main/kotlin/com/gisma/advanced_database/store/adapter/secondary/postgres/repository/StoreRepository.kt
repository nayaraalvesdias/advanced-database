package com.gisma.advanced_database.store.adapter.secondary.postgres.repository

import com.gisma.advanced_database.store.adapter.secondary.postgres.entity.StoreDBO
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StoreRepository : JpaRepository<StoreDBO, UUID> {
}