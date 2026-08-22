package com.gisma.advanced_database.store.adapter.primary.web.controller

import com.gisma.advanced_database.store.adapter.primary.web.StoreDomainNotFoundException
import com.gisma.advanced_database.store.adapter.primary.web.StoreExceptionResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class StoreControllerAdvice {

    @ExceptionHandler
    fun handleNotFoundException(ex: StoreDomainNotFoundException): ResponseEntity<StoreExceptionResponseEntity> {
        val errorMessage = StoreExceptionResponseEntity(message = ex.message!!)
        return ResponseEntity(errorMessage, HttpStatus.NOT_FOUND)
    }
}