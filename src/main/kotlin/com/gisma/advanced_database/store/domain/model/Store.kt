package com.gisma.advanced_database.store.domain.model

import java.util.UUID

data class Store(
    val id: UUID? = null,
    val name: String? = null,
    val isActive: Boolean? = null,
) {
    fun update(storeUpdateData: Store) = this.copy(
        name = storeUpdateData.name ?: this.name,
        isActive = storeUpdateData.isActive ?: this.isActive
    )
}