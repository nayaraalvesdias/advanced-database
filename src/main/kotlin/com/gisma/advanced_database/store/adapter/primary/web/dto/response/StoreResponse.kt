package com.gisma.advanced_database.store.adapter.primary.web.dto.response

import com.gisma.advanced_database.store.domain.model.Store
import java.util.UUID

data class StoreResponse(
    val id: UUID,
    val name: String? = null,
    val isActive: Boolean? = null
)

fun Store.toStoreResponse() = StoreResponse(
    id = id!!,
    isActive = isActive,
    name = name
)
