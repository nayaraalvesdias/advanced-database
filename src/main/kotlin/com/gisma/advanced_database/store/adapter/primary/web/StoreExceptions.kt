package com.gisma.advanced_database.store.adapter.primary.web

class StoreDomainNotFoundException(message: String) : Exception(message)

data class StoreExceptionResponseEntity(
    val message: String
)

