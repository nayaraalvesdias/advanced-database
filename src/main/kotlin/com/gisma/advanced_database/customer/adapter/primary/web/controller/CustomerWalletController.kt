package com.gisma.advanced_database.customer.adapter.primary.web.controller

import com.gisma.advanced_database.customer.adapter.primary.web.dto.request.CreateCardRequest
import com.gisma.advanced_database.customer.adapter.primary.web.dto.response.CustomerWalletCardResponse
import com.gisma.advanced_database.customer.adapter.primary.web.dto.response.toCustomerCreateCardResponse
import com.gisma.advanced_database.customer.adapter.primary.web.dto.response.toCustomerResponse
import com.gisma.advanced_database.customer.domain.port.primary.CustomerWalletPort
import java.util.UUID
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomerWalletController(
    private val customerWalletPort: CustomerWalletPort
) {

    @PostMapping("/{customerId}/wallet-cards")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @PathVariable customerId: UUID,
        @RequestBody request: CreateCardRequest
    ) = customerWalletPort.create(
        customerId, request.toDomain()
    ).toCustomerCreateCardResponse()

    @GetMapping("/{customerId}/wallets")
    fun getById(
        @PathVariable customerId: UUID
    ): List<CustomerWalletCardResponse> = customerWalletPort
        .findByCustomerId(customerId)
        .toCustomerResponse()

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/wallets/{id}")
    fun deleteById(
        @PathVariable id: UUID
    ) {
        customerWalletPort.deleteById(id)
    }
}