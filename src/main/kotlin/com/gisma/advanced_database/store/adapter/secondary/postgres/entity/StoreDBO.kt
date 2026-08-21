package com.gisma.advanced_database.store.adapter.secondary.postgres.entity

import com.gisma.advanced_database.store.domain.model.Store
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "stores")
data class StoreDBO(
    @Id
    val id: UUID,
    val name: String,
    val isActive: Boolean,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {

    fun toDomain(): Store {
        return Store(
            id = this.id,
            name = this.name,
            isActive = this.isActive
        )
    }
}

fun Store.toDBO() = StoreDBO(
    id = this.id ?: UUID.randomUUID(),
    name = this.name!!,
    isActive = this.isActive!!,
    createdAt = LocalDateTime.now(),
    updatedAt = LocalDateTime.now()
)
