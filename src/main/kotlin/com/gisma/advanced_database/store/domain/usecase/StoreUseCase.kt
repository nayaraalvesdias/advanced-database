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
        return storeDataAccessPort.save(store)
    }

    override fun update(
        id: UUID,
        storeUpdateData: Store
    ): Store {
        return storeDataAccessPort.findById(id)?.let {
            storeDataAccessPort.save(store = it.update(storeUpdateData))
        } ?: throw IllegalArgumentException("Store with id $id not found")
    }

    override fun findById(id: UUID): Store {
        return storeDataAccessPort.findById(id)
            ?: throw IllegalArgumentException("Store with id $id not found")
    }

    override fun findAll(): List<Store> {
        return storeDataAccessPort.findAll()
    }

    override fun deleteById(id: UUID) {
        storeDataAccessPort.findById(id)?.let {
            storeDataAccessPort.deleteById(id)
        } ?: throw IllegalArgumentException("Store with id $id not found")
    }
}