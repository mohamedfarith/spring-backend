package com.learning.ecommerceapp.ecommerceapp.controller

import com.learning.ecommerceapp.ecommerceapp.dto.Product
import com.learning.ecommerceapp.ecommerceapp.dto.ProductRequest
import com.learning.ecommerceapp.ecommerceapp.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/products")
class ProductController(private val productService: ProductService) {

    @PostMapping
    fun createProduct(@RequestBody request: ProductRequest): ResponseEntity<Product> {
        return ResponseEntity.ok(productService.createProduct(request))
    }

    @GetMapping
    fun getAllProducts(): ResponseEntity<List<Product>> {
        return ResponseEntity.ok(productService.getAllProducts())
    }
}