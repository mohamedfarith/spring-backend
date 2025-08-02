package com.learning.ecommerceapp.ecommerceapp.service

import com.learning.ecommerceapp.ecommerceapp.dto.Product
import com.learning.ecommerceapp.ecommerceapp.dto.ProductRequest
import com.learning.ecommerceapp.ecommerceapp.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) {

    fun createProduct(productRequest: ProductRequest): Product {

        val product = Product(name = productRequest.name, price = productRequest.price)
        return productRepository.save<Product>(product)
    }


    fun getAllProducts(): List<Product> = productRepository.findAll()
}