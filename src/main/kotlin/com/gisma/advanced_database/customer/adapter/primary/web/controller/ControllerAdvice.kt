package com.gisma.advanced_database.customer.adapter.primary.web.controller

import com.gisma.advanced_database.customer.adapter.primary.web.CustomerDomainNotFoundException
import com.gisma.advanced_database.customer.adapter.primary.web.CustomerExceptionResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler
    fun handleNotFoundException(ex: CustomerDomainNotFoundException): ResponseEntity<CustomerExceptionResponseEntity> {
        val errorMessage = CustomerExceptionResponseEntity(message = ex.message!!)
        return ResponseEntity(errorMessage, HttpStatus.NOT_FOUND)
    }

}