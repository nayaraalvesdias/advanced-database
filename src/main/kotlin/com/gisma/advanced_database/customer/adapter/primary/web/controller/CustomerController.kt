package com.gisma.advanced_database.customer.adapter.primary.web.controller

import com.gisma.advanced_database.customer.adapter.primary.web.dto.request.CreateCustomerRequest
import com.gisma.advanced_database.customer.adapter.primary.web.dto.request.UpdateCustomerRequest
import com.gisma.advanced_database.customer.adapter.primary.web.dto.response.CreateCustomerResponse
import com.gisma.advanced_database.customer.adapter.primary.web.dto.response.CustomerResponse
import com.gisma.advanced_database.customer.adapter.primary.web.dto.response.toCreateCustomerResponse
import com.gisma.advanced_database.customer.adapter.primary.web.dto.response.toCustomerResponse
import com.gisma.advanced_database.customer.domain.port.primary.CustomerPort
import java.util.UUID
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomerController(
    private val customerPort: CustomerPort
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @RequestBody request: CreateCustomerRequest
    ): CreateCustomerResponse = customerPort
        .create(request.toDomain())
        .toCreateCustomerResponse()

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    fun update(
        @PathVariable id: UUID,
        @RequestBody request: UpdateCustomerRequest
    ): CreateCustomerResponse = customerPort.update(
        id = id,
        customerUpdateData = request.toDomain()
    ).toCreateCustomerResponse()

    @GetMapping("/{id}")
    fun getById(
        @PathVariable id: UUID
    ): CustomerResponse = customerPort.findById(id)!!.toCustomerResponse()

    @DeleteMapping("/{id}")
    fun deleteById(
        @PathVariable id: UUID
    ) {
        customerPort.deleteById(id)
    }
}