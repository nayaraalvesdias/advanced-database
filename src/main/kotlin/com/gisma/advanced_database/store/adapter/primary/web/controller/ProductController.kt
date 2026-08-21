package com.gisma.advanced_database.store.adapter.primary.web.controller

import com.gisma.advanced_database.store.adapter.primary.web.dto.request.CreateProductRequest
import com.gisma.advanced_database.store.adapter.primary.web.dto.request.ProductRequest
import com.gisma.advanced_database.store.adapter.primary.web.dto.response.toProductResponse
import com.gisma.advanced_database.store.domain.port.primary.ProductPort
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
class ProductController(
    private val productPort: ProductPort
) {
    @PostMapping("/{storeId}/products")
    @ResponseStatus(HttpStatus.CREATED)
    fun createProduct(
        @PathVariable storeId: UUID,
        @RequestBody request: CreateProductRequest
    ) = productPort.create(
        storeId = storeId, product = request.toDomain()
    ).toProductResponse()

    @GetMapping("/{storeId}/products")
    fun getProducts(
        @PathVariable storeId: UUID
    ) = productPort.findByStoreId(storeId).map { it.toProductResponse() }

    @GetMapping("/products/{id}")
    fun getProduct(
        @PathVariable id: UUID
    ) = productPort.findById(id).toProductResponse()

    @PatchMapping("/products/{id}")
    fun updateProduct(
        @PathVariable id: UUID,
        @RequestBody request: ProductRequest
    ) = productPort.update(
        id = id,
        productUpdateData = request.toDomain()
    ).toProductResponse()
}