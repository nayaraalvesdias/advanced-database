package com.gisma.advanced_database.store.adapter.primary.web.dto.response

import com.gisma.advanced_database.store.domain.model.Store
import java.util.UUID

data class StoreResponse(
    val id: UUID,

    )

fun Store.toStoreResponse() = StoreResponse(
    id = id!!,
)
