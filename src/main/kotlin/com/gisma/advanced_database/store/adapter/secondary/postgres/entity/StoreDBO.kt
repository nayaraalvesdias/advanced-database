package com.gisma.advanced_database.store.adapter.secondary.postgres.entity

import com.gisma.advanced_database.customer.domain.model.Customer
import com.gisma.advanced_database.store.domain.model.Store
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "stores")
data class StoreDBO(
    @Id
    val id: UUID,

    ) {

    fun toDomain(): Store {
        return Store(
            id = this.id
        )
    }
}

fun Customer.toDBO(): StoreDBO = StoreDBO(
    id = this.id ?: UUID.randomUUID()
)