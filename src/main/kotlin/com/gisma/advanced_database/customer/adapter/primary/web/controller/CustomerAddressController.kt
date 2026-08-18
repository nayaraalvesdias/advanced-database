package com.gisma.advanced_database.customer.adapter.primary.web.controller

import com.gisma.advanced_database.customer.adapter.primary.web.dto.request.CustomerAddressRequest
import com.gisma.advanced_database.customer.adapter.primary.web.dto.request.UpdateCustomerAddressRequest
import com.gisma.advanced_database.customer.adapter.primary.web.dto.response.CreateCustomerAddressResponse
import com.gisma.advanced_database.customer.adapter.primary.web.dto.response.CustomerAddressResponse
import com.gisma.advanced_database.customer.adapter.primary.web.dto.response.toCreateCustomerAddressResponse
import com.gisma.advanced_database.customer.adapter.primary.web.dto.response.toCustomerAddressResponse
import com.gisma.advanced_database.customer.domain.port.primary.CustomerAddressPort
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
class CustomerAddressController(
    private val customerAddressPort: CustomerAddressPort
) {

    @PostMapping("/{customerId}/addresses")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @PathVariable customerId: UUID,
        @RequestBody request: CustomerAddressRequest
    ): CreateCustomerAddressResponse = customerAddressPort
        .create(customerId = customerId, request.toDomain())
        .toCreateCustomerAddressResponse()

    @PatchMapping("/addresses/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(
        @PathVariable id: UUID,
        @RequestBody request: UpdateCustomerAddressRequest
    ): CustomerAddressResponse = customerAddressPort.update(
        id = id,
        customerAddress = request.toDomain()
    ).toCustomerAddressResponse()

    @GetMapping("/{id}/addresses")
    fun getByCustomerId(
        @PathVariable id: UUID
    ): List<CustomerAddressResponse> = customerAddressPort
        .findByCustomerId(id)!!
        .toCustomerAddressResponse()

    @GetMapping("/addresses/{id}")
    fun getById(
        @PathVariable id: UUID
    ): CustomerAddressResponse = customerAddressPort
        .findById(id)
        .toCustomerAddressResponse()

    @DeleteMapping("/addresses/{id}")
    fun deleteById(
        @PathVariable id: UUID
    ) {
        customerAddressPort.deleteById(id)
    }
}