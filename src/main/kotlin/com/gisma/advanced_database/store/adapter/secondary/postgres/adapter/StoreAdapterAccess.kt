package com.gisma.advanced_database.store.adapter.secondary.postgres.adapter

import com.gisma.advanced_database.store.adapter.secondary.postgres.entity.toDBO
import com.gisma.advanced_database.store.adapter.secondary.postgres.repository.StoreRepository
import com.gisma.advanced_database.store.domain.model.Store
import com.gisma.advanced_database.store.domain.port.secondary.StoreDataAccessPort
import java.util.UUID
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class StoreAdapterAccess(
    private val storeRepository: StoreRepository
) : StoreDataAccessPort {
    override fun save(store: Store): Store {
        return storeRepository.save(store.toDBO()).toDomain()
    }

    override fun findById(id: UUID): Store? {
        return storeRepository.findByIdOrNull(id)?.toDomain()
    }

    override fun deleteById(id: UUID) {
        storeRepository.deleteById(id)
    }

    override fun findAll(): List<Store> {
        return storeRepository.findAll().map { it.toDomain() }
    }
}