package com.gisma.advanced_database.store.adapter.secondary.postgres.adapter

import com.gisma.advanced_database.store.adapter.secondary.postgres.repository.StoreRepository
import com.gisma.advanced_database.store.domain.model.Store
import com.gisma.advanced_database.store.domain.port.secondary.StoreDataAccessPort
import java.util.UUID
import org.springframework.stereotype.Component

@Component
class StoreAdapterAccess(
    private val storeRepository: StoreRepository
) : StoreDataAccessPort {
    override fun save(store: Store): Store {
        TODO("Not yet implemented")
    }

    override fun findById(id: UUID): Store? {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: UUID) {
        TODO("Not yet implemented")
    }

}