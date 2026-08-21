package com.gisma.advanced_database.store.domain.port.primary

import com.gisma.advanced_database.store.domain.model.Store
import java.util.UUID

interface StorePort {
    fun create(store: Store): Store
    fun update(id: UUID, storeUpdateData: Store): Store
    fun findById(id: UUID): Store?
    fun deleteById(id: UUID)
    fun findAll(): List<Store>
}