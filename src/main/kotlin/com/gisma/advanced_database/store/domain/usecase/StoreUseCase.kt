package com.gisma.advanced_database.store.domain.usecase

import com.gisma.advanced_database.store.domain.model.Store
import com.gisma.advanced_database.store.domain.port.primary.StorePort
import com.gisma.advanced_database.store.domain.port.secondary.StoreDataAccessPort
import java.util.UUID
import org.springframework.stereotype.Component

@Component
class StoreUseCase(
    private val storeDataAccessPort: StoreDataAccessPort
) : StorePort {
    override fun create(store: Store): Store {
        TODO("Not yet implemented")
    }

    override fun update(
        id: UUID,
        store: Store
    ): Store {
        TODO("Not yet implemented")
    }

    override fun findById(id: UUID): Store? {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: UUID) {
        TODO("Not yet implemented")
    }

}