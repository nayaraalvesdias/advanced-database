package com.gisma.advanced_database.store.adapter.primary.web.dto.request

import com.gisma.advanced_database.store.domain.model.Store

data class StoreRequest(
    val name: String? = null,
    val isActive: Boolean? = null
) {
    fun toDomain(): Store = Store(
        name = name,
        isActive = isActive
    )
}

