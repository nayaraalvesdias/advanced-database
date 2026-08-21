package com.gisma.advanced_database.store.adapter.primary.web.controller

import com.gisma.advanced_database.store.adapter.primary.web.dto.request.CreateStoreRequest
import com.gisma.advanced_database.store.adapter.primary.web.dto.request.StoreRequest
import com.gisma.advanced_database.store.adapter.primary.web.dto.response.StoreResponse
import com.gisma.advanced_database.store.adapter.primary.web.dto.response.toStoreResponse
import com.gisma.advanced_database.store.domain.port.primary.StorePort
import java.util.UUID
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/stores")
class StoreController(
    private val storePort: StorePort
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @RequestBody request: CreateStoreRequest
    ): StoreResponse = storePort.create(
        request.toDomain()
    ).toStoreResponse()

    @PatchMapping("/{id}")
    fun update(
        @PathVariable id: UUID,
        @RequestBody request: StoreRequest
    ): StoreResponse = storePort
        .update(
            id = id,
            storeUpdateData = request.toDomain()
        ).toStoreResponse()

    @GetMapping("{id}")
    fun getById(
        @PathVariable id: UUID
    ): StoreResponse = storePort.findById(id)!!.toStoreResponse()

    @GetMapping
    fun getAll(): List<StoreResponse> = storePort
        .findAll().map { it.toStoreResponse() }
}