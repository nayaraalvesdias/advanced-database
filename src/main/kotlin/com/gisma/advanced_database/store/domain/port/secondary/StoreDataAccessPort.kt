package com.gisma.advanced_database.store.domain.port.secondary

import com.gisma.advanced_database.store.domain.model.Store
import java.util.UUID

interface StoreDataAccessPort {
    fun save(store: Store): Store
    fun findById(id: UUID): Store?
    fun deleteById(id: UUID)
    fun findAll(): List<Store>
}