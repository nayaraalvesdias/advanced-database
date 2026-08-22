package com.gisma.advanced_database.customer.adapter.primary.web

class CustomerDomainNotFoundException(message: String) : Exception(message)

data class CustomerExceptionResponseEntity(
    val message: String
)

